package com.learn.learnboot.jpa.dao;

import com.learn.learnboot.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("userDao")
public class UserOperation {
/*

    this class for only  know the which Operation we can perform on any entity
    to perform operation we can simply use the UserRepository o.w any Repository

 */
    @Autowired
    UserRepository repo;

    public User save(User user){
        return  repo.save(user);
    }

    public void  saveAll(List<User> users){
         repo.saveAll(users);
    }
    public void delete(int id )
    {
        repo.deleteById(id);
    }
    public void delete(User user)
    {
        repo.delete(user);
    }
    public void delete(List<User> users)
    {
        repo.deleteAll(users);
    }
    public void delete()
    {
        repo.deleteAll();
    }
    public User update(User user)
    {
        // if present then update o.w add
        return repo.save(user);
    }

    public List<User> get()
    {
        return (List<User>) repo.findAll();
    }

    public User findById(int id )
    {
      Optional<User>  optional = repo.findById(id);
         if(optional.isEmpty())
             return null;
      return optional.get();
    }



}
