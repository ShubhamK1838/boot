package com.learn.learnboot;

import com.learn.learnboot.jpa.dao.UserOperation;
import com.learn.learnboot.jpa.dao.UserRepository;
import com.learn.learnboot.jpa.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication // it is combination of following Annotation
//@Component
//@ComponentScan
//@EnableAutoConfiguration
public class LearnbootApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(LearnbootApplication.class, args);


	}

}
