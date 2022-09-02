package devCamp.chatApi.repository;

import devCamp.chatApi.domain.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UsersRepository {

    @PersistenceContext
    EntityManager em;

    // 회원 저장
    public Long save(Users users) {
        em.persist(users);
        return users.getId();
    }
    //회원 조회
    public Users find(Long id) {
        return em.find(Users.class, id);
    }
}
