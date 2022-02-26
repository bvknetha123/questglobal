package com.in28minutes.microservice.currencyexchnageservicev2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeServiceController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange-service-v2/from/{from}/to/{to}")  //currency-exchange-service-v2/from/USD/to/INd/
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		if(exchangeValue==null) {
			throw new RuntimeException("unable to find data"+from+"to"+to);
		}
		String port= environment.getProperty("local.server.port");
		exchangeValue.setPort(port);
		return exchangeValue;
		
	}

}
