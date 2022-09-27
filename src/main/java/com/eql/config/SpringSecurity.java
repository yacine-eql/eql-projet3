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
               .antMatchers("/adminProd").hasRole("ADMIN")
               .antMatchers("/adminSpace").hasRole("ADMIN")
               .antMatchers("/updateAdmin").hasRole("ADMIN")
               .antMatchers("/addLivreur").hasRole("ADMIN")
               .antMatchers("/adminClients").hasRole("ADMIN")
               .antMatchers("/adminLivreurs").hasRole("ADMIN")
               .antMatchers("/space").hasRole("USER")
               .antMatchers("/evaluateCommande").hasRole("USER")
               .antMatchers("/voirPanier").hasAnyRole("USER","ADMIN")
               .antMatchers("/add/{id}").hasRole("USER")
               .antMatchers("/updateAccount").hasAnyRole("USER","ADMIN")
               .antMatchers("/deletePage").hasAnyRole("USER","ADMIN")
               .antMatchers("/index1").permitAll()



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












