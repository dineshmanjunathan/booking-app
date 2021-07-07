package com.ba.app.model;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ba.app.entity.SSConfiguration;

@Service
public interface SSConfigRepository extends CrudRepository<SSConfiguration, String> {

	Optional<SSConfiguration> findById(String i);

	@Transactional
	Long deleteByCode(String Code);

	@Query(value = "select  * from ss_configuration where id like 'L%'", nativeQuery = true)
	List<SSConfiguration> getRewardLevels();

}