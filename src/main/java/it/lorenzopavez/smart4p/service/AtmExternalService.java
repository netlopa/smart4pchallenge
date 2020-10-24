package it.lorenzopavez.smart4p.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import it.lorenzopavez.smart4p.entities.atm.Atm;

@Service
public class AtmExternalService {
	
	private static final Logger logger = LogManager.getLogger(AtmExternalService.class);

	@Async
	public CompletableFuture<List<Atm>> getAllAtms() {
		Gson gson = new Gson();
		
		try {
            File file = ResourceUtils.getFile("classpath:atm.json");
            InputStream in = new FileInputStream(file);
            
            String text = new BufferedReader(
            	      new InputStreamReader(in, StandardCharsets.UTF_8))
            	        .lines()
            	        .collect(Collectors.joining("\n"));

            List<Atm> ret = gson.fromJson(text, new TypeToken<List<Atm>>(){}.getType());
            return CompletableFuture.completedFuture(ret);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
		
		return null;
	}
	
}
