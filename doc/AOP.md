# AOP面向切面编程

- @AfterReturning 获取返回报文


> 实现过程

- 导入spring-boot-starter-aop包
- 创建处理文件 aspect 包


> tips

- 引入@Aspect @Component 注解
- 直接使用@After 等进行定义
- 批量可以使用@Pointcut定义统一控制器切点，可使用通配符
- 感觉定义在上面的要靠后些