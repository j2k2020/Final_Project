package com.multi.finalProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.multi.member.IJoinDAO;
import com.multi.member.MemberController;

@SpringBootApplication
@ComponentScan(basePackageClasses = MemberController.class)
@MapperScan(basePackageClasses = IJoinDAO.class)
public class FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

}
