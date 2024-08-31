package com.learn.learnboot.jpa.dao;

import com.learn.learnboot.jpa.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {


    /*
        to Define our own query we can write method prototype and that implementation automatically
        provide jpa ony needs to define method prototype
     */

//    to find user by name sometime multiple user has same name

    public java.util.List<User> findByFirstName(String name);

    // we can take the user which has first name ? and last name ?

    public User findByFirstNameAndLastName(String firstName, String lastName);

    public List<User> getByAge(int age);

    // Suppose we have some complex query then ther is reqired to write the query so we can write native query and
//     jpa query


    @Query("select u  from User u where u.firstName=:fn ")
    public List<User> getUsers(@Param("fn") String firstName);

    // Native query

    @Query(value = "select * from User where first_name =:fn or age=:ag" , nativeQuery = true)
    public List<User> getUsers(
           @Param("fn") String firstName,
           @Param("ag") int  lastName
    );

}
