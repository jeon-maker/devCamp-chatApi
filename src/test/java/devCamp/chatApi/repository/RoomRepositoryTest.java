package devCamp.chatApi.repository;

import devCamp.chatApi.domain.Room;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
public class RoomRepositoryTest {

    @Autowired RoomRepository roomRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testRoom(){
        Room room = new Room();
        room.setRoomName("Room1");
        room.setRoomPassword("Password1");
        Long saveID = roomRepository.save(room);
        Room findRoom = roomRepository.find(saveID);

        Assertions.assertThat(findRoom.getId()).isEqualTo(saveID);

        Assertions.assertThat(findRoom.getRoomName()).isEqualTo("Room1");

        Assertions.assertThat(findRoom.getRoomPassword()).isEqualTo("Password1");
    }

}