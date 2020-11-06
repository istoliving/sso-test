package com.security.jwt.handler;

import com.alibaba.fastjson.JSON;
import com.security.jwt.common.ResultEnum;
import com.security.jwt.common.ResultVO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author shitie
 * @Date 2020/11/4 0004 下午 4:23
 */
public class UnAuthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
//        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        String reason = "统一处理，原因："+authException.getMessage();
//        response.getWriter().write(new ObjectMapper().writeValueAsString(reason));
        response.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_NEED_AUTHORITIES,false)));
    }
}
