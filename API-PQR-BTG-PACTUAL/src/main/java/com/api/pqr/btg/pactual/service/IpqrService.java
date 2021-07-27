package com.api.pqr.btg.pactual.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.api.pqr.btg.pactual.dto.PqrDTO;
import com.api.pqr.btg.pactual.entity.Pqr;
/**
 * @author daniel zapata
 *
 */
@Service
public interface IpqrService {
	
	
	Pqr createPqr(PqrDTO pqrDTO) throws Exception;
	
	Page<Pqr> getPqrList (int pageNumber) throws Exception;
	
	Pqr getInfoPqrById(Long pqrId) throws Exception;

}
