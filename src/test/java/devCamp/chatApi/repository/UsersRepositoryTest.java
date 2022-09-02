package devCamp.chatApi.repository;

import devCamp.chatApi.domain.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;




@SpringBootTest
public class UsersRepositoryTest {

    @Autowired UsersRepository usersRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testUsers() {
        Users users = new Users();
        users.setUserName("memberA");
        Long savedId = usersRepository.save(users);
        Users findMember = usersRepository.find(savedId);
        System.out.println("users.getId() = " + users.getId());
        Assertions.assertThat(findMember.getId()).isEqualTo(users.getId());

        Assertions.assertThat(findMember.getUserName()).isEqualTo(users.getUserName())
        ;
        Assertions.assertThat(findMember).isEqualTo(users); //JPA 엔티티 동일성 보장
    }
}
