package com.multi.finalProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.multi.member.IJoinMemberDAO;
import com.multi.member.MemberController;
import com.multi.member.teams.IBaseballTeamsDAO;


@SpringBootApplication
@ComponentScan(basePackageClasses = MemberController.class)
@MapperScan(basePackageClasses = IJoinMemberDAO.class)
@MapperScan(basePackageClasses = IBaseballTeamsDAO.class)
public class FinalProject02Application {

	public static void main(String[] args) {
		SpringApplication.run(FinalProject02Application.class, args);
	}

}
