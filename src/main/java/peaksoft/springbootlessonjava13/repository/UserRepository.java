package peaksoft.springbootlessonjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.springbootlessonjava13.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

//    User getUserByEmail(String email);

    @Query("select u from User u where u.email=:email")
    User getUserWithEmail(String email);

    User findByAge(int age);

}
