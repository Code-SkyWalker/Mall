package com.skywalker.entity;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Code SkyWalker
 * @Date 16:44 2022/11/25
 * @Classname Result
 * @Description 返回的结果
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public Result() {
        put("code", HttpStatus.SC_OK);
        put("msg", "success");
    }

    /**
     * 获取code
     */
    public int getStatusCode() {
        return (int) get("code");
    }

    public static Result error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Object data) {
        Result r = new Result();
        r.put("data", data);
        return r;
    }

    public static Result ok(String msg, Object data) {
        Result r = new Result();
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
