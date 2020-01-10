# 多数据库源

### 依赖
	<dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>dynamic-datasource-spring-boot-starter</artifactId>
        <version>2.1.1</version>
    </dependency>

### application.properties
    spring.datasource.dynamic.primary=master
    spring.datasource.dynamic.datasource.master.url=jdbc:mysql://localhost:3306/test?serverTimezone=CTT&useUnicode=true&characterEncoding=utf8
    spring.datasource.dynamic.datasource.master.username=root
    spring.datasource.dynamic.datasource.master.password=root
    spring.datasource.dynamic.datasource.master.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.dynamic.datasource.slave.url=jdbc:mysql://localhost:3306/test2?serverTimezone=CTT&useUnicode=true&characterEncoding=utf8
    spring.datasource.dynamic.datasource.slave.username=root
    spring.datasource.dynamic.datasource.slave.password=root
    spring.datasource.dynamic.datasource.slave.driver-class-name=com.mysql.cj.jdbc.Driver

### 注解
    @DS(value = "master")
    @DS(value = "slave")
  
### 测试
    http://localhost:8080/mds/user/queryUserList1
    http://localhost:8080/mds/user/queryUserList2

### SQL文件
    master.sql
    slave.sql