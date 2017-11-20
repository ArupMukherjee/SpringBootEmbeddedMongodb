package com.philips.Pet;

/**
 * Entity class defining the visits made by the pet to the vet.
 * Includes the vetname, the date of the trip and the reason for the trip.
 * @author E841137
 *
 */
public class Visit {

	private String vetName;
	private String dateOfVisit;
	private String reason;
	
	public Visit() {
		
	}
	
	public Visit(String vetName, String dateOfVisit, String reason) {
		this.vetName = vetName;
		this.dateOfVisit = dateOfVisit;
		this.reason = reason;
	}
	
	public String getVetName() {
		return vetName;
	}
	public void setVetName(String vetName) {
		this.vetName = vetName;
	}
	
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
