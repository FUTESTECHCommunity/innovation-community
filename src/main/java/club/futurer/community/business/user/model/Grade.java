package club.futurer.community.business.user.model;

import java.util.HashMap;
import java.util.Map;

public enum Grade {
    BACHELOR(1, "学士"),
    EXPLORER(2, "探索者"),//Inventor 发明家
    CREATOR(3, "创意家"),
    DOCTOR(4, "博士"),
    GUOSHI(5, "国士"),
    DONGLIANG(6, "栋梁"),
    JINGWEITIANXIA(7, "经纬天下")//济世之才
    ;
    private Integer grade;
    private String desc;

    private static final Map<Integer, Grade> gradeMap = new HashMap<>();

    static {
        for(Grade grade : Grade.values()) {
            gradeMap.put(grade.getGrade(), grade);
        }
    }

    private Grade(Integer grade, String desc) {
        this.grade = grade;
        this.desc = desc;
    }

    public Integer getGrade() {
        return grade;
    }

    public String getDesc() {
        return desc;
    }

    public static Grade lookup(Integer grade) {
        return gradeMap.getOrDefault(grade, Grade.BACHELOR);//默认学士
    }
}
