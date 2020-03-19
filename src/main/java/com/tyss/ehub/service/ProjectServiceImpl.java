package com.tyss.ehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.ehub.dao.ProjectDao;
import com.tyss.ehub.dto.CourierAddress;
import com.tyss.ehub.dto.ProjectInfo;

@Service
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectDao dao;

	@Override
	public boolean craeteProject(ProjectInfo project) {
		return dao.craeteProject(project);
	}

	@Override
	public boolean createCourierAddress(CourierAddress courier) {
		return dao.createCourierAddress(courier);
	}
	
}
