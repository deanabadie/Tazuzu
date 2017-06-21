package com.tazuzuapp.api.security.filter;

import com.tazuzuapp.api.security.JwtUtil;
import com.tazuzuapp.api.user.domain.User;
import com.tazuzuapp.api.user.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Component
public class JwtFilter extends GenericFilterBean {

    private final JwtUtil jwtUtil;

    private final UserService userService;

    @SuppressWarnings("unused")
    public JwtFilter(JwtUtil jwtUtil, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        Map<String, List<String>> allowedPaths = new HashMap<>();
        allowedPaths.put("/api/login", Collections.singletonList(HttpMethod.POST.toString()));
        allowedPaths.put("/api/teachers", Collections.singletonList(HttpMethod.POST.toString()));
        allowedPaths.put("/api/payload", Collections.singletonList(HttpMethod.GET.toString()));

        // when authenticate do not check for jwt
        if ( allowedPaths.containsKey(httpRequest.getRequestURI()) && allowedPaths.get(httpRequest.getRequestURI()).contains(httpRequest.getMethod()) ) {
            filterChain.doFilter(httpRequest, res);
            return;
        }

        String authHeader = httpRequest.getHeader("Authorization");

        if ( httpRequest.getMethod().equals(HttpMethod.OPTIONS.toString()) ) {
            filterChain.doFilter(httpRequest, res);
            return;
        }

        if (authHeader != null && !authHeader.isEmpty()) {
            try {
                Claims c = jwtUtil.parseToken(authHeader);
                httpRequest.setAttribute("claims", c);
                LinkedHashMap user =  c.get("user", LinkedHashMap.class);
                httpRequest.setAttribute("user_roles", user.get("roles"));


                User u = userService.findById(Integer.toUnsignedLong((int) user.get("id")));

                httpRequest.setAttribute("user", u);

                filterChain.doFilter(httpRequest, res);
            } catch ( JwtException e ) {
                res.reset();
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            res.reset();
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

}
