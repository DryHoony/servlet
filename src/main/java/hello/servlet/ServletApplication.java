package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 서블릿 자동 등록
@SpringBootApplication
public class ServletApplication {
	// <4. 스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술>

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}
	// 동작 확인
}
