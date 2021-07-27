/**
 * 
 */
package com.api.pqr.btg.pactual.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

/**
 * @author daniel zapata
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "PQR")
public class Pqr {

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PQR_ID")
	private Long pqrId;
	
	@Basic(optional = false)
	@Column(name = "PQR_SUBJECT")
	private String pqrSubject;
	
	@Basic(optional = false)
	@Column(name = "PQR_SERIAL_NUMBER")
	private String pqrSerialNumber;
	
	@Column(name = "PQR_CREATE_DATE")
	private Date pqrCreateDate;
	
	@Column(name = "ACTIVE")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "PQR_TYPE_ID", referencedColumnName="DOMAIN_ID")
	private PqrDomain pqrTypeId;

	
	
	public Pqr() {
		super();
	}

	public Pqr(Long pqrId, String pqrSubject, String pqrSerialNumber, Date pqrCreateDate, boolean active,
			PqrDomain pqrTypeId) {
		super();
		this.pqrId = pqrId;
		this.pqrSubject = pqrSubject;
		this.pqrSerialNumber = pqrSerialNumber;
		this.pqrCreateDate = pqrCreateDate;
		this.active = active;
		this.pqrTypeId = pqrTypeId;
	}

	public Long getPqrId() {
		return pqrId;
	}

	public void setPqrId(Long pqrId) {
		this.pqrId = pqrId;
	}

	public String getPqrSubject() {
		return pqrSubject;
	}

	public void setPqrSubject(String pqrSubject) {
		this.pqrSubject = pqrSubject;
	}

	public String getPqrSerialNumber() {
		return pqrSerialNumber;
	}

	public void setPqrSerialNumber(String pqrSerialNumber) {
		this.pqrSerialNumber = pqrSerialNumber;
	}

	public Date getPqrCreateDate() {
		return pqrCreateDate;
	}

	public void setPqrCreateDate(Date pqrCreateDate) {
		this.pqrCreateDate = pqrCreateDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public PqrDomain getPqrTypeId() {
		return pqrTypeId;
	}

	public void setPqrTypeId(PqrDomain pqrTypeId) {
		this.pqrTypeId = pqrTypeId;
	}

}
