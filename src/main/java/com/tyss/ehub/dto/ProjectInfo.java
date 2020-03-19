package com.tyss.ehub.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tyss.testyantra.tyssEhub.dto.ClientInfoDTO;

import lombok.Data;

@Entity
@Table(name = "project_info")
@Data
public class ProjectInfo {
	@Id
	@Column(name = "project_id")
	@GeneratedValue
	private int projectId;
	
	@Column(name = "project_name")
	private String projectName;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "client_id") private ClientInfoDTO client;
	 */
	@Column(name = "client_id")
	private Integer clientId;
	
	@OneToOne(mappedBy = "projectInfo",cascade = CascadeType.ALL)
	private TaxLocation taxLocation;
	
	@OneToMany(mappedBy = "projectInfo",cascade = CascadeType.ALL)
	private List<BusinessSpocs> businessSpoces;
	
	@OneToMany(mappedBy = "projectInfo",cascade = CascadeType.ALL)
	private List<FinanceSpoces> financeSpoces;
	
	@OneToOne(mappedBy = "projectInfo",cascade = CascadeType.ALL)
	private Invoice invoice;
	
	@OneToOne(mappedBy = "projectInfo",cascade = CascadeType.ALL)
	private BankDetails bankDetails;
	
	/*@OneToOne(mappedBy = "projectInfo")
	private CourierAddress courierAddress;*/
	
}
