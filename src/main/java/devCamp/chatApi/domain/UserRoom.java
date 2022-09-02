package devCamp.chatApi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class UserRoom {

    @Id @GeneratedValue
    @Column(name = "userRoom_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private Long user__id; // user _ id 넣기

    private Long Room__id; // room _ id 넣기

}
