package com.tyss.ehub.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.ehub.dto.CourierAddress;
import com.tyss.ehub.dto.ProjectInfo;
import com.tyss.ehub.dto.ProjectResponse;
import com.tyss.ehub.service.ProjectService;

@RestController
@RequestMapping("project")
@ValidateOnExecution
public class ProjectController {
	@Autowired
	private ProjectService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProjectResponse createProject(@Valid @RequestBody ProjectInfo project) {
		ProjectResponse response = new ProjectResponse();
		if (service.craeteProject(project)) {
			response.setError(false);
			response.setMessage("Project Created Successfully.");
		} else {
			response.setError(true);
			response.setMessage("Something went wrong while project creation.");
		}
		return response;
	}

	@PostMapping(path = "createCurier", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProjectResponse createCourierAddress(@RequestParam("fullName") String fullName,
			@RequestParam("companyName") String companyName,
			@RequestParam("attendenceCollectionDate") Date attendenceCollectionDate,
			@RequestParam("invoiceApprovalAuthority") String invoiceApprovalAuthority,
			@RequestParam("comment") String comment, @RequestParam("poDoc") MultipartFile poDoc,
			@RequestParam("sowDoc") MultipartFile sowDoc, @RequestParam("woDoc") MultipartFile woDoc,
			@RequestParam("otherDoc") MultipartFile otherDoc) throws IOException {
		
		CourierAddress courierAddress=new CourierAddress();

		ProjectResponse response = new ProjectResponse();

		File poDocFile = new File(poDoc.getOriginalFilename());
		File sowDocFile = new File(sowDoc.getOriginalFilename());
		File woDocFile = new File(woDoc.getOriginalFilename());
		File otherDocFile = new File(otherDoc.getOriginalFilename());

		FileOutputStream poDocOut = new FileOutputStream(poDocFile);
		FileOutputStream sowDocFileOut = new FileOutputStream(sowDocFile);
		FileOutputStream woDocFileOut = new FileOutputStream(woDocFile);
		FileOutputStream otherDocFileOut = new FileOutputStream(otherDocFile);

		poDocOut.write(poDoc.getBytes());
		sowDocFileOut.write(sowDoc.getBytes());
		woDocFileOut.write(woDoc.getBytes());
		otherDocFileOut.write(otherDoc.getBytes());

		poDocOut.close();
		sowDocFileOut.close();
		woDocFileOut.close();
		otherDocFileOut.close();

		courierAddress.setFullName(fullName);
		courierAddress.setCompanyName(companyName);
		courierAddress.setAttendenceCollectionDate(attendenceCollectionDate);
		courierAddress.setInvoiceApprovalAuthority(invoiceApprovalAuthority);
		courierAddress.setComment(comment);
		courierAddress.setPoDoc(poDocFile);
		courierAddress.setSowDoc(sowDocFile);
		courierAddress.setWoDoc(woDocFile);
		courierAddress.setOtherDoc(otherDocFile);
		if(service.createCourierAddress(courierAddress)) {
			response.setError(false);
			response.setMessage("Courier Address added successfully.");
		}else {
			response.setError(true);
			response.setMessage("Courier Address Not Added");
		}
		return response;
	}

}
