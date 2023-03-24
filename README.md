# A free and open-source online learning platform

### Introduction

This project aims to build a free and open-source learning platform from scratch,
mainly to practice the best practices of MyBatis, and create a user-friendly and scalable system

### Technology stack

| name              | version |
| ----------------- | ------- |
| jdk               | 17      |
| Spring boot       | 3.0.4   |
| Spring framework  | 6.0.6   |
| Spring Security   | 6.0.2   |
| MyBatis Framework | 3.5.11  |
| Spring doc        | 2.0.4   |

### Mybatis generator

1.  generator mbg mysql account

```mysql
CREATE USER 'coursera'@'localhost' IDENTIFIED BY 'coursera';
GRANT ALL PRIVILEGES ON coursera. * TO 'coursera'@'localhost';
```

2. update config

`src/test/resources/generator.properties`

- support jdbc connection
- support update `sql-map`、 `java-model`, `java-mapper`
- support module base construct like `com.young.placeholder.entity` and `com.young.placeholder.mapper`

3. support rewrite introspectedTable config

default rewrite rule:

- pre selectByPrimaryKey -> selectById $~~~~~~~~~~~$// Replace `selectByPrimaryKey()` with selectById() in xxxMapper.java
- deleteByPrimaryKey -> deleteById $~~~~~~~~~~~$// Replace `deleteByPrimaryKey()` with deleteById() in xxxMapper.java
- updateByPrimaryKey -> update $~~~~~~~~~~~$// Replace `updateByPrimaryKey()` with update() in xxxMapper.java

### Best practices for infrastructure based on numerous projects.

1. `com.young.coursera.core.lang` contains lots of basics infrastructure like

- Query $~~~~~~~~~~~$// List query obj support multi `order fields`
- PageQuery $~~~~~~~~~~~$// Page List query obj support `pageNo` and `pageSize`
- BaseEntity $~~~~~~~~~~~$// BaseEntity contains `id` and `create_time` and `update_time` , all of your tables recommended to have these fields
- Page $~~~~~~~~~~~$// Page wrapper obj that pagination info
- Result $~~~~~~~~~~~$ //Result wrapper obj contains response `code` and response `msg`
- Err $~~~~~~~~~~~$ // common error interface

2. `com.young.coursera.core.exception` Provided an out-of-the-box exception framework.

ServiceException support using `Err` provide error business message, also you can using `Object[] args` provide external msg

- ServiceException(Err err)
- ServiceException(String msg)
- ServiceException(String)

By using `Asserts` enable you simplify using `ServiceException`

```java
//throw new ServiceException(CommonError.NOT_FOUND) if city is null
Asserts.notNull(city, CommonError.NOT_FOUND);
```


#### db

- course
- course_lesson

- lesson_media
- course_member
- course_note
- course_comment
- course_favorite

- user
- user_role



### Reference Documentation

For further reference, please consider the following sections:

- [Official Gradle documentation](https://docs.gradle.org)
- [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.4/gradle-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.4/gradle-plugin/reference/html/#build-image)
- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#using.devtools)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#web)
- [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
- [Spring Security](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#web.security)

### Guides

The following guides illustrate how to use some features concretely:

- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
- [MyBatis Quick Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start)
- [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
- [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
- [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
- [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

### Additional Links

These additional references should also help you:

- [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
