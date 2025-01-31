package com.jpa.demo.springbootjpademo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.demo.springbootjpademo.dao.UserRepository;
import com.jpa.demo.springbootjpademo.model.User;


@SpringBootApplication
public class SpringbootjpademoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootjpademoApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		
		//CREATE
		
		//To save single user record
		/*User user = new User();
		user.setName("Reyansh");
		user.setCity("Hyderabad");
		user.setStatus("Iam FullStack");
		User user1 = userRepository.save(user);
		System.out.println(user1);*/
		
		//To save multiple user records
		/*User user1 = new User();
		user1.setName("Ridhansh");
		user1.setCity("Hyderabad");
		user1.setStatus("Doctor");
		
		User user2 = new User();
		user2.setName("Kishor");
		user2.setCity("Kansas");
		user2.setStatus("Developer");
		
		User user3 = new User();
		user3.setName("Reyansh");
		user3.setCity("India");
		user3.setStatus("IPS");
		
		//From Java 9 we can use List.of()
		List<User> users = List.of(user1,user2,user3);
		Iterable<User> insertUsers = userRepository.saveAll(users);
		insertUsers.forEach(user -> {
			System.out.println("Users Inserted Successfully in DB");
			System.out.println("Users List: "+user);
		});*/
		
		//UPDATE
		/*Optional<User> optional = userRepository.findById(1);
		User getuser = optional.get();
		getuser.setStatus("IPS");
		User updatedUser = userRepository.save(getuser);
		System.out.println("User Details Updated: "+updatedUser);*/
		
		//READ
		//To Read single user
		/*Optional<User> optionaluser = userRepository.findById(1);
		User readUser = optionaluser.get();
		System.out.println("User Details: "+readUser);*/
		
		//To Read Mutiple users
		/*Iterable<User> allUsers = userRepository.findAll();	
		allUsers.forEach(user -> System.out.println(user));	*/
		
		//DELETE
		//Delete Single Record
		/*userRepository.deleteById(3);
		System.out.println("User Record Deleted");*/

		//Delete Multiple Records
		/*Iterable<User> deleteallusers = userRepository.findAll();
		deleteallusers.forEach(user -> System.out.println(user));
		userRepository.deleteAll(deleteallusers);
		System.out.println("All User Records Deleted"); */

		//Custom Finder Methods
		/*List<User> userByName = userRepository.findByName("Ridhansh");
		userByName.forEach(user -> System.out.println(user));
		
		List<User> userByNameAndCity = userRepository.findByNameAndCity("Reyansh","India");
		userByNameAndCity.forEach(user -> System.out.println(user));*/
		
		//JPQL
		List<User> users = userRepository.getAllUsers();
		users.forEach(user -> System.out.println(user));
		
		System.out.println("_____________________");
		
		List<User> userbyName = userRepository.getUserByName("Ridhansh");
		userbyName.forEach(user -> System.out.println(user));
		
		System.out.println("___________________");
		
		//Native Query
		List<User> userbyNativeQuery = userRepository.getUsers();
		userbyNativeQuery.forEach(user -> System.out.println(user));
		
	}

}
