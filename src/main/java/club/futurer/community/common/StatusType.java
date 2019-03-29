package club.futurer.community.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZYC on 2017/5/5.
 */
public enum StatusType {
//    IsOK(200, "业务正常处理", "业务正常处理，返回200"),
//    InvalidArgument(400, "参数存在错误", "参数存在错误，需要验证参数大小，范围，是否必须等等。若有问题，则返回400。"),
    BusinessException(500, "业务处理错误", "业务处理错误，抛出业务处理异常，拦截后返回500。"),
//    ApplicationBug(600, "程序存在bug", "程序存在bug，抛出未检查异常，拦截后返回600。"),
//    ApplicationException(700, "应用程序错误", "应用程序错误，抛出已检查异常，拦截后返回700"),
//    FrameworkException(800, "Rpc调用框架错误", "连接调用框架异常，连接会直接断开还是抛出连接错误？服务端无法拦截并返回状态码。");
    ;

    private int statusCode;
    private String type;
    private String description;

    private static final Map<Integer, StatusType> lookup = new HashMap<>();

    static {
        for(StatusType status : values()) {
            lookup.put(status.getStatusCode(), status);
        }
    }

    public static StatusType lookup(Integer status) {
        return lookup.get(status);
    }

    StatusType(int statusCode, String type, String description) {
        this.statusCode = statusCode;
        this.type = type;
        this.description = description;
    }

    public int getStatusCode(){
        return this.statusCode;
    }

    public String getType(){
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }
}
