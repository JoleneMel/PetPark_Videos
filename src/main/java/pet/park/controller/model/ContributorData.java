package pet.park.controller.model;

import java.util.HashSet;
import java.util.Set;



import lombok.Data;
import lombok.Value;
import pet.park.entity.Amenity;
import pet.park.entity.GeoLocation;
import pet.park.entity.PetPark;

@Data
public class ContributorData {

	private Long contributorId;
	private String contributorName;
	private String contributorEmail;
	

	
	private Set<PetPark> petParks = new HashSet<>();
	
	@Value
	static class PetParkResponse {
		private Long petParkId;
		private String parkName;
		private String directions;
		private String country;
		
		private GeoLocation geoLocation;
		

		private Set<Amenity> amenities = new HashSet<>();

	}
}
