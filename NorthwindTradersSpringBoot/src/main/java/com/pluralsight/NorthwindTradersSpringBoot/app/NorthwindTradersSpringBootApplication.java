package com.pluralsight.NorthwindTradersSpringBoot.app;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import com.pluralsight.NorthwindTradersSpringBoot.view.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = "com.pluralsight.NorthwindTradersSpringBoot")
public class NorthwindTradersSpringBootApplication implements CommandLineRunner {

	@Autowired
	private UserInterface ui;

	public static void main(String[] args) {
		SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	ui.display();
	}
}


