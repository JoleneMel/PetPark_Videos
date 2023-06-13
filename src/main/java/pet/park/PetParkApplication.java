package pet.park;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Very important for all SpringBoot apps 
//This enables component scan and auto-configuration
//Component scan loads everything, manages beans etc.
//Conponent scan also is great within our controller class, it will map our HTTP requests to methods that we write
//We use annotations to communicate to Spring which HTTP verb, which can be mapped via java methods
//Auto Configuration 
@SpringBootApplication
public class PetParkApplication {

	public static void main(String[] args) {
		//This is the run class where we pass on our class within it
		SpringApplication.run(PetParkApplication.class, args);
	}

}
