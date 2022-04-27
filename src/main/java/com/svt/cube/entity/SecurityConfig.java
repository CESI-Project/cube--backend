// package com.svt.cube.entity;

// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.web.cors.CorsConfiguration;
// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import
// org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import
// com.bezkoder.spring.security.postgresql.security.jwt.AuthEntryPointJwt;
// import com.bezkoder.spring.security.postgresql.security.jwt.AuthTokenFilter;
// import
// com.bezkoder.spring.security.postgresql.security.services.UserDetailsServiceImpl;

// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

// @Override
// protected void configure(HttpSecurity http) throws Exception {
// CorsConfiguration corsConfiguration = new CorsConfiguration();
// corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control",
// "Content-Type"));
// corsConfiguration.setAllowedOrigins(List.of("*"));
// corsConfiguration
// .setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT", "OPTIONS",
// "PATCH", "DELETE"));
// corsConfiguration.setExposedHeaders(List.of("Authorization"));

// // You can customize the following part based on your project, it's only a
// // sample
// http.authorizeRequests().antMatchers("/**").permitAll().anyRequest()
// .authenticated().and().csrf().disable().cors().configurationSource(request ->
// corsConfiguration);

// }
// }