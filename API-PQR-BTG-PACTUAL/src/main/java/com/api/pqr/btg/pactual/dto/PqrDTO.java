package com.api.pqr.btg.pactual.dto;


import java.util.Date;

import lombok.*;
/**
 * @author daniel zapata
 *
 */
@Data
@AllArgsConstructor
public class PqrDTO {

	private Long pqrId;
	private String pqrSubject;
	private String pqrSerialNumber;
	private Date pqrCreateDate;
	private Long pqrTypeId;

	public PqrDTO(Long pqrId, String pqrSubject, String pqrSerialNumber, Date pqrCreateDate, Long pqrTypeId) {
		super();
		this.pqrId = pqrId;
		this.pqrSubject = pqrSubject;
		this.pqrSerialNumber = pqrSerialNumber;
		this.pqrCreateDate = pqrCreateDate;
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

	public Long getPqrTypeId() {
		return pqrTypeId;
	}

	public void setPqrTypeId(Long pqrTypeId) {
		this.pqrTypeId = pqrTypeId;
	}

}
