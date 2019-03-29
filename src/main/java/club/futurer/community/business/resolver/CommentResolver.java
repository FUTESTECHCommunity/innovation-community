package club.futurer.community.business.resolver;

import club.futurer.community.business.curiosity.model.entity.QuestioningComment;
import club.futurer.community.business.user.model.entity.User;
import com.coxautodev.graphql.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;
import org.apache.commons.lang3.StringUtils;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class CommentResolver implements GraphQLResolver<QuestioningComment> {

    public CompletableFuture<User> author(QuestioningComment comment, DataFetchingEnvironment environment) {
        if(comment.getCommentUserid() != null) {
            DataLoader<Long, User> dataLoader = ((GraphQLContext) environment.getContext())
                    .getDataLoaderRegistry().get()
                    .getDataLoader("userDataLoader");
            return dataLoader.load(comment.getCommentUserid());
        }
        return null;
    }

    public List<String> tags(QuestioningComment comment) {
        List<String> resultList = new ArrayList<>();
        if(StringUtils.isNotBlank(comment.getTags())) {
            String[] arr = comment.getTags().split(",");
            for(String item : arr) {
                resultList.add(item);
            }
        }
        return resultList;
    }

    public List<String> images(QuestioningComment comment) {
        List<String> resultList = new ArrayList<>();
        if(StringUtils.isNotBlank(comment.getImages())) {
            String[] arr = comment.getImages().split(",");
            for(String item : arr) {
                resultList.add(item);
            }
        }
        return resultList;
    }

    public Long up(QuestioningComment comment) {
        if(comment.getUpCount() == null)
            return 0L;
        return comment.getUpCount();
    }

    public Long down(QuestioningComment comment) {
        if(comment.getDownCount() == null)
            return 0L;
        return comment.getDownCount();
    }

    public List<QuestioningComment> subs(QuestioningComment comment) {
        return Collections.emptyList();
    }
}
