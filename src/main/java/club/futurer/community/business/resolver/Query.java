package club.futurer.community.business.resolver;

import club.futurer.community.business.curiosity.model.entity.Questioning;
import club.futurer.community.business.curiosity.model.entity.QuestioningComment;
import club.futurer.community.business.curiosity.service.QuestioningService;
import club.futurer.community.business.user.model.entity.User;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private QuestioningService questioningService;

    public List<Questioning> findQuestionings(int pageNum, int pageSize){
        return questioningService.findAllQuestiongs(pageNum, pageSize);
    }

    public Questioning findOneQuestioning(Long id) {
//        return questioningService.findOneQuestioning(id);
        Questioning questioning = new Questioning();
        questioning.setId(id);
        questioning.setContent("hello,world!");
        questioning.setTags("hello,world,what");
        return questioning;
    }

    public QuestioningComment findComment(Long id) {
        QuestioningComment comment = new QuestioningComment();
        comment.setId(1L);
        comment.setContent("first comment!");
        comment.setCommentUserid(1L);
        return comment;
    }
}
