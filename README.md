## 跨境电商交易平台

### [项目介绍](http://www.cnsoftbei.com/bencandy.php?fid=151&aid=1616)

#### 组织结构
```$xslt
change
|—— change-admin
|       |—— change-admin-user[9990] '用户管理子系统
|       |—— change-admin-upms[9991] '权限管理子系统'
|       |—— change-admin-product[9992] '商品管理子系统'
|       |—— change-admin-storehouse[9993] '仓库管理子系统'
|       |—— change-admin-order[9994] '订单管理子系统'
|
|—— change-api
|       |—— change-api-dao 'dao接口'
|       |—— change-api-rpc-server 'rpc远程服务接口'
|
|—— change-common '公共模块'
|—— change-config '配置模块'
|       |—— change-config-dao
|       |—— change-config-rpc-server 'rpc远程服务配置'
|
|—— change-user '用户模块'
|       |—— change-user-bean
|       |—— change-user-dao
|       |—— change-user-rpc-server
|
|—— change-upms '权限模块'
|       |—— change-upms-sso 'Spring Session + Spring MVC 拦截器实现的单点登录、权限控制'
|       |—— change-upms-bean
|       |—— change-upms-dao
|       |—— change-upms-rpc-server
|
|—— change-product '产品模块'
|       |—— change-product-bean
|       |—— change-product-dao
|       |—— change-product-rpc-server
|
|—— change-storehouse '仓库模块'
|       |—— change-storehouse-bean
|       |—— change-storehouse-dao
|       |—— change-storehouse-rpc-server
|
|—— change-order '订单模块'
|       |—— change-order-bean
|       |—— change-order-dao
|       |—— change-order-rpc-server
|
|—— change-wallet '钱包模块'
|       |—— change-wallet-pay '第三方支付web服务'
|       |—— change-wallet-bean
|       |—— change-wallet-dao
|       |—— change-wallet-rpc-server
```

### 技术选型
#### 后端技术
| 技术 | 名称| 官网 |
| :--- | :---: | :---: |
| Spring Framework | 容器 | [URI](http://projects.spring.io/spring-framework/) |
| Spring MVC | MVC框架 | [URI](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc) |
| Apache Shiro | 安全框架 | [URI](http://shiro.apache.org/) |
| Spring Session | 分布式Session管理 | [URL](http://projects.spring.io/spring-session/) |
| MyBatis | ORM框架 | [URI](http://www.mybatis.org/mybatis-3/zh/index.html) |
| MyBatis Generator | 代码生成 | [URI](http://www.mybatis.org/generator/index.html) |
| PageHelper | MyBatis物理分页插件 | [URI](http://git.oschina.net/free/Mybatis_PageHelper) |
| Druid | 数据库连接池 | [URI](https://github.com/alibaba/druid) |
| FluentValidator | 校验框架 | [URI](https://github.com/neoremind/fluent-validator) |
| ZooKeeper | 分布式协调服务 | [URI](http://zookeeper.apache.org/) |
| Dubbo | 分布式服务框架 | [URI](http://dubbo.io/) |
| Redis | 分布式缓存数据库 | [URI](https://redis.io/) |
| Solr & Elasticsearch | 分布式全文搜索引擎 | [URI](http://lucene.apache.org/solr/) [URL](https://www.elastic.co/) |
| Quartz | 作业调度框架 | [URI](http://www.quartz-scheduler.org/) |
| Ehcache | 进程内缓存框架 | [URI](http://www.ehcache.org/) |
| ActiveMQ | 消息队列 | [URI](http://activemq.apache.org/) |
| Log4J | 日志组件 | [URI](http://logging.apache.org/log4j/1.2/) |
| Maven | 项目构建管理 | [URI](http://maven.apache.org/) |

#### 前端技术
| 技术 | 名称| 官网 |
| :--- | :---: | :---: |
| jQuery | 函式库 | [URI](http://jquery.com/) |
| Bootstrap	 | 前端框架 | [URI](http://getbootstrap.com/) |
| Vue | 前端MVC框架 | [URL](https://cn.vuejs.org/) |