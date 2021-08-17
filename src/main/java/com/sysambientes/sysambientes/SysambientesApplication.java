package com.sysambientes.sysambientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.sysambientes.sysambientes.controller",
		"com.sysambientes.sysambientes.model",
		"com.sysambientes.sysambientes.repository",
		"com.sysambientes.sysambientes.services" }
)
public class SysambientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysambientesApplication.class, args);
	}

}
