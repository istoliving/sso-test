package com.security.jwt.handler;

import com.alibaba.fastjson.JSON;
import com.security.jwt.common.ResultEnum;
import com.security.jwt.common.ResultVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author wangzhipeng
 * @Date 2020/11/4 0004 下午 3:57
 */
public class ZTCLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGOUT_SUCCESS,true)));
    }
}
