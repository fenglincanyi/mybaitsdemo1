## mybatis 基础
### mybatis 介绍
mybatis 是一个持久层框架，是apache下的开源项目。
它是一个半自动化框架，与Hibernate相比，需要开发者手动写sql，这样更为灵活配置
mybatis 可以将PreparedStatement 中输入的参数自动进行输入映射，将查询结果灵活映射成 Java 对象
### 基本原理
```flow
st=>start: mybatisconfig.xml/mapper.xml
e=>end: db
op=>operation: SqlSessionFactory
op1=>operation: SqlSession
op1=>operation: Executor
op2=>operation: mapper statement
st->op->op1->op2->e
```