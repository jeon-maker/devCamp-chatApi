package devCamp.chatApi.repository;

import devCamp.chatApi.domain.Room;
import devCamp.chatApi.domain.UserRoom;
import devCamp.chatApi.domain.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRoomRepository {

    @PersistenceContext
    EntityManager em;

    public Long save(UserRoom userRoom) {
        em.persist(userRoom);
        return userRoom.getId();
    }

    public UserRoom find(Long id){
        return em.find(UserRoom.class, id);
    }
}
