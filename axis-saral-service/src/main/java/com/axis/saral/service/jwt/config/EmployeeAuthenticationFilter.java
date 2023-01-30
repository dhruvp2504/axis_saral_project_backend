package com.axis.saral.service.jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.axis.saral.service.jwt.service.CustomEmployeeDetailsService;
import com.axis.saral.service.jwt.utils.JwtUtil;


@Component
public class EmployeeAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomEmployeeDetailsService customEmployeeDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//get jwt
		//Bearer
		
		//validate			
		
		String requestTokenHeader =  request.getHeader("Authorization");
		
		String username = null;
		
		String jwtToken = null;
		
		if(requestTokenHeader!= null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				
				username= this.jwtUtil.extractUsername(jwtToken);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			//security
			UserDetails userDetails = this.customEmployeeDetailsService.loadUserByUsername(username);
			
			if(username!= null && SecurityContextHolder.getContext().getAuthentication()==null) {
				
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=	new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
			
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}else {
				System.out.println("Token is null");
			}
			
		}
		
		filterChain.doFilter(request, response);	 
		
	}

}
