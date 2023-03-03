package team.sensivity.ServerAPI.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers("/auth").hasRole(Roles.USER)
                        .antMatchers("/test").hasRole(Roles.ADMIN)
                        .antMatchers("/admin").hasRole(Roles.ADMIN)
                        .anyRequest().authenticated()
                )
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
}
