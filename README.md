# A SpringBoot Demo from Sunday

## TODO
- 热部署
- redis & memcache
- 登录相关信息存储到redis中，基类

## DONE
- mybatis sql日志打印到文件 debug模式下
- mybatis update多个参数用注解方式如何使用
- 返回结果的规范性封装
- 日志调整，日志等级
- 邮件发送

## swaggerui
http://127.0.0.1:9999/swagger-ui.html

## druid
http://localhost:9999/druid/datasource.html  
admin 123456

http://localhost:9999/druid2/datasource.html  
admin2 123456

## Sql语句
```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试User表';
```
