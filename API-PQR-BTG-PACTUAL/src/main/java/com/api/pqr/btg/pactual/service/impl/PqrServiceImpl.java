package com.api.pqr.btg.pactual.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.pqr.btg.pactual.dto.PqrDTO;
import com.api.pqr.btg.pactual.entity.Pqr;
import com.api.pqr.btg.pactual.exception.AppException;
import com.api.pqr.btg.pactual.repository.PqrDomainRepository;
import com.api.pqr.btg.pactual.repository.PqrRepository;
import com.api.pqr.btg.pactual.service.IpqrService;


@Service
public class PqrServiceImpl implements IpqrService {
	
	@Autowired 
	PqrRepository pqrRepository;
	
	@Autowired 
	PqrDomainRepository pqrDomainRepository;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public Pqr createPqr(PqrDTO pqrDTO) throws Exception {
		SimpleDateFormat serialFormat = new SimpleDateFormat("ddMMYYYYHHmmss");
		try {
			
			Pqr pqr = new Pqr();
			pqr.setPqrSubject(pqrDTO.getPqrSubject());
			pqr.setPqrTypeId(this.pqrDomainRepository.findById(pqrDTO.getPqrTypeId()).get());
			pqr.setPqrSerialNumber(serialFormat.format(new Date()));
			pqr.setPqrCreateDate(new Date());
			pqr.setActive(true);
			
	   return pqrRepository.save(pqr);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("Error: "+ e.getMessage());
		}
					
	}

	@Override
	public Page<Pqr> getPqrList(int pageNumber) throws Exception {
		Pageable pageable = PageRequest.of(pageNumber, 10);
		return this.pqrRepository.findAll(pageable);
	}

	@Override
	public Pqr getInfoPqrById(Long pqrId) throws Exception {
		return this.pqrRepository.findById(pqrId).get();
	}

}
