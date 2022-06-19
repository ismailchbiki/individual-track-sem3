package booking.site.user.controller;

import booking.site.exception.RefreshTokenNotFoundException;
import booking.site.user.dto.RoleDTO;
import booking.site.user.dto.UserDTO;
import booking.site.user.entity.Role;
import booking.site.user.service.UserUseCase;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserUseCase userUseCase;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok().body(userUseCase.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        //returns specific details instead of just 200 response
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userUseCase.saveUser(userDTO));
    }

    @PostMapping("/role/save")
    public ResponseEntity<RoleDTO> saveRole(@RequestBody RoleDTO roleDTO) {
        //returns specific details instead of just 200 response
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userUseCase.saveRole(roleDTO));
    }

    @PostMapping("/role/add-to-user")
    public ResponseEntity<RoleToUserForm> addRoleToUser(@RequestBody RoleToUserForm form) {
        userUseCase.addRoleToUser(form.getEmail(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //looking for the header authorization (the key for the authorization header)
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        //Bearer is to show that this is our json web token
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                //getting the refresh token and isolating it
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                //getting and defining the algorithm
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                //verifying if the refresh token is valid
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                //decode the refresh token
                DecodedJWT decodedJWT = jwtVerifier.verify(refreshToken);
                //get the username
                String username = decodedJWT.getSubject();
                //once we get the username, we should load the user,
                //(to check if the user exists in the DB)
                UserDTO userDTO = userUseCase.getUser(username);

                //creating the token
                String accessToken = JWT.create()
                        .withSubject(userDTO.getEmail())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", userDTO.getRoles().stream().map(Role::getName)
                                .toList())
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("accessToken", accessToken);
                tokens.put("refreshToken", refreshToken);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
                response.setStatus(FORBIDDEN.value());
                response.setHeader("error", exception.getMessage());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RefreshTokenNotFoundException("Refresh token is missing");
        }
    }
}

@Data
class RoleToUserForm {
    private String email;
    private String roleName;
}
