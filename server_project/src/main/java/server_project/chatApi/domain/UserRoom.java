package server_project.chatApi.domain;

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

    /**
     *  만든 코드
     * */
    private Long user__id; // user _ id 넣기

    private Long Room__id; // room _ id 넣기

    //==연관관계 메서드==//
    public void setUsers(Users users) {
        this.users = users;
        users.getUsersList().add(this);
    }

    public void setRoom(Room room){
        this.room = room;
        room.getRoomList().add(this);
    }


}
