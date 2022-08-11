package com.BrandonHellwarth.DojosAndNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BrandonHellwarth.DojosAndNinjas.models.Ninja;
import com.BrandonHellwarth.DojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
}
