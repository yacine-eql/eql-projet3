package com.eql;

import com.eql.webServices.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EqlProjet3Application implements CommandLineRunner {

	@Autowired
	private EmailSenderService senderService;
	public static void main(String[] args) {SpringApplication.run(EqlProjet3Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

	}
}
