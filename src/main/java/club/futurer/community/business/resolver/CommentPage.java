package club.futurer.community.business.resolver;

import club.futurer.community.business.curiosity.model.entity.QuestioningComment;

import java.util.List;

public class CommentPage {
    private Long totalCount;
    private List<QuestioningComment> datas;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<QuestioningComment> getDatas() {
        return datas;
    }

    public void setDatas(List<QuestioningComment> datas) {
        this.datas = datas;
    }
}
