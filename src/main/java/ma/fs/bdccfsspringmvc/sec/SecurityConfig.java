package ma.fs.bdccfsspringmvc.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        PasswordEncoder encoder =passwordEncoder();
        System.out.println("===============");
        String encoderPassword= encoder.encode("1234");
        System.out.println(encoderPassword);
        System.out.println("===============");
        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(Customizer.withDefaults())
                .formLogin(fl->fl.loginPage("/login").permitAll())
                //.authorizeHttpRequests(auth -> auth.requestMatchers("/user/**").hasRole("USER"))
                //.authorizeHttpRequests(auth -> auth.requestMatchers("/admin/**").hasRole("ADMIN"))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/public/**" , "/webjars/**").permitAll())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .exceptionHandling(eh->eh.accessDeniedPage("/notAuthorized"))
                .build();
    }
}
