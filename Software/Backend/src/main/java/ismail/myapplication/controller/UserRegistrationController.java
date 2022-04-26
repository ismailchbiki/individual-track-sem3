package ismail.myapplication.controller;

import ismail.myapplication.dto.user.UserCreateRequest;
import ismail.myapplication.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/registration")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserService userService;

    @GetMapping
    public String Hello(){
        return "hello name";
    }

    @PostMapping
    public ResponseEntity<UserCreateRequest> registrationUserAccount(@RequestBody UserCreateRequest userCreateRequest ){
        userService.save(userCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreateRequest);
    }
}
