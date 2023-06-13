package pet.park.entity;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
//shortcut for import is ctrl + space + enter


@Embeddable
//Creates getters and setters, hashcode and equals methods. 
@Data
//Creates constructor 
@NoArgsConstructor
public class GeoLocation {
	//Like long with a set number of decimal points)
	private BigDecimal latitude;
	private BigDecimal longitude;
	
	//This is a copy constructor, used when taking objects
	public GeoLocation(GeoLocation geoLocation) {
		this.latitude = geoLocation.latitude;
		this.longitude = geoLocation.longitude;
	}
	
}
