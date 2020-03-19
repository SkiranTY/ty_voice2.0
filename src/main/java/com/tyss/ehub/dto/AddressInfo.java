package com.tyss.ehub.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Table(name = "address_info")
@Data
public class AddressInfo {
	
	@Id
	@Column(name = "address_id")
	@GeneratedValue
	private int addressId;
	
	@Column(name = "zip_code")
	@Pattern(regexp = "(^$|[0-9]{6})")
	private Integer zipCode;
	
	@Column
	private String state;
	
	@Column
	private String city;
	
	@Column
	private String street;
	
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "courier_address_id") private CourierAddress
	 * courierAddress;
	 */
}
