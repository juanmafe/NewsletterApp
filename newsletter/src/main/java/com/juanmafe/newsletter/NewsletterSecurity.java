package com.juanmafe.newsletter;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security
 * @author juanmafe.
 */
@EnableWebSecurity
public class NewsletterSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST).authenticated().and().httpBasic();
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.DELETE).authenticated().and().httpBasic();
	}

}