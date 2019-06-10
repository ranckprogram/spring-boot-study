# Spring Data

提供一致的方式简化数据库的访问

减少数据访问层的开发量

申明持久层的接口


### Spring Data 常用模块

- Spring Data Jpa
- Spring Data Mongo DB
- Spring Data Redis
- Spring Data Solr（搜索功能）



### 传统JDBC试试

- JDBC
- Spring JDBC Template

### spring data 核心接口

- Repository (仓库)
- JpaRepository （ctrl+t出奇迹）
- JpaSpecificationExecutor（复杂条件查询）

重点：在继承Repository后的定义方法名很讲究

> 自定义查询@Query

- [ ] 原生查询
- [ ] 对象查询
---
- [x] 命名参数
- [ ] 索引参数



### 事务

通常查询无所谓，如果涉及写入就要考虑事务，涉及事务放在service层

在@Query注解中编写JPQL实现DELETE和UPDATE操作的时候必须加上@modifying注解，以通知Spring Data 这是一个DELETE或UPDATE操作。



没有包含方法申明的接口，标记接口

### 问题

- JPA 能不能多表组合查询呢