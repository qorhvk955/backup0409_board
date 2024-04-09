package com.green.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;
import lombok.extern.log4j.Log4j2;

@Configuration
@EnableWebSecurity
@Log4j2
public class SecurityConfig {
	
	// 비밀번호 인코더
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 시큐리티 필터체인 설정
	@Bean
	public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
		log.info("====================필터체인 작동구간====================");
		// 권한처리 모두 열기
		http.authorizeHttpRequests((auth)->{
			auth.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
			.anyRequest().permitAll();
		});
		
		http.csrf((csrf)->csrf.disable());
		return http.build();
	}
}
