package com.url.UrlShortner.Security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtTokenProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try{
            //get jwt from header
            String Jwt = jwtTokenProvider.getJwtFromHeader(request);

            if(Jwt != null && jwtTokenProvider.validateToken(Jwt))
            {
                String username = jwtTokenProvider.getUserNameFromJwtToken(Jwt);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                   if(userDetails != null)
                   {
                       UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                       authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                       SecurityContextHolder.getContext().setAuthentication(authentication);
                   }
            }
            //validate token
            // if valid get user details
            //get user name -> loda user -> ste the auth contexet

        }catch (Exception e)
        {
          e.printStackTrace();
        }

        filterChain.doFilter(request,response);
    }
}
