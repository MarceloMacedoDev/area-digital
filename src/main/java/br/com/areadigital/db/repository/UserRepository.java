package br.com.areadigital.db.repository;

import br.com.areadigital.db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Transient
    List<User> findByFirstnameContainingIgnoreCase(String name);
    @Transient
    User findByEmail(String username);
}
