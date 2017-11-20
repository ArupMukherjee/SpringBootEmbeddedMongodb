package com.philips;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.philips.Pet.Pet;
import com.philips.Pet.PetService;
import com.philips.Pet.Species;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PetUpdateTest {

	@Autowired
	PetService petService;
	
	@Before
	public void contextLoads() {
		petService.deleteAll();
		petService.addPet(new Pet("Jack", "2010-10-10", Species.DOG));
		petService.addPet(new Pet("Jenny", "2010-10-10", Species.CAT));
		
	}
	
	
    @Test
    public void updateSpecies() {

    	petService.updatePet("Jack", new Pet("Jack", "2010-10-10", Species.CAT));
    	Pet catVal = petService.getPet("Jack");
    	assertThat(catVal).extracting("species").contains(Species.CAT);
             
        
    }
 
    @Test
    public void updateBirthday() {

    	petService.updatePet("Jack", new Pet("Jenny", "2010-10-30", Species.CAT));
    	Pet catVal = petService.getPet("Jenny");
    	assertThat(catVal).extracting("birthdate").contains("2010-10-30");
             
        
    }
    
 }
