package com.tyss.ehub.dto;

import java.io.File;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "courier_address_info")
@Data
public class CourierAddress {
	@Id
	@Column(name = "courier_address")
	@GeneratedValue
	private int courierAddressId;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name = "attendence_collection_date")
	private Date attendenceCollectionDate;
	
	@Column(name = "invoice_approval_authority")
	private String invoiceApprovalAuthority;
	
	@Column(name = "comment")
	private String comment;
	
	@Column
	private File poDoc;
	@Column
	private File sowDoc;
	@Column
	private File woDoc;
	@Column
	private File otherDoc;
	
	/*@OneToOne
	@JoinColumn(name = "project_info")
	private ProjectInfo projectInfo;*/
	
	/*
	 * @OneToOne(mappedBy = "courierAddress") private AddressInfo address;
	 */
}
