# mario-mushroom

## 项目简介
mario-mushroom 是一个涵盖大数据、分布式、消息队列、缓存、数据库、Netty、JVM、设计模式等多领域的 Java 技术学习与实践项目，适合后端开发者系统性提升技术能力。

## 工作栈
项目管理: 禅道  敏捷开发: tapd  进度估计: oplx  文档: conflux wiki、语雀  设计: 蓝湖  编码风格: google_style

## 目录结构
- base/         基础知识与通用模块（如线程、AOP、Spring、Web等）
- bigdata/      大数据相关（Hadoop、Spark、Flink、Kafka、Hive等）
- cache/        缓存相关（如 Redis）
- db/           数据库相关（MySQL、MongoDB、ORM等）
- demo/         各类示例代码
- design-pattern/  设计模式实践
- distribute/   分布式相关（CAP、RPC、分布式任务等）
- docker/       Docker 容器化相关
- jvm/          JVM 相关知识与脚本
- lib/          公共库
- mq/           消息队列（RabbitMQ、RocketMQ、ActiveMQ等）
- netty/        Netty 网络编程
- security/     安全相关
- test/         测试相关（JMockit、Spock等）
- util/         工具类与中间件（Apollo、Orika、POI、Sentinel、工作流等）

## 主要功能模块
- 多种主流大数据组件的集成与实践
- 分布式系统设计与实现
- 消息队列的使用与对比
- 缓存与数据库的最佳实践
- 设计模式代码示例
- JVM 调优与脚本
- 容器化与自动化部署

## 依赖环境
- JDK 1.8 及以上
- Maven 3.x
- 推荐使用 IDEA 作为开发工具
- 部分模块需 Docker 环境

## 快速开始
1. 克隆项目：
   git clone https://github.com/yourname/mario-mushroom.git
2. 进入目录并用 Maven 构建：
   cd mario-mushroom
   mvn clean install
3. 按需进入各子模块目录，参考对应 README 或 pom.xml 进行学习和运行。

## 说明
- 各子模块均为独立 Maven 工程，可单独编译运行。
- 详细用法和说明请参考各子模块下的 README 或源码注释。

