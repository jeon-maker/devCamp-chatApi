package server_project.chatApi.service;


import server_project.chatApi.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Fail.fail;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    JpaUserRepository jpaUserRepository;

//    @Test
//    public void join_test() throws Exception{
//        Users userA = new Users();
//        userA.setUserName("Jeon");
//
//        Users userB = new Users();
//        userB.setUserName("Kim");
//
//        userService.join(userA);
//        userService.join(userB);
//
//        fail("예외가 발생해야 함!");
//    }
//
//
}