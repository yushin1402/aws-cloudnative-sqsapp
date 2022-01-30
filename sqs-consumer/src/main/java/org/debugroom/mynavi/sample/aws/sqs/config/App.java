package org.debugroom.mynavi.sample.aws.sqs.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
//
//@SpringBootApplication
//public class App implements CommandLineRunner {
//
//    @Autowired
//    private ApplicationContext appContext;
//
//    public static void main(String[]args) throws Exception {
//        SpringApplication.run(App.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        String[]beans = appContext.getBeanDefinitionNames();
//        Arrays.sort(beans);
//       for (String bean : beans) {
//            System.out.println(bean);
//        }
//
//    }

//}