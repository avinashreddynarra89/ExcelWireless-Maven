package com.excelwireless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ExcelWirelessMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelWirelessMavenApplication.class, args);
	}
}
