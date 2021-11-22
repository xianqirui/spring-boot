Banner图标打开，在resouces目录下创建，banner.txt文件，添加类容
=========================
SpringApplication springApplication=new SpringApplication(Starter.class);
        //设置图标关闭
        springApplication.setBannerMode(Banner.Mode.OFF);
        //启动项目
        springApplication.run();
=======================================
SpringBoot项目是一个标准的Maven项目，它的配置文件需要放在src/main/resources/下，
其文件名必须为application，其存在两种文件形式，分别是properties和yaml（或者yml）文件。
两个文件二选一

默认视图在resoures目录下创建templates目录存放视图,路径可以自己该
