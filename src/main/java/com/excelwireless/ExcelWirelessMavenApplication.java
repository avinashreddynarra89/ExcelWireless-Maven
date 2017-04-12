package com.excelwireless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExcelWirelessMavenApplication {

	static {
		System.setProperty("GOOGLE_APPLICATION_CREDENTIALS","FirstProject-13be1ccbdbaa.json");
	}

	public static void main(String[] args) {
		SpringApplication.run(ExcelWirelessMavenApplication.class, args);
	}
}
