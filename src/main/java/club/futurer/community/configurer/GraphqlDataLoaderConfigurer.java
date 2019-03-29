//package club.futurer.community.configurer;
//
//import club.futurer.community.business.user.model.entity.User;
//import club.futurer.community.business.user.service.UserService;
//import graphql.execution.instrumentation.Instrumentation;
//import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentation;
//import org.dataloader.BatchLoader;
//import org.dataloader.DataLoader;
//import org.dataloader.DataLoaderRegistry;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.CompletionStage;
//
//@Configuration
//public class GraphqlDataLoaderConfigurer {
//
//    @Bean
//    DataLoaderRegistry dataLoaderRegistry() {
//        DataLoaderRegistry registry = new DataLoaderRegistry();
////        for(DataLoader<?, ?> loader : loaderList) {
////            registry.register(loader.getClass().getSimpleName(), loader);
////        }
//        registry.register("userDataLoader", userDataLoader())
//        return registry;
//    }
//
//    @Bean
//    Instrumentation instrumentation(DataLoaderRegistry dataLoaderRegistry) {
//        return new DataLoaderDispatcherInstrumentation(dataLoaderRegistry);
//    }
//
//    @Bean(name = "userDataLoader")
//    DataLoader<Long, User> userDataLoader(UserService userService) {
//        BatchLoader<Long, User> userBatchLoader = new BatchLoader<Long, User>() {
//            @Override
//            public CompletionStage<List<User>> load(List<Long> ids) {
//                return CompletableFuture.supplyAsync(() -> {
//                    return userService.findUsersByIds(ids);
//                });
//            }
//        };
//        return DataLoader.newDataLoader(userBatchLoader);
//    }
//}
