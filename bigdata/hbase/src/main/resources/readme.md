https://gitee.com/lovepeng/docker-hbase

https://blog.csdn.net/baifanwudi/article/details/78498325
#拉取容器
docker pull harisekhon/hbase
#启动容器
docker run -d -h myhbase -p 2181:2181 -p 8080:8080 -p 8085:8085 -p 9090:9090 -p 9095:9095 -p 16000:16000 -p 16010:16010 -p 16201:16201 -p 16301:16301 --name hbase1.3 harisekhon/hbase
访问页面http://localhost:16010/master-status


高并发读写瓶颈
可扩展限制
事务一致性的负面影响
复杂sql查询的弱化

主要包含:
客户端client:RPC与Hmaster与HregionServer通信,管理类操作,与HMaster交互;数据读写类操作与HRegionServer进行交互
协调服务模块Zookeeper:Quorum队列负责管理Hbase中多HMaster的选举,服务器状态同步;具体为存储Hbase元数据信息,实时监控RegionServer,
    存储所有Region的寻址入口 
主节点Hmaster:负责Table和Region的管理工作;1.管理用户对Table的CRUD操作2.管理Region的负载均衡,调整Region分布3.在Region分裂后,负责新Region的分配
    4.RegionServer死机后,对失效的RegionServer上的Region迁移
region节点和regionserver:regionserver主要负责用户的IO请求,向HDFS读写数据;每个HRegion对应了Table中的一个region,Hregion由多个HStore组成,
    每个Hstore对应了Table中的一个Cloumn Family的存储.

当storeFile大小超过阈值,出发split操作,Region分裂为2个.父region下线,2个子region被hmaster分配到相应的HregionServer
Hlog用于记录,数据恢复


数据模型
1.表
2.行键
3.列族
4.单元格

读get 写put 扫描scan 删除delete
含有版本号

最终一致性
