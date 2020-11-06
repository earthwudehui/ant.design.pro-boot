# ant.design.pro-boot
ant.design.pro 管理系统后端实现

## 架构 
    采用技术
    工程结构
    代码规范
    对象规范
        
        API/Controller层
            Query：数据查询对象，各层接收上层的查询请求。注意超过 2 个参数的查询封装，禁止使用 Map 类来传输。
            VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。json传输时，不再有vo对象
            public List<UserVO> getUsers(UserQuery userQuery);
            对于聚合服务需要裁减拼装个服务层的，可将Servic层返回DTO组合成VO输出。
            
        Service层、Manager层
            DTO（Data Transfer Object）：数据传输对象，Service 或 Manager 向外传输的对象。
            BO（Business Object）：业务对象，可以由 Service 层输出的封装业务逻辑的对象。
            
            // 普通的service层接口
            List<UserDTO> getUsers(UserQuery userQuery);
            然后在Service内部使用UserBO封装中间所需的逻辑对象,在其他service中进行业务操作
            List<UserBO> getUsers(UserBO userBO);
            BO这个对象可以包括一个或多个其它的对象。
                比如一个简历，有教育经历、工作经历、社会关系等等。
                我们可以把教育经历对应一个PO，工作经历对应一个PO，社会关系对应一个PO。
                建立一个对应简历的BO对象处理简历，每个BO包含这些PO。这样处理业务逻辑时，我们就可以针对BO去处理。
    
        DAO层
        默认实体对象不加O
        List<User> getUsers(UserQuery userQuery);    
        DO（Data Object）：此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。领域对象，是从现实世界中抽象出来的有形或无形的业务实体。
        PO(persistant object) 持久对象（在 O/R 映射的时候出现的概念，如果没有 O/R 映射，没有这个概念存在了） 
            通常对应数据模型 ( 数据库 ), 本身还有部分业务逻辑的处理。可以看成是与数据库中的表相映射的 Java 对象。
            最简单的 PO 就是对应数据库中某个表中的一条记录，多个记录可以用 PO 的集合。PO 中应该不包含任何对数据库的操作。
        多表联查返回非实体对象时，采用DTO
                        
    对外接口
    表结构
    帮助文档

