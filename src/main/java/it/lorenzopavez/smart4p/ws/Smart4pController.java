package it.lorenzopavez.smart4p.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.lorenzopavez.smart4p.entities.atm.Atm;
import it.lorenzopavez.smart4p.service.Smart4pService;


@RestController
public class Smart4pController {

    @Autowired
    ApplicationContext applicationContext;
    
    @Autowired
    Smart4pService smart4pService;
        
    @GetMapping(value = "/api/atm", produces = { MediaType.APPLICATION_JSON_VALUE })
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<Atm> getVehicles(@RequestParam(value = "search",required = true) String search) {
    	
    	List<Atm> ret = smart4pService.getAtmBySearchText(search);
    	return ret;
    }
    
}
