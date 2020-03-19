package com.tyss.ehub.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.Data;
@Entity
@Table(name = "business_spoces")
@Data
public class BusinessSpocs {
	@Id
	@Column(name = "busi_spoces_id")
	@GeneratedValue
	private int bisId;
	
	@Column
	private String name;
	
	@Column
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phone;
	
	@Column
	@Email
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
    private ProjectInfo projectInfo;
}
