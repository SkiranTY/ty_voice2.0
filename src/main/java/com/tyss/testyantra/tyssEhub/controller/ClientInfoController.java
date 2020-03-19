package com.tyss.testyantra.tyssEhub.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.testyantra.tyssEhub.dto.ClientInfoDTO;
import com.tyss.testyantra.tyssEhub.dto.JsonResponse;
import com.tyss.testyantra.tyssEhub.service.ClientInfoService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@ValidateOnExecution
@RequestMapping("/client")
public class ClientInfoController {
	@Autowired
	private ClientInfoService service;

	@PostMapping(path = "/addClientinfo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse addClient(@Valid @RequestBody ClientInfoDTO dto) {

		JsonResponse response = new JsonResponse();
		ClientInfoDTO info = service.addClient(dto);
		if (info != null) {
			

			response.setError(false);
			response.setClientInfoDTO(info);

		} else {

			response.setError(true);
			response.setMessage("data  is not added");

		}
		return response;

	}

	@GetMapping(path = "/getAllClients", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse getAllClients() {

		List<ClientInfoDTO> list = service.getALlClients();
		JsonResponse response = new JsonResponse();
		if (list != null) {
			response.setError(false);
			response.setData(list);
		} else {
			response.setError(true);
			response.setMessage("data not found");
		}
		return response;
	}

	@GetMapping(path = "/getByName/{companyName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse getByName(@PathVariable("companyName") String companyName) {
		List<ClientInfoDTO> list = service.getByName(companyName);
		JsonResponse response = new JsonResponse();
		if (list != null) {
			response.setError(false);
			response.setData(list);
		} else {
			response.setError(true);
			response.setMessage("data not found");
		}
		return response;
	}
}
