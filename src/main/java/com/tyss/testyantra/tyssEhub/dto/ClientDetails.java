package com.tyss.testyantra.tyssEhub.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.executable.ValidateOnExecution;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "clientDetails")
@Data
@ValidateOnExecution
public class ClientDetails {
	@Id
	// @Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientDetailsID;

	// @Column
	private String clientName;

	// @Column
	@Email
	private String email;

	// @Column
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNumber;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "client_Id", referencedColumnName = "client_Id")
	private ClientInfoDTO clientInfoDTO;

}
