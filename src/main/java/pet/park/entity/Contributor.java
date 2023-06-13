package pet.park.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;
import java.util.HashSet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Contributor {
	//Below is our feilds
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contributorId;
	
	private String contributorName;
	
	//Adding a unique key, with this annotation below
	@Column(unique = true)
	private String contributorEmail;
	
	//To prevent recursive memory issue
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	//explaining the mapping, cascade will help associate all child rows with one another. 
	@OneToMany(mappedBy = "contributor", cascade = CascadeType.ALL)
	//The way that jpa manages petparks the one to many, so it needs a set here 
	private Set<PetPark> petParks = new HashSet<>();
}
