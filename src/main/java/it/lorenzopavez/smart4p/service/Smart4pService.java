package it.lorenzopavez.smart4p.service;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.lorenzopavez.smart4p.entities.atm.Atm;

@Component
public class Smart4pService {
	
	private static final Logger logger = LogManager.getLogger(Smart4pService.class);
		
	@Autowired
	AtmExternalService atmService;
	
	public List<Atm> getAtmBySearchText(String search) {
		CompletableFuture<List<Atm>> atmExternalServiceResults = atmService.getAllAtms();
		List<Atm> externalServiceResp=null;
		try {
			externalServiceResp = atmExternalServiceResults.get(2, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			logger.error(e);
		}
		
		// Here we need to fetch any match for the search string provided
		List<Atm> ret = externalServiceResp.stream().filter(item -> {
			return (
					item.getAddress() != null && (containsIgnoreCase(item.getAddress().getCity(), search)
							|| containsIgnoreCase(item.getAddress().getPostalcode(), search)
							|| containsIgnoreCase(item.getAddress().getStreet(), search)
					)
					);
		}).collect(Collectors.toList());
		
		ret.sort((item1,item2) -> {
			String s1 = item1.getAddress().getCity() + " " + item1.getAddress().getStreet() + " " + item1.getAddress().getHousenumber();
			String s2 = item2.getAddress().getCity() + " " + item2.getAddress().getStreet() + " " + item2.getAddress().getHousenumber();
			return s1.compareTo(s2);
		});
		
		return ret;
	}
	

	

}
