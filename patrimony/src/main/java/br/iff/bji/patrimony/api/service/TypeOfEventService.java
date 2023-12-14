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
			if(!typeOfEventRepository.existsByDescription(typeOfEvent.getDescription())) {
				typeOfEvent.setId(null == typeOfEventRepository.findMaxId() ? 1 : typeOfEventRepository.findMaxId() + 1);
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
	
//	@Transactional
//	public String updateTypeOfEvent(TypeOfEvent typeOfEvent) {
//		//if(typeOfEventRepository.existsByDescription(typeOfEvent.getDescription())){
//			try {
//				//List<TypeOfEvent> typesOfEvents = typeOfEventRepository.findByDescription(typeOfEvent.getDescription());
//				//typesOfEvents.stream().forEach(e -> {
//					//não teria que ter outra verificação aqui não? uma verificação pra saber se o id que você quer
//					//é igual ao que você está comparando
//					//TypeOfEvent typeOfEventToBeUpdate = typeOfEventRepository.findById(e.getId()).get();
//					//typeOfEventToBeUpdate.setDescription(typeOfEvent.getDescription());
//					//typeOfEventRepository.save(typeOfEventToBeUpdate);
//				//});
//				typeOfEventRepository.
//				return "Type of event updated.";
//			} catch (Exception e) {
//				throw e;
//			}
////		} else {
////			return "Type of event does not exists in the database.";
////		}
//	}
	
    @Transactional
    public String updateTypeOfEvent(TypeOfEvent updatedTypeOfEvent) {
        try {
            TypeOfEvent existingTypeOfEvent = typeOfEventRepository.findById(updatedTypeOfEvent.getId()).orElse(null);

            if(existingTypeOfEvent == null) {
            	return "TypeOfEvent not found with id: " + updatedTypeOfEvent.getId();
            }
            
            String updatedDescription = updatedTypeOfEvent.getDescription();
            if (!existingTypeOfEvent.getDescription().equals(updatedDescription)
                    && typeOfEventRepository.existsByDescription(updatedDescription)) {
                return "Cannot update TypeOfEvent. Another TypeOfEvent with the same description already exists.";
            }

            existingTypeOfEvent.setDescription(updatedDescription);
            typeOfEventRepository.save(existingTypeOfEvent);

            return "TypeOfEvent updated successfully.";
        } catch (Exception e) {
            throw e;
        }
    }

	
	@Transactional
	public String deleteTypeOfEvent(TypeOfEvent typeOfEvent) {
		try {
			typeOfEventRepository.deleteById(typeOfEvent.getId());
			return "Type of Event record deleted successfully.";
		} catch (Exception e){
			throw e;
		}
	}
}
