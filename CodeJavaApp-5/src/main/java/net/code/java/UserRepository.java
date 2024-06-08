package net.code.java;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
    User findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users(birth_date, email, first_name, last_name, password) VALUES (:birthDate, :email, :firstName, :lastName, :password)", nativeQuery = true)
    void saveUser(@Param("birthDate") LocalDate birthDate,
                  @Param("email") String email,
                  @Param("password") String password,
                  @Param("firstName") String firstName,
                  @Param("lastName") String lastName);
    
                  
    
}
