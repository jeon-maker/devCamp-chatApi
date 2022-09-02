package devCamp.chatApi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Users {

    @Id @GeneratedValue
    @Column(name = "users_id")
    private Long id;

    private String userName;

    private String password;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;

    @OneToMany(mappedBy = "users")
    private List<UserRoom> usersList = new ArrayList<>();





}
