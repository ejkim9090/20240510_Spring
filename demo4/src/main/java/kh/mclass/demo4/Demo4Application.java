package kh.mclass.demo4;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Demo4Application.class, args);
		// 주입된 객체들 확인  //filter 로 확인
//		Arrays.stream(context.getBeanDefinitionNames())
//		.filter(s -> s.contains("board"))
//		.forEach(System.out::println);
	}

}
