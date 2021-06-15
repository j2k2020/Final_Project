package com.multi.finalProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.multi.member.IJoinDAO;
import com.multi.member.MemberController;
import com.multi.member.Defense01.IDefense01DAO;
import com.multi.member.Pitcher01.IPitcher01DAO;
import com.multi.member.hitter01.IHitter01DAO;
import com.multi.member.teams.IBaseballTeamsDAO;

@SpringBootApplication
@ComponentScan(basePackageClasses = MemberController.class)
@MapperScan(basePackageClasses = IJoinDAO.class)
@MapperScan(basePackageClasses = IBaseballTeamsDAO.class)
@MapperScan(basePackageClasses = IDefense01DAO.class)
@MapperScan(basePackageClasses = IHitter01DAO.class)
@MapperScan(basePackageClasses = IPitcher01DAO.class)
public class FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

}
