package pl.sda.spiring.miniblog12.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.spiring.miniblog12.entity.User;
import pl.sda.spiring.miniblog12.form.UserRegisterForm;
import pl.sda.spiring.miniblog12.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void registerUser(UserRegisterForm userRegisterForm) {
        User user = new User();
        user.setFirstName(userRegisterForm.getFirstName());
        user.setLastName(userRegisterForm.getLastName());
        user.setEmail(userRegisterForm.getEmail());
        user.setPassword(userRegisterForm.getPassword());
        userRepository.save(user);
    }
    public boolean loginUser(String username, String password) {
        Optional<User> userOptional = userRepository.findByEmail(username);
        if (!userOptional.isPresent()) {
            return false;
        }
        if (userOptional.get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}