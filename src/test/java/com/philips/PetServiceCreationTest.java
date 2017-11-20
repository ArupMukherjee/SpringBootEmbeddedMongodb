package com.philips;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.philips.Pet.Pet;
import com.philips.Pet.PetService;
import com.philips.Pet.Species;
import com.philips.Pet.Visit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PetServiceCreationTest {

	@Autowired
	PetService petService;

	@Before
	public void contextLoads() {
		petService.deleteAll();
		petService.addPet(new Pet("Jack", "2010-10-10", Species.DOG));
		petService.addPet(new Pet("Jenny", "2010-10-10", Species.CAT));
		petService.addVisit(petService.getPet("Jack").getName(), new Visit("Jack Vet", "2010-10-10", "Visit 1"));
		petService.addVisit(petService.getPet("Jack").getName(), new Visit("Jack Vet", "2010-10-20", "Visit 2"));
	}

	@Test
	public void findsServiceByName() {

		Visit visit = petService.getPet("Jack").getVisits().get(0);
		assertThat(visit).isNotNull();

	}

	@Test
	public void NoFindsByName() {

		ArrayList<Visit> visits = petService.getPet("Jenny").getVisits();
		assertThat(visits).isNull();

	}
	
}
