package club.futurer.community.business.curiosity.dao;

import club.futurer.community.business.curiosity.model.entity.Questioning;
import club.futurer.community.business.curiosity.model.entity.QuestioningExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestioningMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning
     *
     * @mbg.generated
     */
    long countByExample(QuestioningExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning
     *
     * @mbg.generated
     */
    int insert(Questioning record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning
     *
     * @mbg.generated
     */
    int insertSelective(Questioning record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning
     *
     * @mbg.generated
     */
    List<Questioning> selectByExample(QuestioningExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning
     *
     * @mbg.generated
     */
    Questioning selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Questioning record, @Param("example") QuestioningExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Questioning record, @Param("example") QuestioningExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Questioning record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questioning
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Questioning record);
}