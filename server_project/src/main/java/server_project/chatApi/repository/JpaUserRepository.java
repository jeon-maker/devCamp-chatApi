package server_project.chatApi.repository;

import server_project.chatApi.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface JpaUserRepository extends JpaRepository<Users , Long> {

    Users findByUserName(@Param("userName") String username);
}
