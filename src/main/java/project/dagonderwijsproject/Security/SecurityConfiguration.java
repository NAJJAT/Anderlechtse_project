package project.dagonderwijsproject.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class config  extends WebSecurityConfigurerAdapter  {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests -> {
                    authorizeRequests
                            .requestMatchers("/", "/about").permitAll()
                            .requestMatchers("/new", "/save", "/article/").authenticated()
                            .requestMatchers("/users").hasRole("ADMIN")
                            .requestMatchers("/save", "/article/", "/new", "/index").hasRole("USER");
                })
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/") // Redirect to /index after successful login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}