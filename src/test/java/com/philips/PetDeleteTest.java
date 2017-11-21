package com.philips;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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
public class PetDeleteTest {

	@Autowired
	PetService petService;
	
	@Before
	public void contextLoads() {
		petService.deleteAll();
		
	}
	
	
    @Test
    public void deletePet() {

    	petService.addPet(new Pet("Jack", "2010-10-10", Species.DOG));
		petService.addPet(new Pet("Jenny", "2010-10-10", Species.CAT));
		petService.deletePet("Jenny");
    	Pet catVal = petService.getPet("Jenny");
    	assertThat(catVal).isNull();
    	     
        
    }
   
    @Test
    public void deletePetCheckRemains() {

    	petService.addPet(new Pet("Jack", "2010-10-10", Species.DOG));
		petService.addPet(new Pet("Jenny", "2010-10-10", Species.CAT));
		petService.deletePet("Jack");
		List<Pet> pets = petService.getAllPets();
		assertThat(pets.get(0)).extracting("name").contains("Jenny");
		     
        
    }
    
    
    @Test
    public void deleteNonEntries() {

    	petService.addPet(new Pet("Jack", "2010-10-10", Species.DOG));
		petService.addPet(new Pet("Jenny", "2010-10-10", Species.CAT));
		petService.deletePet("Jimmy");
		List<Pet> pets = petService.getAllPets();
		assertThat(pets.size()).isEqualByComparingTo(2);
		     
        
    }
          
 }
