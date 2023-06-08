package pet.park.entity;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
//shortcut for import is ctrl + space + enter

@Embeddable
@Data
@NoArgsConstructor
public class GeoLocation {
	private BigDecimal latitude;
	private BigDecimal longitude;
	
	public GeoLocation(GeoLocation geoLocation) {
		this.latitude = geoLocation.latitude;
		this.longitude = geoLocation.longitude;
	}
	
}
