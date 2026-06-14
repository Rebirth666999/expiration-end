# 保质期管理系统 - 后端服务 (Expiration Management System - Backend)

本项目为物品保质期管理系统的后端核心服务。基于主流的 Java 技术栈搭建，采用分层架构设计，为前端（如微信小程序、Web 端）提供标准化、去耦合的 RESTful API 接口，实现用户身份鉴权与物品保质期的全生命周期管理。

### 一、技术栈

* **核心框架：** Spring Boot (负责业务逻辑解耦与依赖注入)
* **持久层框架：** MyBatis (数据访问与对象关系映射)
* **数据库连接池：** Alibaba Druid (提供高性能的数据源连接与监控)
* **数据库：** MySQL 8.0 (实体数据关系持久化)
* **日志管理：** SLF4J 和 Logback (规范化的生产级日志审计)

### 二、项目结构

```text
src/main/java/com/pzy/
    SpringbootMybatisApplication.java  # 代表异步容器引导主类
    controller/                        # 目录下是控制层：暴露 RESTful API 接口
    entity/                            # 目录下是实体层：ORM 映射对象，例如 User 和 Product
    repository/                        # 目录下是数据访问层：MyBatis Mapper/Repository 接口
    service/                           # 目录下是业务逻辑层：核心业务规则加工

```

### 三、核心 API 接口设计

所有接口均已配置全局跨域支持，完美适配小程序本地调试环境。

#### 1. 用户管理模块 (路由前缀：/user)

* **特征：** 处理用户账户的生命周期与身份校验。
* **接口一：** 请求方法为 `POST`，路由地址为 `/user/register`，功能描述为新用户注册认证，请求体/参数为 JSON 格式的 `username` 和 `password`，返回状态码为 `211 Created` 或者 `409 Conflict`。
* **接口二：** 请求方法为 `POST`，路由地址为 `/user/login`，功能描述为用户登录状态鉴权，请求体/参数为 JSON 格式的 `username` 和 `password`，返回状态码为 `200 OK` 或者 `401 Unauthorized`。

#### 2. 物品保质期管理模块 (路由前缀：/product)

* **特征：** 实现对具体物品的时效性监控与数据维护。
* **接口一：** 请求方法为 `GET`，路由地址为 `/product/getProductsByUserId/{userId}`，功能描述为获取指定用户的所有物品列表，路径参数为 `userId`，返回状态码为 `200 OK` 或者 `404 Not Found`。
* **接口二：** 请求方法为 `POST`，路由地址为 `/product/add`，功能描述为新增保质期追踪物品，请求体/参数为 `Product` 实体数据，返回状态码为 `211 Created` 或者 `400 Bad Request`。
* **接口三：** 请求方法为 `DELETE`，路由地址为 `/product/delete/{id}`，功能描述为根据主键 ID 逻辑/物理删除物品，路径参数为 `id`，返回状态码为 `200 OK` 或者 `404 Not Found`。
* **接口四：** 请求方法为 `GET`，路由地址为 `/product/getProductsByUserIdAndType`，功能描述为根据分类筛选用户的到期物品，查询参数为 `userId` 和 `productType`。返回状态码为 `200 OK` 或者 `400 Bad Request`。

### 四、数据库环境初始化

本项目数据库架构名称定为 `expiration`。本地开发调试前，请务必先导入仓库中附带的数据库初始化脚本：

1. 确保本地 MySQL 服务已启动。
2. 创建目标数据库，在终端或可视化工具中执行命令：
```sql
CREATE DATABASE expiration CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

```


3. 运行仓库根目录下的 `MySQL.sql` 脚本以初始化用户表 (`user`) 和物品表 (`product`)。

### 五、本地部署指引

1. **修改环境配置：**
打开 `src/main/resources/application.yml`，根据本地实际情况修改数据库连接凭证：
* `spring.datasource.username` 填入你的数据库用户名，默认通常是 `root`
* `spring.datasource.password` 填入你的数据库密码
* `spring.datasource.url` 填入数据源连接地址，即 `jdbc:mysql://localhost:3306/expiration`


2. **编译并运行：**
在 IntelliJ IDEA 中等待 Maven 或 Gradle 依赖解析同步完毕后，直接运行 `SpringbootMybatisApplication.java` 主类。后端服务将默认在 `8080` 端口拉起。
3. **前端对接注意：**
若在微信开发者工具中进行本地回调调试，请确保在工具的 `本地设置` 中勾选 **“不校验合法域名、web-view（业务域名）、TLS版本以及HTTPS证书”**，并将请求基地址指向 `http://localhost:8080` 即可。
