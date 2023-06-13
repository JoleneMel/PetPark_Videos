package pet.park.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Set;
import java.util.HashSet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class PetPark {
	//Fields 
	//@Id tells JPA where the id/primary key is 
	@Id
	//Tells JPA how that primary key is managed
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long petParkId;
	
	private String parkName;
	
	private String directions;
	
	private String stateOrProvince;
	
	private String country;
	
	@Embedded
	private GeoLocation geoLocation;
	
	//Relationship for many to one, 
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contributor_id", nullable = false)
	private Contributor contributor;
	
	//This is a many to many, needing a set
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "pet_park_amenity", 
	joinColumns = @JoinColumn(name = "pet_park_id"), 
	inverseJoinColumns = @JoinColumn(name = "amenity_id"))
	private Set<Amenity> amenities = new HashSet<>();

}
