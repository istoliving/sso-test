package com.security.jwt.filter;

import com.security.jwt.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @Author shitie
 * @Date 2020/11/4 0004 下午 5:20
 */
public class JwtPreAuthFilter extends BasicAuthenticationFilter {
    public JwtPreAuthFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    /**
     * description: 从request的header部分读取Token
     *
     * @param request
     * @param response
     * @param chain
     * @return void
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        System.out.println("BasicAuthenticationFilters");
        String tokenHeader = request.getHeader(JwtUtils.TOKEN_HEADER);
        System.out.println("tokenHeader:"+tokenHeader);
        // 如果请求头中没有Authorization信息则直接放行了
        if (tokenHeader == null || !tokenHeader.startsWith(JwtUtils.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 如果请求头中有token，则进行解析，并且设置认证信息
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
        super.doFilterInternal(request, response, chain);
    }

    /**
     * description: 读取Token信息，创建UsernamePasswordAuthenticationToken对象
     *
     * @param tokenHeader
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        //解析Token时将“Bearer ”前缀去掉
        String token = tokenHeader.replace(JwtUtils.TOKEN_PREFIX, "");
        String username = JwtUtils.getUsername(token);
        List<String> roles = JwtUtils.getUserRole(token);
        Collection<GrantedAuthority> authorities = new HashSet<>();
        if (roles!=null) {
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority(role));
            }
        }
        if (username != null){
            return new UsernamePasswordAuthenticationToken(username, null, authorities);
        }
        return null;
    }

}
