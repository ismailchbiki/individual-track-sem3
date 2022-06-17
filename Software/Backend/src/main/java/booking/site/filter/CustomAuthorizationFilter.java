package booking.site.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//getting the token from the user and giving them access to the app
//in the class, we verify the token (as the authentication) from the user,
//to allow them into the app
@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {
    //this filter intercept every request coming to the app,
    //and look for the specific token,
    //to determine what the user is authorized to do
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //pass the filtering (don't do anything)
        if (request.getServletPath().equals("/users/user/login")
                || request.getServletPath().equals("/users/token/refresh")
                || request.getServletPath().equals("/users/user/save")
                || request.getServletPath().equals("/kite-lessons")
        ) {
            filterChain.doFilter(request, response);
        } else {
            //every time there is a request from the frontend to the backend,
            //the token is sent back after a successful authentication
            //then a second request is sent with the token
            String authorizationHeader = request.getHeader(AUTHORIZATION);
            //Bearer is to show that this is our json web token
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                try {
                    //isolate the token
                    String token = authorizationHeader.substring("Bearer ".length());
                    //defining the algorithm again
                    Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                    //verifying if the token is valid
                    JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = jwtVerifier.verify(token);
                    //grabbing the username from the user and setting it to the decoded token
                    String username = decodedJWT.getSubject();
                    //getting the roles, by passing the key of the claim, and collecting it as an array
                    String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                    //after the user is being authenticated and their json web token is valid,
                    //we set them into the authentication context
                    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    //conversion
                    stream(roles).forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
                    //calling Username and password token authentication
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(username, null, authorities);
                    //Summary: this is how we tell to spring security,
                    //that this is the username and their roles and what they are authorized to do
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    //pass the filtering
                    filterChain.doFilter(request, response);
                } catch (Exception exception) {
                    log.error("Error logging in: {}", exception.getMessage());
                    response.setHeader("error", exception.getMessage());
                    response.setStatus(FORBIDDEN.value());
                    Map<String, String> error = new HashMap<>();
                    error.put("error_message", exception.getMessage());
                    response.setContentType(APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(), error);
                }
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }
}
