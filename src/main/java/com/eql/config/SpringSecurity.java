package com.eql.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SpringSecurity {
    @Bean
    public static PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       http.csrf().disable()
               .authorizeHttpRequests()
               .antMatchers("/register/**").permitAll()
               .antMatchers("/index").permitAll()
               .antMatchers("/carte").permitAll()
               .antMatchers("/menu").permitAll()
               .antMatchers("/contact").permitAll()
               .antMatchers("/engagement").permitAll()
               .antMatchers("/users").hasRole("ADMIN")
               .antMatchers("/adminProd").hasRole("ADMIN")
               .antMatchers("/adminSpace").hasRole("ADMIN")
               .antMatchers("/space").hasRole("USER")
               .antMatchers("/voirPanier").hasRole("USER")
               .antMatchers("/add/{id}").hasRole("USER")




               .and()
               .formLogin(
                       form ->form
                               .loginPage("/login")
                               .loginProcessingUrl("/login")
                               .defaultSuccessUrl("/index")

                               .permitAll()
               ).logout(
                       logout -> logout
                               .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                               .permitAll()
               );

        return http.build();

    }
}












