package devCamp.chatApi.repository;


import devCamp.chatApi.domain.Room;
import devCamp.chatApi.domain.UserRoom;
import devCamp.chatApi.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UserRoomRepositoryTest {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    UserRoomRepository userRoomRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testUserRoom(){
        UserRoom userRoom1 = new UserRoom();
        Users users1 = new Users();
        Room room1 = new Room();
        users1.setUserName("Jeon");
        room1.setRoomName("CHAT_ROOM");
        usersRepository.save(users1);
        roomRepository.save(room1);
        userRoom1.setUser__id(users1.getId());
        System.out.println("users1.getId()= " + users1.getId());
        userRoom1.setRoom__id(room1.getId());
        System.out.println("room1.getId() = " + room1.getId());

        userRoomRepository.save(userRoom1);
    }

}