package club.futurer.community.business.curiosity.service;

import club.futurer.community.business.curiosity.dao.*;
import club.futurer.community.business.curiosity.model.entity.Questioning;
import club.futurer.community.business.curiosity.model.entity.QuestioningVoteSummarizing;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestioningService {
    private static final Logger logger = LoggerFactory.getLogger(QuestioningService.class.getName());

    @Autowired
    private QuestioningMapper questioningMapper;

    @Autowired
    private QuestioningCommentMapper commentMapper;

    @Autowired
    private QuestioningCommentScoreMapper commentScoreMapper;

    @Autowired
    private QuestioningScoreMapper scoreMapper;

    @Autowired
    private QuestioningVoteMapper voteMapper;

    @Autowired
    private QuestioningVoteSummarizingMapper voteSummarizingMapper;

    public List<Questioning> findAllQuestiongs(int pageNum, int pageSize) {
        Page<Questioning> page = PageHelper.startPage(pageNum, pageSize);
        return questioningMapper.selectByExample(null);
    }

    public Questioning findOneQuestioning(long id) {
//        Questioning instance = new Questioning();
//        instance.setId(2012L);
//        instance.setContent("fdafdssdaf");
//        instance.setTags("dfadf,fdasdd,哲学,生物学");
//        if(id == 1L)
//            throw new RuntimeException("Invalid parameters.");
//        return instance;
        return questioningMapper.selectByPrimaryKey(id);
    }

    public QuestioningVoteSummarizing getQuestioningSummarizingBy(Long questionId) {
        return voteSummarizingMapper.selectByPrimaryKey(questionId);
    }
}
