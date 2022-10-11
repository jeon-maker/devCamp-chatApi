package devCamp.chatApi.repository;

import devCamp.chatApi.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<Users , Long> {

    Users findByUserName(@Param("userName") String username);
}
