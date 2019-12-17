package pl.sda.spiring.miniblog12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.spiring.miniblog12.entity.User;

import java.awt.*;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    List<User> zero lub wiecej niz jeden user

    //zero lub jeden
    Optional<User> findByEmail(String email);





}
