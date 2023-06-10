package pet.park.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import jakarta.transaction.Transactional;
import pet.park.controller.model.ContributorData;
import pet.park.dao.ContributorDao;
import pet.park.entity.Contributor;

@Service
public class ParkService {
	@Autowired
	private ContributorDao contributorDao;
	

	@Transactional(readOnly = false)
	public ContributorData saveContributor(ContributorData contributorData) {
		Long contributorId = contributorData.getContributorId();
		Contributor contributor = findOrCreateContributor(contributorId);
		
		setFieldsInContributor(contributor, contributorData);
		return new ContributorData(contributorDao.save(contributor));
		
	}
	private void setFieldsInContributor(Contributor contributor, ContributorData contributorData) {
		contributor.setContributorEmail(contributorData.getContributorEmail());
		contributor.setContributorName(contributorData.getContributorName());
		
	}
	private Contributor findOrCreateContributor(Long contributorId) {
	Contributor contributor;
	
	if(Objects.isNull(contributorId)) {
		contributor = new Contributor();
	}else {
		contributor = findContributorById(contributorId);
	}
	
	return contributor;
	
}

	private Contributor findContributorById(Long contributorId) {
		
		return contributorDao.findById(contributorId)
				.orElseThrow(() -> new NoSuchElementException(
				"Contributor with ID= " + contributorId + " was not found."));
	}

}
