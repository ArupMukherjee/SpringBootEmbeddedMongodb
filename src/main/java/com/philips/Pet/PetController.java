package com.philips.Pet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {
	
	@Autowired
	private PetService petService;
	/**
	 * Method which maps the operation to get all the pets from the repo.
	 * @return
	 */
	@RequestMapping("/pets")
	public List<Pet> getAllPets() {
		return petService.getAllPets();
	}
	
	/**
	 * Method which maps the operation of getting a specific pets details given the name of the pet.
	 * @param name
	 * @return
	 */
	@RequestMapping("/pets/{name}")
	public Pet getPet(@PathVariable String name) {
		return petService.getPet(name);
	}
	
	/**
	 * Method allowing the end user to add a Pet to the mongoDB.
	 * @param pet
	 */
	@RequestMapping(method=RequestMethod.POST, value="/pets")
	public void addPet(@RequestBody Pet pet) {
		petService.addPet(pet);
	}
	
	/**
	 * Method returning the list of visits made by a pet to a vetenerains office.
	 * @param name
	 * @return
	 */
	@RequestMapping("/pets/{name}/visit")
	public List<Visit> getPetVisit(@PathVariable String name) {
		return petService.getAllVisits(name);
	}
	
	/**
	 * Method adding a visit from the pet to the veterenians office.
	 * @param visit
	 * @param name
	 */
	@RequestMapping(method=RequestMethod.POST, value="/pets/{name}/visit")
	public void addPetVisit(@RequestBody Visit visit, @PathVariable String name) {
		petService.addVisit(name, visit);
	}
	
	/**
	 * Method allowing for the user to update the Pet details.
	 * @param pet
	 * @param name
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/pets/{name}")
	public void updatePet(@RequestBody Pet pet, @PathVariable String name) {
		petService.updatePet(name, pet);
	}
	
	/**
	 * Method allowing the user to delete a Pet from the mongoDB.
	 * @param name
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/pets/{name}")
	public void deletePet(@PathVariable String name) {
		petService.deletePet(name);
	}
}
