package devCamp.chatApi.controller;

import devCamp.chatApi.domain.Users;
import devCamp.chatApi.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.apache.catalina.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/join/users")
    public CreateUserResponse saveUser(@RequestBody @Validated CreateUserRequest request)
    {
        Users users = new Users();
        users.setUserName(request.getName());
        users.setPassword(request.getPw());

        Long id = userService.join(users);
        return new CreateUserResponse(id);

    }

    @Data
    static class CreateUserRequest{
        private String name;
        private String pw;
    }
    @Data
    static class CreateUserResponse{
        private Long id;
        public CreateUserResponse(Long id){
            this.id = id;
        }
    }
}
