package com.vir.demo.drug;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Sreeni
 * The main class and the entry point of the application
 *
 */
@SpringBootApplication
public class DrugPriceGrabberMain {
	 private static final Logger logger = LogManager.getLogger(DrugPriceGrabberMain.class);
	public static void main(String[] args) {
		logger.debug("inside the main class");
		SpringApplication.run(DrugPriceGrabberMain.class, args);
	}

}
