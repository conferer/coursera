package com.young.coursera.core.mybatis.plugin;

import com.young.coursera.core.lang.BaseEntity;
import com.young.coursera.core.lang.Entity;
import com.young.coursera.core.lang.SnowflakeId;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.time.Instant;
import java.util.Objects;

@Slf4j
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class EntityAuditInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        SqlCommandType sqlCommandType = null;
        for (Object arg : args) {
            if (arg instanceof MappedStatement statement) {
                sqlCommandType = statement.getSqlCommandType();
                continue;
            }
            if (arg instanceof Entity entity) {
                Instant now = Instant.now();
                if (Objects.equals(SqlCommandType.INSERT, sqlCommandType)) {
                    setFieldValByName("id", SnowflakeId.generate(), entity);
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


    protected void setFieldValByName(String fieldName, Object fieldVal, Entity entity) {
        MetaObject metaObject = SystemMetaObject.forObject(entity);
        if (Objects.nonNull(fieldVal) && metaObject.hasSetter(fieldName)) {
            metaObject.setValue(fieldName, fieldVal);
        } else {
            log.warn("{}'s {} is null, ignore auto fill", entity.getClass().getSimpleName(), fieldName);
        }
    }
}
