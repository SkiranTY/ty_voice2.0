package com.tyss.ehub.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tax_location")
@Data
public class TaxLocation {
	@Id
	@Column(name = "tax_loc_id")
	@GeneratedValue
	private int taxLocationId;
	@Column
	private String country;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String sez;
	
	@OneToOne
	@JoinColumn(name = "project_id")
	private ProjectInfo projectInfo;
}
