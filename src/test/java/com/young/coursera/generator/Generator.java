package com.young.coursera.generator;

import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;


public class Generator {
    public static final Logger log = LoggerFactory.getLogger(Generator.class);

    public static void main(String[] args) throws IOException {

        initMybatisGeneratorConfig("shopping_00", "city");

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

    private static void initMybatisGeneratorConfig(String tableName, String modelName) {

        Context context = new Context(ModelType.FLAT);
        context.setId("MyBatis3Simple");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_JAVA_FILE_ENCODING, "UTF-8");

        Properties properties = readProperty();

        Stream.of(properties.getProperty("plugin").split(",")).forEach(plugin -> {
            PluginConfiguration pluginConfiguration = new PluginConfiguration();
            pluginConfiguration.setConfigurationType(plugin);
            context.addPluginConfiguration(pluginConfiguration);
        });

        //配置MBG要连接的数据库信息
        JDBCConnectionConfiguration jdbcConnection = new JDBCConnectionConfiguration();
        jdbcConnection.setConnectionURL(properties.getProperty("jdbc.connectionURL"));
        jdbcConnection.setUserId(properties.getProperty("jdbc.userId"));
        jdbcConnection.setPassword(properties.getProperty("jdbc.password"));
        jdbcConnection.setDriverClass(properties.getProperty("jdbc.driverClass"));
        context.setJdbcConnectionConfiguration(jdbcConnection);

        //配置MBG生成DO的注释信息
        CommentGeneratorConfiguration commentGenerator = new CommentGeneratorConfiguration();
        commentGenerator.addProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE, "true");
        commentGenerator.addProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS, "true");
        commentGenerator.addProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS, "true");
        commentGenerator.setConfigurationType(properties.getProperty("comment.generator"));
        context.setCommentGeneratorConfiguration(commentGenerator);

        JavaModelGeneratorConfiguration javaModelGenerator = new JavaModelGeneratorConfiguration();
        javaModelGenerator.setTargetProject(properties.getProperty("java-model.project"));
        javaModelGenerator.setTargetPackage(String.format(properties.getProperty("java-model.package"), modelName));
        context.setJavaModelGeneratorConfiguration(javaModelGenerator);

        SqlMapGeneratorConfiguration sqlMapGenerator = new SqlMapGeneratorConfiguration();
        sqlMapGenerator.setTargetProject(properties.getProperty("sql-map.project"));
        sqlMapGenerator.setTargetPackage(properties.getProperty("sql-map.package"));
        context.setSqlMapGeneratorConfiguration(sqlMapGenerator);

        JavaClientGeneratorConfiguration javaClientGenerator = new JavaClientGeneratorConfiguration();
        javaClientGenerator.setConfigurationType("MAPPER"); //MAPPER、 ANNOTATEDMAPPER、XMLMAPPER，
        javaClientGenerator.setTargetProject(properties.getProperty("java-mapper.project"));
        javaClientGenerator.setTargetPackage(String.format(properties.getProperty("java-mapper.package"), modelName));
        context.setJavaClientGeneratorConfiguration(javaClientGenerator);

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        context.addTableConfiguration(tableConfiguration);

        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;

        try {
            Configuration config = new Configuration();
            config.addContext(context);
            config.validate();

            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            log.error("Fail to generate Model and Mapper: {}", e.getMessage(), e);
        }
        warnings.forEach(msg -> log.warn("warning: {}", msg));

    }

}

