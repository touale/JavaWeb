package cn.touale.cula.result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Touale
 * @description ResultDTO
 * @date 2021/12/31 12:50
 */
@ApiModel("返回结果统一封装")
@Data
public class ResultDTO<T> {

    /**
     * 状态码，
     * 成功=1。
     * 超时=-1。
     * 失败!=1&!=-1。
     */
    @ApiModelProperty("状态码，成功=1，超时=-1，失败=0")
    private String code;
    /**
     * 数据
     */
    @ApiModelProperty("返回业务数据")
    private T data;
    /**
     * 消息
     */
    @ApiModelProperty("返回msg")
    private String msg;

    public ResultDTO() {
    }

    /**
     * 判断成功与否。
     *
     * @return
     */
    @JSONField(serialize = false)
    public boolean isSucc() {
        if (ErrorCode.SUCC.getCode().equals(this.code)) {
            return true;
        }
        return false;
    }

    public ResultDTO<T> succ() {
        this.code = ErrorCode.SUCC.getCode();
        return this;
    }

    public ResultDTO<T> fail(ErrorCode code) {
        this.code = code.getCode();
        return this;
    }

    public ResultDTO<T> fail(String code) {
        this.code = code;
        return this;
    }

    public ResultDTO<T> data(T data) {
        this.setData(data);
        return this;
    }

    public ResultDTO<T> msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    /**
     * 开始构建成功返回方法。
     *
     * @param msg
     * @param data
     * @return
     */
    public ResultDTO<T> buildSucc(String msg, T data) {
        this.succ().msg(msg).data(data);
        return this;
    }

    /**
     * 开始构建成功返回方法。
     *
     * @return
     */
    public ResultDTO<T> buildSucc() {
        buildSucc("succ", null);
        return this;
    }

    /**
     * 开始构建成功返回方法。
     *
     * @return
     */
    public ResultDTO<T> buildSucc(T data) {
        buildSucc("success", data);
        return this;
    }

    /**
     * 开始构建成功返回方法。
     *
     * @param msg
     * @return
     */
    public ResultDTO<T> buildSucc(String msg) {
        buildSucc(msg, null);
        return this;
    }

    /**
     * 开始构建失败返回方法。
     *
     * @return
     */
    public ResultDTO<T> buildFail() {
        buildError(ErrorCode.ERROR, "fail");
        return this;
    }

    /**
     * 开始构建失败返回方法。
     *
     * @return
     */
    public ResultDTO<T> buildFail(String msg) {
        buildError(ErrorCode.ERROR, msg);
        return this;
    }

    /**
     * 开始构建失败返回方法。
     *
     * @param msg
     * @return
     */
    public ResultDTO<T> buildFail(ErrorCode code, String msg) {
        this.buildFail(code, msg, null);
        return this;
    }

    /**
     * 开始构建失败返回方法。
     *
     * @param msg
     * @return
     */
    public ResultDTO<T> buildFail(String code, String msg) {
        this.buildFail(code, msg, null);
        return this;
    }

    /**
     * 开始构建失败返回方法。
     *
     * @param msg
     * @param data
     * @return
     */
    public ResultDTO<T> buildFail(ErrorCode code, String msg, T data) {
        this.fail(code).msg(msg).data(data);
        return this;
    }

    public ResultDTO<T> buildFail(String msg, T data) {
        this.fail(ErrorCode.ERROR).msg(msg).data(data);
        return this;
    }

    /**
     * 开始构建失败返回方法。
     *
     * @param msg
     * @param data
     * @return
     */
    public ResultDTO<T> buildFail(String code, String msg, T data) {
        this.fail(code).msg(msg).data(data);
        return this;
    }

    /**
     * 开始构建返回异常方法。
     *
     * @param msg
     * @return
     */
    public ResultDTO<T> buildError(ErrorCode code, String msg) {
        this.code = code.getCode();
        this.msg = msg;
        return this;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}