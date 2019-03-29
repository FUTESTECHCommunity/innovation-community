//package club.futurer.community.configurer;
//
//import club.futurer.community.common.Constant;
//import com.google.common.cache.CacheBuilder;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.support.SimpleCacheManager;
//import org.springframework.context.annotation.Bean;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by ZYC on 2017/10/27.
// */
////@Configuration
////@EnableCaching
//public class GuavaCacheConfigurer extends CachingConfigurerSupport {
//    public static final int DEFAULT_MAXSIZE = 50000;
//    public static final int DEFAULT_TTL = 10;
//    /**
//     * 定义cache名称、超時時長（秒）、最大size
//     * 每个cache缺省10秒超时、最多缓存50000条数据，需要修改可以在构造方法的参数中指定。
//     */
//    public enum Caches{
//        ACCESS_TOKEN_CACHE(Constant.ACCESS_TOKEN_CACHE, 8640000),
//        NONCE_CACHE(Constant.NONCE_CACHE, 600);
//
//        Caches(String cacheName) {
//            this.cacheName = cacheName;
//            this.ttl = DEFAULT_TTL;
//            this.maxSize = DEFAULT_MAXSIZE;
//        }
//
//        Caches(String cacheName, int ttl) {
//            this.cacheName = cacheName;
//            this.ttl = ttl;
//            this.maxSize = DEFAULT_MAXSIZE;
//        }
//
//        Caches(String cacheName, int ttl, int maxSize) {
//            this.cacheName = cacheName;
//            this.ttl = ttl;
//            this.maxSize = maxSize;
//        }
//
//        private int maxSize=DEFAULT_MAXSIZE;    //最大數量
//        private int ttl=DEFAULT_TTL;        //过期时间（秒）
//        private String cacheName; //名称
//
//        public String getCacheName() {
//            return this.cacheName;
//        }
//
//        public int getMaxSize() {
//            return maxSize;
//        }
//
//        public int getTtl() {
//            return ttl;
//        }
//    }
//
//    @Bean
//    public CacheManager guavaCacheManager() {
//        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
//
//        //把各个cache注册到cacheManager中，GuavaCache实现了org.springframework.cache.Cache接口
//        ArrayList<GuavaCache> caches = new ArrayList<GuavaCache>();
//        for(Caches c : Caches.values()){
//            caches.add(new GuavaCache(c.getCacheName(), CacheBuilder.newBuilder().recordStats().expireAfterWrite(c.getTtl(), TimeUnit.SECONDS).maximumSize(c.getMaxSize()).build()));
//        }
//        simpleCacheManager.setCaches(caches);
//        simpleCacheManager.initializeCaches();//必须初始化，要不然获取cache的时候报错
//        return simpleCacheManager;
//    }
//}
