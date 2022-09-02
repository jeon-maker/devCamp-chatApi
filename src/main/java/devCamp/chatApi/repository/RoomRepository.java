package devCamp.chatApi.repository;

import devCamp.chatApi.domain.Room;
import devCamp.chatApi.domain.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoomRepository {

    @PersistenceContext
    EntityManager em;

    public Long save(Room room) {
        em.persist(room);
        return room.getId();
    }

    public Room find(Long id) {
        return em.find(Room.class, id);
    }


}
