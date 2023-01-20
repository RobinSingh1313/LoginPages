package com.ass.login;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.ass.login.User;
import com.ass.login.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository repo;
	
	@Test
	public void testCreateUser() {
		User user=new User();
		user.setEmail("robinsingh13213@gmail");
		user.setPassword("Ashnoor13@");
		user.setFirstName("RObin");
		user.setLastName("Singh");
		User savedUser=repo.save(user);
		
		User exitUser=entityManager.find(User.class, savedUser.getId());
		assertThat(user.getEmail()).isEqualTo(exitUser.getEmail());
		
		
		
		
	}
	
	@Test
	public void testFindByEmail() {
		String email = "robinsingh13213@gmail.com";
		User user=repo.findByEmail(email);
		assertThat(user.getEmail()).isEqualTo(email);
		
	}
}
