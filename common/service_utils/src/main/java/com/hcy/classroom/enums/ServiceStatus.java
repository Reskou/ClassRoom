package com.hcy.classroom.enums;

/**
 * @author 韩传勇
 * @version 1.0
 */
public enum ServiceStatus {

    OK(200, "成功"),

    AccessTokenError(400, "用户登录令牌失效"),

    UserNotFound(11001, "用户未找到"),

    UserPasswordNotMatch(11002, "密码不匹配"),

    UserNameOrPasswordNotMatch(11003, "用户名或密码错误"),

    UserNotEnabled(11004, "用户未启用"),

    UserExist(11005, "用户已存在");

    int code;
    String message;

    ServiceStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
