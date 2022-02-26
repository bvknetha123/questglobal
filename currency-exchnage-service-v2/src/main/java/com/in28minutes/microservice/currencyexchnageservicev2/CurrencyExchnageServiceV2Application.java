package com.in28minutes.microservice.currencyexchnageservicev2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CurrencyExchnageServiceV2Application  implements CommandLineRunner{

	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchnageServiceV2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
String sql = "SELECT * FROM CABEXX1";
        
        List<ExchangeValue> exchangeValue = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(ExchangeValue.class));
         
        exchangeValue.forEach(System.out :: println);		
	}

}
