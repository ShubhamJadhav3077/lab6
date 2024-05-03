package com.lab6.CollegeFest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.lab6.CollegeFest.serviceimpl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurity {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authenticationProvider(myAuthProvider());
//		http.authorizeRequests().requestMatchers("/", "/studentsview", "/students/addform", "/403")
//				.hasAnyAuthority("USER", "ADMIN").requestMatchers("/students/editform/**", "/deletestudent/**")
//				.hasAuthority("ADMIN").anyRequest().authenticated().and().formLogin().loginProcessingUrl("/login")
//				.successForwardUrl("/studentsview").permitAll().and().logout().logoutSuccessUrl("/login").permitAll()
//				.and().exceptionHandling().accessDeniedPage("/403").and().cors().and().csrf().disable();
		return http.build();
	}

	@Bean
	public DaoAuthenticationProvider myAuthProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(myUserDetails());
		daoAuthenticationProvider.setPasswordEncoder(myPasswordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	public PasswordEncoder myPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService myUserDetails() {
		return new UserDetailsServiceImpl();
	}

}
