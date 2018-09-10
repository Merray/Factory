package com.sopra.Factory.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sopra.Factory.services.CustomUserDetailService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private CustomUserDetailService userDetailService;

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests().antMatchers(HttpMethod.OPTIONS).anonymous();
        http.headers().frameOptions().disable();
        // http.authorizeRequests().antMatchers("/**/edit").authenticated().and().formLogin().antMatchers("/**").permitAll();
        http.authorizeRequests().antMatchers("/**/edit").authenticated().and().formLogin().loginPage("/login")
                .failureUrl("/login?error=erreur").permitAll().and().logout().permitAll()
                .logoutSuccessUrl("/adherent/");
        http.authorizeRequests().antMatchers("/adherent/").permitAll();
        http.authorizeRequests().antMatchers("/article/").permitAll();
        

        http.authorizeRequests().antMatchers("/rest/**").authenticated().and().httpBasic();
		System.out.println(getPasswordEncoder().encode("olivier"));

	}

	// @Override
	// protected void configure(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth.inMemoryAuthentication().withUser("olivier").password("{noop}olivier").roles("ADMIN");
	// }

	// @Override
	// protected void configure(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth.jdbcAuthentication().dataSource(dataSource)
	// .usersByUsernameQuery("select username,password,enable from users where
	// username=?")
	// .authoritiesByUsernameQuery("select username,role from user_roles where
	// username=?");
	//
	// }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(getPasswordEncoder());
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
