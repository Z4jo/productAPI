package com.api.product;

import com.api.product.entity.DayInfo;
import com.api.product.entity.FoodInfo;
import com.api.product.repositary.DayInfoRepository;
import com.api.product.repositary.FoodInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class ProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
}



}
