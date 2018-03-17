package com.winterchen;

import com.winterchen.listener.PropertiesListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.winterchen.dao")
public class SpringbootShiroApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringbootShiroApplication.class);
		// 注册监听器
		application.addListeners(new PropertiesListener("i18n/api_zh_CN.properties"));
		application.run(args);
	}
}
