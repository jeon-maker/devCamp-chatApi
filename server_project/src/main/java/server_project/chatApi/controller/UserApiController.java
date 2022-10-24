package server_project.chatApi.controller;

import server_project.chatApi.domain.Users;
import server_project.chatApi.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

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
    @PostMapping("/login")
    public CreateUserResponse loginUser(@RequestBody @Validated Users request)
    {
        Users loginUser = userService.login(request);
        return new CreateUserResponse(request.getId());

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
