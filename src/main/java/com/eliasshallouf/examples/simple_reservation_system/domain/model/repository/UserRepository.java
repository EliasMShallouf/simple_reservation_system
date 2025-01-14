package com.eliasshallouf.examples.simple_reservation_system.domain.model.repository;

import com.eliasshallouf.examples.simple_reservation_system.domain.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    @Query ("select u from User u where u.githubEmail = :email")
    User findByEmail(String email);
    @Query ("select u from User u where u.githubEmail = :email AND u.password = :password")
    User findByEmailAndByPassword(String email, String password);
    @Query("select u.isAdmin from User u where u.id = :id")
    Boolean isAdmin(String id);
}
