package ismail.myapplication.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter { //overriding certain methods to provide our custom security configuration instead of the default one
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /* one of the different ways to tell to spring how to look for users */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //overriding the default (spring) user details with our own custom users details
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    //order of the code should be taken into account
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().disable();
        //over-writing the default permitted url (/login) with a custom one
//        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
//        customAuthenticationFilter.setFilterProcessesUrl("/api/v1/user/login");
//
//        http.csrf().disable();
//
//        //allowed cors origins
//        http.cors().configurationSource(request -> {
//            var cors = new CorsConfiguration();
//            cors.setAllowedOrigins(List.of("http://localhost:3000", "http://127.0.0.1:80"));
//            cors.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//            cors.setAllowedHeaders(List.of("*"));
//            return cors;
//        });
//        http.sessionManagement().sessionCreationPolicy(STATELESS);
//        //allowed paths
//        http.authorizeRequests().antMatchers("/api/v1/user/**", "/api/v1/token/refresh/**", "/booking/**", "/ws/**").permitAll();
//        //permit to only these user roles
//        http.authorizeRequests().antMatchers(GET, "/api/v1/user/**").hasAnyAuthority("ROLE_USER", "ROLE_MANAGER", "ROLE_MANAGER", "ROLE_SUPER_ADMIN");
//        //http.authorizeRequests().antMatchers(POST, "/api/v1/user/save/**").hasAnyAuthority("ROLE_ADMIN");
//        //registering
//        http.authorizeRequests().antMatchers(POST, "/api/v1/user/save/**").permitAll();
//        //chatting
//        http.authorizeRequests().antMatchers(GET, "/ws/**").permitAll();
//        http.authorizeRequests().antMatchers(POST, "/ws/**").permitAll();
//        //adding role to user
//        http.authorizeRequests().antMatchers(POST, "/api/v1/role/**").permitAll();
//        //login
//        http.authorizeRequests().antMatchers(POST, "/api/v1/user/login/**").permitAll();
//        //kiteLesson controller (permitted now for testing to pass)
//        http.authorizeRequests().antMatchers(POST, "/api/v1/kite-lessons/**").permitAll();
//        http.authorizeRequests().antMatchers(GET, "/api/v1/kite-lessons/**").permitAll();
//        http.authorizeRequests().antMatchers(PUT, "/api/v1/kite-lessons/**").permitAll();
//        http.authorizeRequests().antMatchers(DELETE, "/api/v1/kite-lessons/**").permitAll();
//
//        //booking controller
//        http.authorizeRequests().antMatchers(POST, "/booking/**").permitAll();
//        http.authorizeRequests().antMatchers(GET, "/booking/all-bookings/**").permitAll();
//        http.authorizeRequests().antMatchers(PUT, "/booking/update-booking/**").permitAll();
//        http.authorizeRequests().antMatchers(DELETE, "/booking/cancel-booking/**").permitAll();
//
//        //authorize all requests
////        http.authorizeRequests().anyRequest().permitAll();
//        http.authorizeRequests().anyRequest().authenticated();
//        http.addFilter(customAuthenticationFilter);
//        //to make sure that this filter comes before the auto filters,
//        //to intercept every request before any other filters
//        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);


    }

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
}