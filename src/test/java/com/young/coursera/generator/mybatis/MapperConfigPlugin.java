package com.young.coursera.generator.mybatis;

import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class MapperConfigPlugin extends PluginAdapter {
    public static final Logger log = LoggerFactory.getLogger(MapperConfigPlugin.class);

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        introspectedTable.setSelectAllStatementId("findAll"); // 查找所有接口方法名
        introspectedTable.setSelectByPrimaryKeyStatementId("findById");// 详情接口方法名
        introspectedTable.setDeleteByPrimaryKeyStatementId("deleteById");// 删除接口方法名
        introspectedTable.setUpdateByPrimaryKeyStatementId("update");// 更新接口方法名

        topLevelClass.addImportedType("lombok.Data");// lombok
        topLevelClass.addImportedType("lombok.NoArgsConstructor");// lombok
        topLevelClass.addImportedType("io.swagger.v3.oas.annotations.media.Schema");// swagger
        topLevelClass.addImportedType(readProperty().getProperty("java-model.super.interface"));// entity interface
        topLevelClass.addAnnotation("@Data");// lombok
        topLevelClass.addAnnotation("@Schema(description=\"" + topLevelClass.getType().getShortName().toLowerCase() + "\")");// lombok
        topLevelClass.addAnnotation("@NoArgsConstructor");// lombok

        topLevelClass.addSuperInterface(new FullyQualifiedJavaType("Entity"));

        List<IntrospectedColumn> allColumns = introspectedTable.getAllColumns();
        for (IntrospectedColumn column : allColumns) {
            if (column.getJdbcTypeName().equals("TIMESTAMP")) {
                topLevelClass.addImportedType("com.fasterxml.jackson.annotation.JsonFormat");// 日期序列化
                return true;
            }
        }
        return true;
    }


    @Override
    public boolean clientGenerated(Interface interfaze, IntrospectedTable introspectedTable) {

        if (!Objects.equals(introspectedTable.getTargetRuntime(), IntrospectedTable.TargetRuntime.MYBATIS3_DSQL)) {
            // don't need to do this for MYBATIS3_DSQL as that runtime already adds this annotation
            interfaze.addImportedType(
                    new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper")); //$NON-NLS-1$
            interfaze.addAnnotation("@Mapper"); //$NON-NLS-1$
        }
        return true;
    }


    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return true;
    }

    /**
     * read generator.properties
     *
     * @return Properties
     */
    private static Properties readProperty() {
        Properties prop = new Properties();
        try {
            InputStream inputStream = Resources.getResourceAsStream("generator.properties");
            prop.load(inputStream);
            return prop;
        } catch (IOException e) {
            log.info("Error when read properties: {}", e.getMessage(), e);
            return prop;
        }
    }
}