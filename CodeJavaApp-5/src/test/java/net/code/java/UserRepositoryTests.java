package net.code.java;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	@Test
	public void testCreateUser() {
		User user= new User();
		user.setEmail("anikpirayebulut@hotmail.com");
		user.setPassword("290424");
		user.setFirstName("Piraye");
		user.setLastName("Bulut");
		user.setBirthDate(LocalDate.of(2003, 1, 23));
		User savedUser=repo.save(user);
		
		User existUser= entityManager.find(User.class, savedUser.getId());
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
		User user2= new User();
		user2.setEmail("baranbulut@hotmail.com");
		user2.setPassword("31012006");
		user2.setFirstName("Baran");
		user2.setLastName("Bulut");
		user2.setBirthDate(LocalDate.of(2006, 1, 31));
		User savedUser2=repo.save(user2);
		
		User existUser2= entityManager.find(User.class, savedUser2.getId());
		assertThat(existUser2.getEmail()).isEqualTo(user2.getEmail());
	}
	@Test
	public void testFindUserByEmail() {
		String email="anikpirayebulut@hotmail.com";
		User user=repo.findByEmail(email);
	}
	

}


