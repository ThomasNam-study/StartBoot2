package kr.purred.startboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Startboot2Application {

	public static void main (String[] args) {
		SpringApplication.run (Startboot2Application.class, args);
	}
}
