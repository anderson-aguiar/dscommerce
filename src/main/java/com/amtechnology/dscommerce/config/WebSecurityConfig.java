package com.amtechnology.dscommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
		http.headers().frameOptions().disable();//libera os frames para funcionar o banco de dados H2
		http.csrf().disable();//desabilita essa config de segurança por ser uma Aplicação Rest que não salva estado
		return http.build();//o build() vai instanciar o objeto
	}
}