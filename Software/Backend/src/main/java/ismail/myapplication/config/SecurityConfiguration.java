package ismail.myapplication.config;

import ismail.myapplication.service.user.AuthenticationUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationUserDetailService authenticationUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, AuthenticationConfigConstants.SIGN_UP_URL).permitAll()
                //ROLE BASED AUTHENTICATION START
//            .antMatchers("/api/library/book/**").hasAnyAuthority("USER", "ADMIN")
//            .antMatchers("/api/library/author/**").hasAnyAuthority("ADMIN")
//            .antMatchers("/api/library/member/**").hasAnyAuthority("ADMIN")
                //ROLE BASED AUTHENTICATION END
                .anyRequest().authenticated()
                .and()
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.cors().and().csrf().disable().authorizeRequests().antMatchers(
//                        HttpMethod.POST,
//                        AuthenticationConfigConstants.SIGN_UP_URL,
//                        "/registration/**",
//                        "/js/**",
//                        "/css/**",
//                        "/img/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout")
//                .permitAll();

        /*No restrictions with this code*/
//        http.authorizeRequests().anyRequest().permitAll();
//        http.cors().and().csrf().disable();

//        http.formLogin();
//        http.httpBasic();
    }
}
