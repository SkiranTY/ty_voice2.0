package com.tyss.ehub.dao;

import com.tyss.ehub.dto.CourierAddress;
import com.tyss.ehub.dto.ProjectInfo;

public interface ProjectDao {
	public boolean craeteProject(ProjectInfo project);
	public boolean createCourierAddress(CourierAddress courier);

}
