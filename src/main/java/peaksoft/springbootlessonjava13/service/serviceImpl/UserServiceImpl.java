package peaksoft.springbootlessonjava13.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.springbootlessonjava13.entity.User;
import peaksoft.springbootlessonjava13.repository.UserRepository;
import peaksoft.springbootlessonjava13.service.UserService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new NullPointerException(
                        "User with id " + userId + " is not found!"
                )
        );
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(Long userId, User user) {
        User oldUser = getUserById(userId);
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        userRepository.save(oldUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new NullPointerException(
                    "User with id: " + id + " is not found"
            );
        }

    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserWithEmail(email);
    }
}
