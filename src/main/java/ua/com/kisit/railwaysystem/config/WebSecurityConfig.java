package ua.com.kisit.railwaysystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // 1. ПУБЛІЧНІ СТОРІНКИ - додаємо сюди /login та ресурси
                        .requestMatchers("/", "/trains", "/search", "/registration", "/login").permitAll()
                        .requestMatchers("/static/**", "/css/**", "/js/**", "/images/**").permitAll()

                        // 2. АДМІНКА
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // 3. КОРИСТУВАЧІ
                        .requestMatchers("/my-tickets", "/buy/**").hasAnyRole("USER", "ADMIN")

                        // Всі інші запити потребують авторизації
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/login") // Важливо: шлях, куди форма шле POST
                        .defaultSuccessUrl("/", true) // true - примусово йти на головну після входу
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                );

        return http.build();
    }
}