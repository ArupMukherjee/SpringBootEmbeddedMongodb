package com.philips.Pet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	public List<Pet> getAllPets() {
		//return topics;
		List<Pet> pets = new ArrayList<>();
		for(Pet petVal : petRepository.findAll())
			pets.add(petVal);
		
		return pets;
	}
	
	public List<Visit> getAllVisits(String name) {
		return getPet(name).getVisits();
		
	}
	
	public Pet getPet(String name) {
		
		return petRepository.findOne(name);
	}
	
	public void addPet(Pet pet) {
		
		petRepository.save(pet);
	}
	
	
	public void addVisit(String name, Visit visit) {
		Pet pet = getPet(name);
		if(pet != null) {
			pet.setVisit(visit);
			petRepository.save(pet);
		}
		
		
	}
	
	public void updatePet(String name, Pet pet) {
		petRepository.save(pet);
	}
	
	public void deletePet(String name) {
		petRepository.delete(name);
	}
	
	public void deleteAll() {
		
		petRepository.deleteAll();
	}
}
