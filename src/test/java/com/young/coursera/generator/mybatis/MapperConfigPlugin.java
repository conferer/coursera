package com.young.coursera.generator.mybatis;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class MapperConfigPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        introspectedTable.setSelectByPrimaryKeyStatementId("selectById");// 详情接口方法名
        introspectedTable.setDeleteByPrimaryKeyStatementId("deleteById");// 删除接口方法名
        introspectedTable.setUpdateByPrimaryKeyStatementId("update");// 更新接口方法名

        topLevelClass.addImportedType("lombok.Data");// lombok
        topLevelClass.addImportedType("lombok.NoArgsConstructor");// lombok
        topLevelClass.addImportedType("io.swagger.v3.oas.annotations.media.Schema");// swagger
        topLevelClass.addAnnotation("@Data");// lombok
        topLevelClass.addAnnotation("@Schema(description=" + "\"替换区\"" + ")");// lombok
        topLevelClass.addAnnotation("@NoArgsConstructor");// lombok
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
}