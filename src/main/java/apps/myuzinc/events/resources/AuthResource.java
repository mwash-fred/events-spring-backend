package apps.myuzinc.events.resources;

import apps.myuzinc.events.dao.Users.UsersService;
import apps.myuzinc.events.dto.CredentialsDto;
import apps.myuzinc.events.dto.LoginDto;
import apps.myuzinc.events.dto.ResponseTemplate;
import apps.myuzinc.events.dto.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthResource {
    private final UsersService usersService;

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseTemplate<CredentialsDto>> signIn(@Valid @RequestBody LoginDto loginDto){
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseTemplate.<CredentialsDto>builder()
                        .message("login Successful")
                        .httpStatus(HttpStatus.OK.value())
                        .data( usersService.signIn(loginDto))
                        .build()
        );
    }

    @PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseTemplate<UserDto>> signUp(@Valid @RequestBody UserDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseTemplate.<UserDto>builder()
                        .message("Registration Successful")
                        .httpStatus(HttpStatus.OK.value())
                        .data( usersService.save(dto))
                        .build()
        );
    }


}
