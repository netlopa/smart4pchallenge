package it.lorenzopavez.urbi;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.lorenzopavez.smart4p.entities.atm.Atm;
import it.lorenzopavez.smart4p.service.Smart4pService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Smart4pApplicationTests {

	@Autowired
	Smart4pService smart4pService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void shouldContainsZeroEntry() {
		List<Atm> atmList = smart4pService.getAtmBySearchText("Milano");
		assert atmList.size() == 0;
	}
	
	@Test
	public void shouldAllEntriesContainsAWordRegardlessOfTheCase() {
		String word = "hAArLeM";
		List<Atm> atmList = smart4pService.getAtmBySearchText(word);
		word = word.toLowerCase();
		
		for (Atm item: atmList) {
			if (!(item.getAddress().getStreet().toLowerCase().contains(word) ||
					item.getAddress().getCity().toLowerCase().contains(word) ||
					item.getAddress().getPostalcode().toLowerCase().contains(word))) {
				assert false;
			}
		}
	}
	

}
