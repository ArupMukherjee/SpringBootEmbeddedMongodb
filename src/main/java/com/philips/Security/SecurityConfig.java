package com.philips.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password("secret1").roles("USER")
				.and().withUser("admin1").password("secret1").roles("USER", "ADMIN")
				.and().withUser("amukherjee").password("123456").roles("ADMIN");
				
	}

	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().
				antMatchers("/pets").hasRole("USER").
				antMatchers("/**").hasRole("ADMIN").and().csrf().disable().headers().frameOptions().disable();
	}

}


