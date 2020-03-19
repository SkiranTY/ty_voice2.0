package com.tyss.ehub.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.tyss.ehub.dto.BankDetails;
import com.tyss.ehub.dto.BusinessSpocs;
import com.tyss.ehub.dto.CourierAddress;
import com.tyss.ehub.dto.FinanceSpoces;
import com.tyss.ehub.dto.Invoice;
import com.tyss.ehub.dto.ProjectInfo;
import com.tyss.ehub.dto.TaxLocation;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean craeteProject(ProjectInfo project) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean projectFlag = false;
		try {
			if (project != null) {
				
                TaxLocation taxLocation=project.getTaxLocation();
                
                if(taxLocation!=null) {
                	taxLocation.setProjectInfo(project);
                }
				
				
				List<BusinessSpocs> businessSpoces=project.getBusinessSpoces();
				if(businessSpoces!=null) {
					for(BusinessSpocs business:businessSpoces) {
						business.setProjectInfo(project);
					}
				}
				
				List<FinanceSpoces> financeSpoces=project.getFinanceSpoces();
				if(financeSpoces!=null) {
					for(FinanceSpoces finance:financeSpoces) {
						finance.setProjectInfo(project);
					}
				}
				
				Invoice invoice=project.getInvoice();
				if(invoice!=null) {
					invoice.setProjectInfo(project);
				}
				
				BankDetails bankDetails=project.getBankDetails();
				if(bankDetails!=null) {
					bankDetails.setProjectInfo(project);
				}
				
				transaction.begin();
				entityManager.persist(project);
				transaction.commit();
				projectFlag = true;
			}
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return projectFlag;
	}

	@Override
	public boolean createCourierAddress(CourierAddress courier) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean projectFlag = false;
		try {
			transaction.begin();
			entityManager.persist(courier);
			transaction.commit();
			projectFlag=true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return projectFlag;
	}
}
