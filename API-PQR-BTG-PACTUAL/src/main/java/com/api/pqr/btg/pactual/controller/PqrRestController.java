package com.api.pqr.btg.pactual.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pqr.btg.pactual.dto.PqrDTO;
import com.api.pqr.btg.pactual.entity.Pqr;
import com.api.pqr.btg.pactual.exception.AppException;
import com.api.pqr.btg.pactual.service.IpqrService;

/**
 * @author daniel zapata
 *
 */

@RestController
@RequestMapping(value = "/api/btg/pqr")
@CrossOrigin("*")
public class PqrRestController {

	@Autowired
	IpqrService pqrService;

	@PostMapping("/create-pqr")
	public ResponseEntity<Pqr> createPqr(@RequestBody PqrDTO pqrDto) {
		Pqr pqr = new Pqr();
		try {
			pqr = this.pqrService.createPqr(pqrDto);
			if (pqr == null) {
				throw new AppException("ERROR AL GUARDAR PQR");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Pqr>(pqr, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Pqr>(pqr, HttpStatus.OK);
	}

	@GetMapping("/get-list-pqr/{pagenummber}")
	public ResponseEntity<List<Pqr>> getPqrList(@PathVariable("pageNumber") int pageNumber) {
		List<Pqr> listPqr = new ArrayList<Pqr>();
		try {
			Page<Pqr> page = this.pqrService.getPqrList(pageNumber);
			if (!page.getContent().isEmpty()) {
				listPqr = page.getContent();
			}
			return new ResponseEntity<List<Pqr>>(listPqr, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Pqr>>(listPqr, HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Pqr> getInfoPqrById(Long pqrId) {
		Pqr pqr = new Pqr();
		try {
			pqr = this.pqrService.getInfoPqrById(pqrId);
			if (pqr == null) {
				throw new AppException("No se pudo consultar la pqr");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Pqr>(pqr, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Pqr>(pqr, HttpStatus.OK);
	}

}
