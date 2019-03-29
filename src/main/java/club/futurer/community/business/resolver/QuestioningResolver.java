package club.futurer.community.business.resolver;

import club.futurer.community.business.curiosity.model.entity.Questioning;
import club.futurer.community.business.curiosity.model.entity.QuestioningComment;
import club.futurer.community.business.curiosity.model.entity.QuestioningVoteSummarizing;
import club.futurer.community.business.curiosity.service.QuestioningService;
import club.futurer.community.business.user.model.entity.User;
import com.coxautodev.graphql.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;
import org.apache.commons.lang3.StringUtils;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class QuestioningResolver implements GraphQLResolver<Questioning> {

    @Autowired
    private QuestioningService questioningService;

    public CompletableFuture<User> author(Questioning questioning, DataFetchingEnvironment environment) {
        DataLoader<Long, User> dataLoader = ((GraphQLContext) environment.getContext())
                .getDataLoaderRegistry().get()
                .getDataLoader("userDataLoader");
        return dataLoader.load(questioning.getAuthorUserid());
    }

    public List<String> tags(Questioning questioning) {
        List<String> resultList = new ArrayList<>();
        if(StringUtils.isNotBlank(questioning.getTags())) {
            String[] arr = questioning.getTags().split(",");
            for(String item : arr) {
                resultList.add(item);
            }
        }
        return resultList;
    }

    public List<String> images(Questioning questioning) {
        List<String> resultList = new ArrayList<>();
        if(StringUtils.isNotBlank(questioning.getImages())) {
            String[] arr = questioning.getImages().split(",");
            for(String item : arr) {
                resultList.add(item);
            }
        }
        return resultList;
    }

    //多少分钟前
    //多少小时前
    //具体日期
    public String created(Questioning questioning) {
        if(questioning.getPublishTime() != null) {
            Instant instant = questioning.getPublishTime().toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return localDateTime.format(formatter);
        }
        return "";
    }

    public QuestioningVoteSummarizing vote(Questioning questioning) {
        return questioningService.getQuestioningSummarizingBy(questioning.getId());
    }

    //TODO 默认获取第一页评论
    // 按什么排序呢？
    public CommentPage comments(Questioning questioning, Integer first, Integer offset) {
        System.out.println("first:" + first + ";offset:" + offset);

        QuestioningComment comment = new QuestioningComment();
        comment.setId(1L);
        comment.setContent("first comment!");

        CommentPage result = new CommentPage();
        result.setTotalCount(1L);
        List<QuestioningComment> list = new ArrayList<>(1);
        list.add(comment);

        result.setDatas(list);
        return result;
    }
}
