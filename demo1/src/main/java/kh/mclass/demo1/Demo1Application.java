package kh.mclass.demo1;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(Demo1Application.class, args);
		// 주입된 객체들 확인
		String[] beansNameArr = appContext.getBeanDefinitionNames();
		
		System.out.println("====");
//		for(String beanName : beansNameArr) {
//			System.out.println(beanName);
//		}
		Arrays.stream(appContext.getBeanDefinitionNames()).forEach(System.out::println);
		System.out.println("====a === filter");
		Arrays.stream(appContext.getBeanDefinitionNames()).filter(s->s.contains("demo")).forEach(System.out::println);
		
		System.out.println("====b");
	}

}
