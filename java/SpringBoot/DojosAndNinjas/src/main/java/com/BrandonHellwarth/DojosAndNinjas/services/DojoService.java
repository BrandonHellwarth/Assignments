package com.BrandonHellwarth.DojosAndNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BrandonHellwarth.DojosAndNinjas.models.Dojo;
import com.BrandonHellwarth.DojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	
	public Dojo findDojo(Long id) {
		return dojoRepository.findById(id).orElse(null);
	}
}
