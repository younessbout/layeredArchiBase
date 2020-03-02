package com.cdgk.infra.config.security;

import com.cdgk.domain.users.User;
import com.cdgk.domain.users.UserProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    private UserProvider userProvider;

    public JwtAuthenticationFilter(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = null;
        try {
            token = getTokenIdFromRequest(request);

            if (StringUtils.hasText(token)) {
                String userName = userProvider.getUserNameFromToken(token);

                User user = userProvider.getUserByUserName(userName);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            LOGGER.error("Could not set user authentication in security context for <Request, Method, Token> with Token <{}, {}, {}>", request.getServletPath(), request.getMethod(), token);
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenIdFromRequest(HttpServletRequest request) {
        String token = request.getHeader("X-TOKEN-ID");
        if (StringUtils.hasText(token)) {
            return token;
        }
        return null;
    }
}