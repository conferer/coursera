package com.young.coursera.generator.mybatis;

@Deprecated
public class ProjectConstant {
    public static final String BASE_PACKAGE = "com.fyeeme.quasar";

    //生成的Entity所在包
    public static String modelPackage(String model) {
        return String.format("%s.%s.entity", BASE_PACKAGE, model);
    }

    //生成的Dto所在包
    public static String dtoPackage(String model) {
        return String.format("%s.%s.dto", BASE_PACKAGE, model);
    }

    //生成的Mapper所在包
    public static String repositoryPackage(String module) {
        return String.format("%s.%s.repository", BASE_PACKAGE, module);
    }

    //生成的Service所在包
    public static String servicePackage(String module) {
        return String.format("%s.%s.service", BASE_PACKAGE, module);
    }

    //生成的Controller所在包
    public static String controllerPackage(String module) {
        return String.format("%s.%s.controller", BASE_PACKAGE, module);
    }
}
