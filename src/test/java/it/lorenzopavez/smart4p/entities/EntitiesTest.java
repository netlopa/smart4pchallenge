package it.lorenzopavez.smart4p.entities;

import org.agileware.test.PropertiesTester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.lorenzopavez.smart4p.entities.atm.Atm;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EntitiesTest {
	
	@Test
	public void testShortenedUrl() throws Exception {
		final PropertiesTester propertiesTester = new PropertiesTester();
		propertiesTester.testAll(Atm.class);
	}

}
