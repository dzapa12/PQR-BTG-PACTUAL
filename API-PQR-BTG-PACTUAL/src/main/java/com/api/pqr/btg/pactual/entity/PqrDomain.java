package com.api.pqr.btg.pactual.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@Table(name = "PQR_DOMAIN")
public class PqrDomain {
	
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DOMAIN_ID")
	private Long domainId;
	
	@Basic(optional = false)
	@Column(name="DOMAIN_NAME")
	private String domainName;
	
	@Basic(optional = false)
	@Column(name="DOMAIN_DESCRIPTION")
	private String domainDescription;

}
