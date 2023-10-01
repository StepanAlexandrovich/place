package com.market.place;

import com.market.place.models.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class PlaceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlaceApplication.class, args);
	}

}
