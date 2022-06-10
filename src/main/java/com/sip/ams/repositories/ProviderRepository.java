package com.sip.ams.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

	Provider findProviderById(Long id);

	Provider findProviderByName(String name);

	Provider findProviderByAddress(String address);

	List<Provider> findAll();

	
}
