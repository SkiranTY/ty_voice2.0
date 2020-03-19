package com.tyss.testyantra.tyssEhub.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tyss.testyantra.tyssEhub.dto.ClientInfoDTO;

public interface ClientInfoRepo extends JpaRepository<ClientInfoDTO, Integer> {
	
	@Query("from ClientInfoDTO where cfullname=:cfullname ")
	public List<ClientInfoDTO> findByName(@Param("cfullname") String cfullname);

}
