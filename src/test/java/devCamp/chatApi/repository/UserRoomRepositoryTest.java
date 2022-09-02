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
        userRoom1.setUsers(users1);
        userRoom1.setRoom(room1);
        Users user2 = new Users();
        user2.setUserName("Gu");
        UserRoom userRoom2 = new UserRoom();
        userRoom2.setUsers(user2);
        userRoom2.setRoom(room1);
        usersRepository.save(user2);
        userRoomRepository.save(userRoom1);
        userRoomRepository.save(userRoom2);

        Room room2 = new Room();
        room2.setRoomName("room2");

        UserRoom userRoom3 = new UserRoom();
        userRoom3.setUsers(users1);
        userRoom3.setRoom(room2);
        roomRepository.save(room2);
        userRoomRepository.save(userRoom3);
    }

}