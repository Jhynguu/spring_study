package com.example.rowmapperex;

import com.example.rowmapperex.dto.Emp;
import com.example.rowmapperex.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RowmapperEx01Application implements CommandLineRunner {

	@Autowired
	private EmpRepository empRepository;

	public static void main(String[] args) {
		SpringApplication.run(RowmapperEx01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 모든 유저 조회
		System.out.println("모든 사용자");
		empRepository.findAllusers().forEach(emp -> {
			System.out.println("이름 : " + emp.getEname() + " 직업 : " + emp.getJob() + " 사원번호 : " + emp.getEname());
		});

		// 특정 사원 조회 ( ex : empno가 7499인 사원)
		Emp emp = empRepository.findUserByDeptno(7499);
		if (emp != null) {
			System.out.println("특정 사원 : ");
			System.out.println("이름 : " + emp.getEname() + " 직업 : " + emp.getJob() + " 사원번호 : " + emp.getEname());
		} else {
			System.out.println("사원을 찾을 수 없습니다.");
		}

	}
}
