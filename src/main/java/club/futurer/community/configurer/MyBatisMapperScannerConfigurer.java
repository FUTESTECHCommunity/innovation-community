//package club.futurer.community.configurer;
//
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
///**
// * Created by ZYC on 2017/2/6.
// */
//@Configuration
//@AutoConfigureAfter({CommunityDruidDBConfigurer.class})//这个配置一定要注意@AutoConfigureAfter({CommunityDruidDBConfig.class})，必须有这个配置，否则会有异常。原因就是这个类执行的比较早，由于sqlSessionFactory还不存在，后续执行出错。
//@EnableTransactionManagement(proxyTargetClass = true)//启注解事务管理,等同于xml配置方式的<tx:annotation-driven />,spring容器会自动扫描注解@Transactional的方法和类
//public class MyBatisMapperScannerConfigurer {
////    //如果我们想要扫描MyBatis的Mapper接口，我们就需要配置这个类，这个配置我们需要单独放到一个类中。如果不然则无法实现mapper注入
//    @Bean(name="communityMapperScannerConfiguer")
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("communitySqlSessionFactory");
//        mapperScannerConfigurer.setBasePackage("club.futurer.community.business.**.dao");
//        return mapperScannerConfigurer;
//    }
//
//}
