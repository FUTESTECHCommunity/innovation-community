package club.futurer.community.business.curiosity.dao;

import club.futurer.community.business.curiosity.model.entity.QuestioningVote;
import club.futurer.community.business.curiosity.model.entity.QuestioningVoteExample;
import club.futurer.community.business.curiosity.model.entity.QuestioningVoteKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestioningVoteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning_vote
     *
     * @mbg.generated
     */
    long countByExample(QuestioningVoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning_vote
     *
     * @mbg.generated
     */
    int insert(QuestioningVote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning_vote
     *
     * @mbg.generated
     */
    int insertSelective(QuestioningVote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning_vote
     *
     * @mbg.generated
     */
    List<QuestioningVote> selectByExample(QuestioningVoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning_vote
     *
     * @mbg.generated
     */
    QuestioningVote selectByPrimaryKey(QuestioningVoteKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning_vote
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") QuestioningVote record, @Param("example") QuestioningVoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning_vote
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") QuestioningVote record, @Param("example") QuestioningVoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning_vote
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(QuestioningVote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning_vote
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(QuestioningVote record);
}