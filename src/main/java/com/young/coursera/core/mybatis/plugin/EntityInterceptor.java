package com.young.coursera.core.mybatis.plugin;

import com.young.coursera.core.persist.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.time.Instant;
import java.util.Objects;
import java.util.Properties;

@Slf4j
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class EntityInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        SqlCommandType sqlCommandType = null;
        for (Object arg : args) {
            if (arg instanceof MappedStatement) {
                MappedStatement statement = (MappedStatement) arg;
                sqlCommandType = statement.getSqlCommandType();
                continue;
            }
            if (arg instanceof BaseEntity) {
                BaseEntity entity = (BaseEntity) arg;
                Instant now = Instant.now();
                if (Objects.equals(SqlCommandType.INSERT, sqlCommandType)) {
                    setFieldValByName("createTime", now, entity);
                    setFieldValByName("updateTime", now, entity);
                    log.trace("mybatis intercept class for createdTime: {} ", arg.getClass().getSimpleName());
                } else if (Objects.equals(SqlCommandType.UPDATE, sqlCommandType)) {
                    setFieldValByName("updateTime", now, entity);
                    log.trace("mybatis intercept class for createdTime: {} ", arg.getClass().getSimpleName());
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }


    protected void setFieldValByName(String fieldName, Object fieldVal, BaseEntity entity) {
        MetaObject metaObject = SystemMetaObject.forObject(entity);
        if (Objects.nonNull(fieldVal) && metaObject.hasSetter(fieldName)) {
            metaObject.setValue(fieldName, fieldVal);
        }
    }
}
