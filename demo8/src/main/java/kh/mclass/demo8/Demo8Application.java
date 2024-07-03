package kh.mclass.demo8;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo8Application {

	public static void main(String[] args) {
//		SpringApplication.run(Demo8Application.class, args);
		Arrays.stream(SpringApplication.run(Demo8Application.class, args).getBeanDefinitionNames())
//		.filter((s)->s.contains("board"))
		.forEach(System.out::println);
		System.out.println("==== started ");
	}

}
