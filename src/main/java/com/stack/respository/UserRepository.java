package com.stack.respository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stack.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public	Optional<User> findByEmailAndPassword(String mobileNo, String password);
}
