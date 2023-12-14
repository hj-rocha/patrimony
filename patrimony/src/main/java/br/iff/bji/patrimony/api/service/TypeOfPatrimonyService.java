package br.iff.bji.patrimony.api.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.iff.bji.patrimony.api.entity.TypeOfPatrimony;
import br.iff.bji.patrimony.api.repository.TypeOfPatrimonyRepository;

@Service
public class TypeOfPatrimonyService {

	@Autowired
	private TypeOfPatrimonyRepository typeOfPatrimonyRepository;

	@Transactional
	public String createTypeOfPatrimony(TypeOfPatrimony typeOfPatrimony) {
		try {
			if (!typeOfPatrimonyRepository.existsByDescription(typeOfPatrimony.getDescription())) {
				typeOfPatrimony.setId(null == typeOfPatrimonyRepository.findMaxId() ? 1 : typeOfPatrimonyRepository.findMaxId() + 1);
				typeOfPatrimonyRepository.save(typeOfPatrimony);
				return "TypeOfPatrimony record created successfully.";
			} else {
				return "TypeOfPatrimony already exists in the database.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public List<TypeOfPatrimony> readTypeOfPatrimonys() {
		return typeOfPatrimonyRepository.findAll();
	}

	@Transactional
	public String updateTypeOfPatrimony(TypeOfPatrimony typeOfPatrimony) {
		if (typeOfPatrimonyRepository.existsByDescription(typeOfPatrimony.getDescription())) {
			try {
				List<TypeOfPatrimony> typeOfPatrimonys = typeOfPatrimonyRepository.findByDescription(typeOfPatrimony.getDescription());
				typeOfPatrimonys.stream().forEach(s -> {
					TypeOfPatrimony typeOfPatrimonyToBeUpdate = typeOfPatrimonyRepository.findById(s.getId()).get();
					typeOfPatrimonyToBeUpdate.setDescription(typeOfPatrimony.getDescription());
					typeOfPatrimonyRepository.save(typeOfPatrimonyToBeUpdate);
				});
				return "TypeOfPatrimony record updated.";
			} catch (Exception e) {
				throw e;
			}
		} else {
			return "TypeOfPatrimony does not exists in the database.";
		}
	}

	@Transactional
	public String deleteTypeOfPatrimony(TypeOfPatrimony typeOfPatrimony) {
		if (typeOfPatrimonyRepository.existsByDescription(typeOfPatrimony.getDescription())) {
			try {
				List<TypeOfPatrimony> typeOfPatrimonys = typeOfPatrimonyRepository.findByDescription(typeOfPatrimony.getDescription());
				typeOfPatrimonys.stream().forEach(s -> {
					typeOfPatrimonyRepository.delete(s);
				});
				return "TypeOfPatrimony record deleted successfully.";
			} catch (Exception e) {
				throw e;
			}

		} else {
			return "TypeOfPatrimony does not exist";
		}
	}
}
