package peaksoft.springbootlessonjava13.service;

import peaksoft.springbootlessonjava13.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    void updateUser(Long userId, User user);

    void deleteUser(Long id);

    User getUserByEmail(String email);


}
