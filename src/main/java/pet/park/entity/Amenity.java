package pet.park.entity;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Amenity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long amenityId;
	
	private String amenity;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	//Where relationship is mapped.
	@ManyToMany(mappedBy = "amenities")
//	@JoinTable(name = "pet_park_amenity", 
//	joinColumns = @JoinColumn(name = "amenity_id"), 
//	inverseJoinColumns = @JoinColumn(name = "pet_park_id"))
	//This is how JPA manages relationships it needs sets in both sides/tables 
	private Set<PetPark> petParks = new HashSet<>();
}
