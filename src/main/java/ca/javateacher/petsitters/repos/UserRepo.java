package ca.javateacher.petsitters.repos;

import ca.javateacher.petsitters.base.UserType;
import ca.javateacher.petsitters.ents.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by iuliana.cosmina on 2/23/16.
 */
@Transactional(readOnly = true)
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username like %?1%")
    List<User> findAllByUserName(String username);

    @Query("select u from User u where u.userType= :userType")
    List<User> findByType(UserType userType);

    @Query("select u.email from User u where u.userType= :userType")
    List<String> getEmailsByType(UserType userType);

    @Query("select u from User u where u.username= :un")
    User findOneByUsername(@Param("un") String username);

    @Query("select u from User u where u.email= :email")
    User findByEmail(@Param("email") String email);

    @Query("select u.username from User u where u.id= :id")
    String findUsernameById(Long id);

    @Query("select count(u) from User u")
    long countUsers();

}
