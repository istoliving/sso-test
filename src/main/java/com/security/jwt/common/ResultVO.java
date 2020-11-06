package com.security.jwt.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author shitie
 * @Date 2020/11/4 0004 下午 2:28
 */
public class ResultVO implements Serializable {
    public static Map<String, Object> result(ResultEnum respCode, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", respCode.getCode());
        map.put("message", respCode.getMessage());
        map.put("data", null);
        map.put("success",success);
        return map;
    }

    /**
     * description: 返回响应信息及Token
     *
     * @param respCode
     * @param jwtToken
     * @param success
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public final static Map<String, Object> result(ResultEnum respCode, String jwtToken, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jwtToken",jwtToken);
        map.put("code", respCode.getCode());
        map.put("message", respCode.getMessage());
        map.put("data", null);
        map.put("success",success);
        return map;
    }
}
