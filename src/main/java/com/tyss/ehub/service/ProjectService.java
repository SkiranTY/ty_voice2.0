package com.tyss.ehub.service;

import com.tyss.ehub.dto.CourierAddress;
import com.tyss.ehub.dto.ProjectInfo;

public interface ProjectService {
	public boolean craeteProject(ProjectInfo project);
	public boolean createCourierAddress(CourierAddress courier);
}
