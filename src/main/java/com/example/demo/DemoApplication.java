package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.ide.assistant;
//import com.example.demo.ide.assistant;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	RepositoryRestConfiguration conf;
	@Autowired
	private UserRepository userDao;
	public static void main(String[] args) {
		System.setProperty( "java.awt.headless", "false" );
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		conf.exposeIdsFor(User.class);//pour que le id apparait
		System.setProperty( "java.awt.headless", "false" );
	new	assistant(userDao);
	}
}
