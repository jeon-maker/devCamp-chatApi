package server_project.chatApi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Room {

    @Id @GeneratedValue
    @Column(name = "room_id")
    private Long id;

    private String roomPassword;

    private String roomName;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;

    private String createUser;

    @OneToMany(mappedBy = "room")
    private List<UserRoom> roomList = new ArrayList<>();

}
