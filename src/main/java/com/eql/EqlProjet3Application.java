package com.eql;

import com.eql.webServices.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;


@SpringBootApplication
public class EqlProjet3Application implements CommandLineRunner {

	@Autowired
	private EmailSenderService senderService;
	public static void main(String[] args) {SpringApplication.run(EqlProjet3Application.class, args);

	}





	@Override
	public void run(String... args) throws Exception {
		/*senderService.sendSimpleEmail(
				"This is email subject",
				"This is email body");  */
	}
}
