package com.tyss.testyantra.tyssEhub.service;

import java.util.List;

import com.tyss.testyantra.tyssEhub.dto.ClientInfoDTO;


public interface ClientInfoService {
	
public ClientInfoDTO addClient(ClientInfoDTO dto);

public List<ClientInfoDTO> getALlClients();

public List<ClientInfoDTO> getByName(String companyName);
	
	

}
