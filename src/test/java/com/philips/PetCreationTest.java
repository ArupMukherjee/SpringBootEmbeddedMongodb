package com.philips;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.philips.Pet.Pet;
import com.philips.Pet.PetService;
import com.philips.Pet.Species;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PetCreationTest {

	@Autowired
	PetService petService;
	
	@Before
	public void contextLoads() {
		petService.deleteAll();
		petService.addPet(new Pet("Jack", "2010-10-10", Species.DOG));
		petService.addPet(new Pet("Jenny", "2010-10-10", Species.CAT));
		
	}
	
	
    @Test
    public void findsByName() {

        Pet dogVal = petService.getPet("Jack");
        assertThat(dogVal).isNotNull();     
        
    }
    
    @Test
    public void NoFindsByName() {

    	Pet dogVal = petService.getPet("Jill");
        assertThat(dogVal).isNull();
    	        
    }
    
 }
