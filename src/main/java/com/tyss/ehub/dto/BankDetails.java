package com.tyss.ehub.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
@Entity
@Table(name="Bank_details")
@Data
public class BankDetails {
	@Id
	@Column
	@Pattern(regexp = "(^$|[0-9]{16})")
	private String accNo;
	
	@Column(name = "acc_holder_name")
	private String accountHolderName;
	
	@Column(name = "ifsc_code")
	private String ifscCode;
	
	@Column(name = "gst_no")
	@Size(min = 15, max = 15, message = "Gst No should be minimum 15 and maximum 15 characters")
	private String gstNo;
	
	@Column(name = "micr")
	@Pattern(regexp = "[0-9]{9}")
	private String micrCode;
	
	@OneToOne
	@JoinColumn(name = "project_id")
	private ProjectInfo projectInfo;
}
