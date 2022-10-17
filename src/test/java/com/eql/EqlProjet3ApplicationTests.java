package com.eql;

import com.eql.dto.UserDto;
import com.eql.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EqlProjet3ApplicationTests {

	@Autowired
	UserService userService ;

	@Test
	void testRegister1() {
		UserDto user = new UserDto
				("nom", "prenom","a@a","adress", "0612453287", "password");
		userService.saveUser(user);
		System.out.println(userService.findUserById(user.getId()));
	}

	@Test
	void testRegister2() {
		UserDto user = new UserDto
				("nom", "prenom","aaa","adress", "0612453287", "password");
		userService.saveUser(user);
		System.out.println(userService.findUserById(user.getId()));
	}

	@Test
	void testRegister3() {
		UserDto user = new UserDto
				("nom", "prenom","","adress", "0612453287", "password");
		userService.saveUser(user);
		System.out.println(userService.findUserById(user.getId()));
	}

	@Test
	void testRegister4() {
		UserDto user = new UserDto
				("nom", "prenom","a@a","adress", "0612453287", "password");
		userService.saveUser(user);
		System.out.println(userService.findUserById(user.getId()));
	}

	@Test
	void testRegister5() {
		UserDto user = new UserDto
				("nom", "prenom","b@b","adress", "0612453287", "");
		userService.saveUser(user);
		System.out.println(userService.findUserById(user.getId()));
	}

	@Test
	void testRegister6() {
		UserDto user = new UserDto
				("nom", "prenom","b@b","adress", "0612453287", "123");
		userService.saveUser(user);
		System.out.println(userService.findUserById(user.getId()));
	}
}
