package br.iff.bji.patrimony.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.iff.bji.patrimony.api.entity.TypeOfEvent;
import br.iff.bji.patrimony.api.repository.TypeOfEventRepository;

@Service
public class TypeOfEventService {
	
	@Autowired
	private TypeOfEventRepository typeOfEventRepository;
	
	@Transactional
	public String createTypeOfEvent(TypeOfEvent typeOfEvent ) {
		
		try {
			if(!typeOfEventRepository.existByDescription(typeOfEvent.getDescription())) {
				typeOfEvent.setId(null == typeOfEventRepository.findMaxId() ? 0 : typeOfEventRepository.findMaxId() + 1);
				typeOfEventRepository.save(typeOfEvent);
				return "typeOfEvent created successfully";
			}else {
				return "TypeOfEvent already exist in database.";
			}
		} catch (Exception e) {
			throw e;
		}		
	}
	
	public List<TypeOfEvent> readTypesOfEvents(){
		return typeOfEventRepository.findAll();
	}
	
	@Transactional
	public String updateTypeOfEvent(TypeOfEvent typeOfEvent) {
		if(typeOfEventRepository.existByDescription(typeOfEvent.getDescription())){
			try {
				List<TypeOfEvent> typesOfEvents = typeOfEventRepository.findByDescription(typeOfEvent.getDescription());
				typesOfEvents.stream().forEach(e -> {
					//não teria que ter outra verificação aqui não? uma verificação pra saber se o id que você quer
					//é igual ao que você está comparando
					TypeOfEvent typeOfEventToBeUpdate = typeOfEventRepository.findById(e.getId()).get();
					typeOfEventToBeUpdate.setDescription(typeOfEvent.getDescription());
					typeOfEventRepository.save(typeOfEventToBeUpdate);
				});
				return "Type of event updated.";
			} catch (Exception e) {
				throw e;
			}
		} else {
			return "Type of event does not exists in the database";
		}
	}
	
	@Transactional public String deleteTypeOfEvent(TypeOfEvent typeOfEvent) {
		if(typeOfEventRepository.existByDescription(typeOfEvent.getDescription())) {
			try {
				List<TypeOfEvent> typesOfEvents = typeOfEventRepository.findByDescription(typeOfEvent.getDescription());
				typesOfEvents.stream().forEach(s -> {
					//não teria que ter outra verificação aqui não? uma verificação pra saber se o id que você quer
					//é igual ao que você está comparando
					typeOfEventRepository.delete(s);
				});
				return "Type of Event record deleted successfully!";
			} catch (Exception e){
				throw e;
			}
		} else {
			return "Type of event does not exists";
		}
	}
}
