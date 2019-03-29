package club.futurer.community.exception;

/**
 * @author aelns
 */
public enum ApplicationErrorCode {
    ArgumentsIncorrect("10001", "参数不正确"),
    TimeoutCall("10002", "API调用超时"),
    EmptyUploadFile("10003", "没有要上传的文件"),
    UnSupportFileSize("10004", "文件大小错误, 不能超过2M"),
    UnSupoortFileType("10005", "文件类型错误, 只支持jpg, jpe, gif, png格式照片"),
    ImageUploadFailed("10006", "图片上传失败"),
    ImageRecommendFailed("10007", "图像识别失败"),
    NotFoundAnyData("10008", "没有找到相关的数据"),
    InvalidRequestPath("10009", "请求的地址不存在"),
    InvaliAccessToken("10010", "会话已失效,请重新登录"),
    CanNotAccessResource("10011", "无权限进行此操作"),
    InvalidOpration("10013", "无效的操作"),
    UnKnowException("10014", "发生未知异常"),
    PushClient("10015", "推送Client异常"),
    PushServer("10016", "推送Server异常"),
    HttpClient("10017", "Http Client异常"),
    UserNameNotExist("10018", "用户名不存在"),
    InvalidPassword("10019", "密码错误"),
    HTTPMessageConvert("10020", "HTTP 消息转换错误"),
    DuplicateSubmit("10022", "请勿重复提交数据"),
    InvalidSubmissionToken("10023", "防重复提交Token已失效, 请重新获取Token后进行提交"),
    InvalidReceiptState("10024", "收货单状态异常"),
    LockedReceipt("10025", "该收货单已被锁定, 不允许进行收货操作"),

    MessageQueneSendError("20001", "消息队列发送失败"),
    RedisError("20002", "Redis异常"),
    DataError("20003", "数据异常"),
    LockError("20004", "获取锁异常"),
    IOException("20005", "IO异常"),
    NoImplementMethod("90000", "未实现的方法"),
    WechatError("40000", "微信异常");

    private String code;
    private String reasoning;

    private ApplicationErrorCode(String code, String reasoning) {
        this.code = code;
        this.reasoning = reasoning;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the reasoning
     */
    public String getReasoning() {
        return reasoning;
    }

}
