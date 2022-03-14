package org.aasensio.pap2022.service;

import java.util.List;

import org.aasensio.pap2022.entities.Pais;
import org.aasensio.pap2022.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;
	
	
	public List<Pais> findAll() {
		
		return paisRepository.findAll();
	}

}
