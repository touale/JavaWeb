package cn.touale.cula.result;

/**
 * @author Touale
 * @description a
 * @date 2021/12/31 12:49
 */
public enum ErrorCode {

    /**
     * 成功
     */
    SUCC("1", "", "成功"),
    /**
     * 失败
     */
    ERROR("0", "", "失败"),
    /**
     * 超时
     */
    TIMEOUT("-1", "", "超时");

    /**
     * 错误码
     */
    private String code;
    /**
     * 国际化Key
     */
    private String iKey;
    /**
     * 描述
     */
    private String desc;

    ErrorCode(String code, String iKey, String desc) {
        this.code = code;
        this.iKey = iKey;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getiKey() {
        return iKey;
    }

    public String getDesc() {
        return desc;
    }
}