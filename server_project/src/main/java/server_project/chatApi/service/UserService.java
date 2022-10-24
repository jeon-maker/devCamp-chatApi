package server_project.chatApi.service;

import server_project.chatApi.domain.Users;
import server_project.chatApi.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    JpaUserRepository jpaUserRepository;

    /**
     * 회원가입
     */
    @Transactional // 변경
    public Long join(Users users){
        validateDuplicateUser(users); // 중복 회원 검증
        validateNullPassword(users); // 비밀번호 없으면 에러
        jpaUserRepository.save(users);
        return users.getId();
    }

    private void validateNullPassword(Users users) {
        String password = users.getPassword();
        if(password == null){
            throw new IllegalStateException("비밀번호를 입력하세요");
        }
    }

    private void validateDuplicateUser(Users users) {
        Users findUser = jpaUserRepository.findByUserName(users.getUserName());
        if(findUser != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }
    /**
     * 전체 회원 조회
     * */
    public List<Users> findUsers(){
        return jpaUserRepository.findAll();
    }

    /**
     * 로그인 기능 구현
     * */
    public Users login(Users user){
        Users findUser = jpaUserRepository.findByUserName(user.getUserName());
        if(findUser == null){
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        String password = user.getPassword();
        String findUserPassword = findUser.getPassword();
        if(password != findUserPassword){
            throw new IllegalStateException("비밀번호가 틀립니다");
        }
        else{
            System.out.println("로그인 성공!");
            return user;
        }

    }
}
