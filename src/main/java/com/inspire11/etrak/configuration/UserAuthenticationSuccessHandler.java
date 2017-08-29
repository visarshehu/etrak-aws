package com.inspire11.etrak.configuration;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;

@Component
@Configuration
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException, RuntimeException {
		HttpSession session = httpServletRequest.getSession();
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		session.setAttribute("email", authUser.getUsername());
		// set our response to OK status
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		authorities.forEach(authority -> {
			if (authority.getAuthority().equals("ADMIN")) {

				try {
					httpServletResponse.sendRedirect("/admin/home");
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			} else if (authority.getAuthority().equals("USER")) {

				try {

					httpServletResponse.sendRedirect("/user/clientStat");
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});

	}
	
	
}