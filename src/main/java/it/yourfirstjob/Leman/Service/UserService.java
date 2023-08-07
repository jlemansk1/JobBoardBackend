package it.yourfirstjob.Leman.Service;

import it.yourfirstjob.Leman.Model.User;
import it.yourfirstjob.Leman.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    public User getUserById(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }
}
