package pet.park.dao;


import pet.park.entity.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContributorDao extends JpaRepository<Contributor, Long> {
    Optional <Contributor> findByContributorEmail(String contributorEmail);
}