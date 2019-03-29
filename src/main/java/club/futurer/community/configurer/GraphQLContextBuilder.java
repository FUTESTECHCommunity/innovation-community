package club.futurer.community.configurer;

import club.futurer.community.business.user.model.entity.User;
import club.futurer.community.business.user.service.UserService;
import graphql.servlet.GraphQLContext;
import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Component
public class GraphQLContextBuilder implements graphql.servlet.GraphQLContextBuilder {

    @Autowired
    private UserService userService;

    @Override
    public GraphQLContext build(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        GraphQLContext context = new GraphQLContext(httpServletRequest, httpServletResponse);
        context.setDataLoaderRegistry(buildDataLoaderRegistry());
        return context;
    }

    @Override
    public GraphQLContext build(Session session, HandshakeRequest handshakeRequest) {
        GraphQLContext context = new GraphQLContext(session, handshakeRequest);
        context.setDataLoaderRegistry(buildDataLoaderRegistry());
        return context;
    }

    @Override
    public GraphQLContext build() {
        GraphQLContext context = new GraphQLContext();
        context.setDataLoaderRegistry(buildDataLoaderRegistry());
        return context;
    }

    private DataLoaderRegistry buildDataLoaderRegistry() {
        DataLoaderRegistry registry = new DataLoaderRegistry();
        registry.register("userDataLoader", userDataLoader());
        return registry;
    }

    private DataLoader<Long, User> userDataLoader() {
        BatchLoader<Long, User> userBatchLoader = new BatchLoader<Long, User>() {
            @Override
            public CompletionStage<List<User>> load(List<Long> ids) {
                return CompletableFuture.supplyAsync(() -> {
                    return userService.findUsersByIds(ids);
                });
            }
        };
        return DataLoader.newDataLoader(userBatchLoader);
    }
}
