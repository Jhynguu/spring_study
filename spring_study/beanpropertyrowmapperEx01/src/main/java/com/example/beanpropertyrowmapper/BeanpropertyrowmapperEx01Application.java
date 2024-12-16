package com.example.beanpropertyrowmapper;

import com.example.beanpropertyrowmapper.dto.User;
import com.example.beanpropertyrowmapper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanpropertyrowmapperEx01Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args){
		SpringApplication.run(BeanpropertyrowmapperEx01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 모든 유저 조회
		System.out.println("모든 사용자");
		userRepository.findAllUsers().forEach(user -> {
			System.out.println("이름 : " + user.getName() + " 아이디 : " + user.getId() + " 이메일 : " + user.getEmail());
		});

		// 특정 유저 조회
		User user = userRepository.findUserById(1);
		if (user != null) {
			System.out.println("특정 사용자 : ");
			System.out.println("이름 : " + user.getName() + " 아이디 : " + user.getId() + " 이메일 : " + user.getEmail());
		} else {
			System.out.println("사용자를 찾을 수 없습니다.");
		}
	}
}
