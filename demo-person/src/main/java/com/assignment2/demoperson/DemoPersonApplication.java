package com.assignment2.demoperson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assignment2.demoperson.entity.Person;
import com.assignment2.demoperson.repository.PersonRepository;

@SpringBootApplication
public class DemoPersonApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonRepository repository;

	
	public static void main(String[] args) {
		SpringApplication.run(DemoPersonApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		
		//Finding Details
		Person person1 = repository.findById(1L);
		Person person2 = repository.findById(2L);
		Person person3 = repository.findById(3L);
		Person person4 = repository.findById(4L);
		logger.info("Person 1 -> {}",person1);
		logger.info("Person 2 -> {}",person2);
		logger.info("Person 3 -> {}",person3);
		logger.info("Person 4 -> {}",person4);

		//Deleting 
		repository.deleteById(1L);
		
		Person person6 = repository.findById(1L);
		logger.info("Person 1 Deleted-> {}",person6);
		
		//Inserting new Details
		repository.save(new Person("Saurav",12000,"HR"));
		Person person5 = repository.findById(1L);
		logger.info("New Person -> {}",person5);
				
	}

}
