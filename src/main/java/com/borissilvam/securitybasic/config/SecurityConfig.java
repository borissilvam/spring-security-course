package com.borissilvam.securitybasic.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (requests) -> requests
                                .requestMatchers("myAccount", "myBalance", "myCards", "myLoans").authenticated()
                                .requestMatchers("myContact", "myNotices").permitAll()
        );
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();

        

        //Negar el acceso a cualquier peticion
//        http.authorizeHttpRequests(
//                (requests) -> requests.anyRequest().denyAll()
//        );
//        http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());
//        return http.build();
//

        //Permitir el acceso a cualquier peticion
//        http.authorizeHttpRequests(
//                (requests) -> requests.anyRequest().permitAll()
//        );
//        http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());
//        return http.build();



    }
}
