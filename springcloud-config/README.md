一、git仓库配置文件刷新URL：  
   http://127.0.0.1:8081/actuator/bus-refresh  
说明：此接口为post请求，直接浏览器访问无用，可用postman发起post请求刷新  

二、刷新需要使用消息队列，SpringCloud默认为我们支持了RabbitMQ。当然我们也可以使用其它的消息队列，只不过如果使用RabbitMQ的话，
SpringCloud会为我们提供自动化默认配置。也就是我们什么都不需要配置就可以直接使用该队列服务。
如果要使用队列服务时，那就需要在 配置中心微服务以及客户端微服务 都添加相应的依赖。本配置中心微服务工程已经添加。  

三、若未安装RabbitMQ，则本工程启动报错，文件任然可以访问，只是不能实施刷新。  
下面地址为RabbitMQ默认的管理界面地址:  
  http://127.0.0.1:15672  

三、配置文件访问：  
    /{label}/{application}-{profile}.properties|yml
    下面我们详细介绍上面参数的含义：  
    ① label ：远程仓库的分支名字。如果我没有指定该参数默认按照master访问，即在访问时，如果分支为master可以省略。  
    ② application ：为该应用在Eruke注册中心的ID，即spring.application.name的名称。  
    ③ profile ：不同环境的名字。例如:dev(开发环境)、test(测试环境)、prod(生产环境)等。  
    示例：
    http://localhost:8081/master/springcloud-client-prod.yml   