package com.jpa.demo.springbootjpademo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpa.demo.springbootjpademo.model.User;

//public interface UserRepository extends CrudRepository<User, Integer> {
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findByName(String name);
    
    public List<User> findByNameAndCity(String name, String city);

    @Query("SELECT u FROM User u")
    public List<User> getAllUsers();
    
    @Query("SELECT u FROM User u WHERE u.name=:n")
    public List<User> getUserByName(@Param("n") String name);
    
    @Query(value="SELECT * FROM user", nativeQuery=true)
    public List<User> getUsers();

}
