# A free and open-source online learning platform

### Introduction

This project aims to build a free and open-source learning platform from scratch,
mainly to practice the best practices of MyBatis, and create a user-friendly and scalable system

### Technology stack

| name              | version |
|-------------------|---------|
| jdk               | 17      |
| Spring boot       | 3.0.4   |
| Spring framework  | 6.0.6   |
| Spring Security   | 6.0.2   |
| MyBatis Framework | 3.5.11  |
| Spring doc        | 2.0.4   |

### Mybatis generator

1. generator mbg mysql account

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

| default name       | configured name | description                                                        |
|--------------------|-----------------|--------------------------------------------------------------------|
| selectByPrimaryKey | selectById      | Replace `selectByPrimaryKey()` with selectById() in xxxMapper.java |
| deleteByPrimaryKey | deleteById      | Replace `deleteByPrimaryKey()` with deleteById() in xxxMapper.java |
| updateByPrimaryKey | update          | Replace `updateByPrimaryKey()` with update() in xxxMapper.java     |

### Best practices for infrastructure based on numerous projects.

1. `com.young.coursera.core.lang` contains lots of basics infrastructure like

| module     | description                                                                                                        |
|------------|--------------------------------------------------------------------------------------------------------------------|
| Query      | List query obj support multi `order fields`                                                                        |
| PageQuery  | Page List query obj support `pageNo` and `pageSize`                                                                |
| BaseEntity | BaseEntity contains `id` and `create_time` and `update_time` , all of your tables recommended to have these fields |
| Page       | Page wrapper obj that pagination info                                                                              |
| Result     | Result wrapper obj contains response `code` and response `msg`                                                     |
| Err        | common error interface                                                                                             |

2. `com.young.coursera.core.exception` Provided an out-of-the-box exception framework.

ServiceException support using `Err` provide error business message, also you can using `Object[] args` provide external msg

- ServiceException(Err err)
- ServiceException(String msg)
- ServiceException(String)

By using `Asserts` enable you simplify using `ServiceException`

```java
//throw new ServiceException(CommonError.NOT_FOUND) if city is null
Asserts.notNull(city,CommonError.NOT_FOUND);
```

### Service/Mapper 层方法命名规约

在方法命名中，一般使用动词+名词的方式来描述该方法的作用。同时，在方法命名时，也要注意以下几点：

名称要简单易懂，能够直接表达出方法的作用。
尽量使用常见的单词和表达方式，方便其他开发人员理解。
遵循团队或公司内部的规范，保证代码风格的统一性。

参考 Spring data Jpa 规范，通用接口设计如下

```shell
insert
update
findById
findList / findAll
findPage / findAllForPage
```

1. 新增修改

- insert(Entity entity)
- update(Entity entity)
- batchInsert(List<Entity> entities)
- batchUpdate(List<Entity> entities)

---

2. 查询单个对象

- findById(Long id)

---

3. 查询多个对象

- findAll(Query query)
- findAll(PageQuery query) / pageAll(PageQuery query)
- findAllById(List<Long> ids)
- count(Query query)

---

4. 删除

- delete(Entity entity)
- deleteById(Long id)
- deleteAll()
- deleteAllById(List<Long> ids)

---

5. 发布单个对象

- publish(Long id, Boolean flag)

---

- checkUserName(Long id, String name)
- enableUser(Long id)
- disableUser(Long id)
- existById(Long id)

#### db

1. course

- [ ] course  
  - [ ] create 后台-创建
  - [ ] update 后台-更新
  - [ ] delete 后台-删除
  - [ ] get 后台-查询
  - [ ] getByUid 前台-查询
  - [ ] findAll 后台-查询
  - [ ] search 前台-查询
  - [ ] publish 后台-发布
  - [ ] undoPublish 后台-取消发布
  - [ ] recommend 后台-推荐
  - [ ] undoRecommend 后台-取消推荐
  - [ ] close 后台-关闭课程
- [ ] course_lesson
- [ ] course_member
- [ ] course_note
- [ ] course_comment
- [ ] course_favorite

2. lesson

- [ ] lesson_media

3. user

- [ ] user
- [ ] user_role

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
