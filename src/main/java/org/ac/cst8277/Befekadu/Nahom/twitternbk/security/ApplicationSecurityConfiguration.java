package org.ac.cst8277.Befekadu.Nahom.twitternbk.security;


import org.ac.cst8277.Befekadu.Nahom.twitternbk.service.UserManagementService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
    UserManagementService auther = new UserManagementService();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().authenticated()
                )
                .oauth2Login()
                .successHandler(new AuthenticationSuccessHandler() {

                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {
                        // run custom logics upon successful login
                        System.out.println(auther.createToken());
                        CustomOAuth2User  userDetails = (CustomOAuth2User ) authentication.getPrincipal();
                        String username = userDetails.getAttribute("email");
                        System.out.println("The user " + username + " has logged in.");
                        response.sendRedirect(request.getContextPath());
                    }
                })


        ;
    }
}
