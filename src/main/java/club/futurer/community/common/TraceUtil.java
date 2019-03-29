package club.futurer.community.common;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by ZYC on 2017/4/14.
 */
public class TraceUtil {
    //打印错误消息
    public static final String exception(Exception exception){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        return stringWriter.toString();
    }

//    /**
//     *测试Gson null object
//     */
//    public static void main(String[] args) {
//        Person person = new Person();
//        person.setAge(10);
//        Gson gson = new GsonBuilder().serializeNulls().create();
//        System.out.println(gson.toJson(person));
//    }

//    static class Person {
//        private String name;
//        private int age;
//        private Double price;
//
//        public String getName() {
//            return name;
//        }
//
//        public Double getPrice() {
//            return price;
//        }
//
//        public void setPrice(Double price) {
//            this.price = price;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public void setAge(int age) {
//            this.age = age;
//        }
//    }
}
