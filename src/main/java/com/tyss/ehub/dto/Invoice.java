package com.tyss.ehub.dto;

import java.util.Date;

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
@Table(name = "invoice")
@Data
public class Invoice {
	@Id
	@Column(name = "invoice_id")
	@GeneratedValue
	private int invoiceId;
	
	@Column(name = "collection_owner")
	private String collectionOwner;
	
	@Column(name = "leave_allowed")
	private int leaveAlowed;
	
	@Column(name ="add_days")
	private int addDays;
	
	@Column(name = "invoice_date")
	private Date invoiceDate;
	
	@Column(name = "type_of_task")
	private String typeOfTask;
	
	@Column(name = "hsn_code")
	@Pattern(regexp = "(^$|[0-9]{4})")
	private String hsnCode;
	
	@Column(name = "invoice_billing_type")
	private String invoiceBillingType;
	
	@Column(name = "payment_terms")
	private String paymentTerms;
	
	@OneToOne
	@JoinColumn(name = "project_id")
	private ProjectInfo projectInfo;
}
