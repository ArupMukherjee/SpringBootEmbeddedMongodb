package com.philips.Pet;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

/**
 * Entity class : Pet being the root class.
 * Pet entities created using a REST API using CRUD operations.
 * Member variables of the Pet class include the name of the pet, its birthdate and the species of the PET. 
 * @author E841137
 *
 */
public class Pet {

	@Id
	private String name;
	private String birthdate;
	private Species species;
	private ArrayList<Visit> visits;
	
	
	public Pet(String name, String birthdate, Species species) {
		
		this.name = name;
		this.birthdate = birthdate;
		this.species = species;
		
	}
	public Pet() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	public ArrayList<Visit> getVisits() {
		return visits;
	}
	
	public void setVisit(Visit visit) {
		if(visits == null)
			visits = new ArrayList<Visit>();
		visits.add(visit);
	}
	
	
	
}
