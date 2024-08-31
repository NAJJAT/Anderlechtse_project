package project.dagonderwijsproject.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.dagonderwijsproject.Modle.User;
import project.dagonderwijsproject.Repository.UserRepository;

import java.util.List;

@Service
public class UserService {

            @Autowired
    private UserRepository userRepository;
            @Autowired
            private PasswordEncoder passwordEncoder;


            //get all user
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

                //get user by id
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }




            //delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
