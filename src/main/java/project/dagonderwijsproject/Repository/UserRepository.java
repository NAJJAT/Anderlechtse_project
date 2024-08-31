package project.dagonderwijsproject.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.dagonderwijsproject.Modle.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    User findByUsername(String username);
}
