package com.philips.Pet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRepository extends MongoRepository<Pet, String> {
	
	List<Visit> findByVisits(ArrayList name);
}
