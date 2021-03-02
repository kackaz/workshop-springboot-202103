package com.example.workshop1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static java.lang.System.out;

@SpringBootApplication
public class Workshop1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Workshop1Application.class, args);
		for (String bean : context.getBeanDefinitionNames()) {
			out.println(bean);
		}
		out.println(context.getBeanDefinitionCount());

		User user1 = context.getBean(User.class);
		user1.setName("Ruangwit");
		out.println(user1.getName());

		User user2 = context.getBean(User.class);
		user2.setName("User 2");
		out.println(user2.getName());
		out.println(user1.getName());

	}

}
