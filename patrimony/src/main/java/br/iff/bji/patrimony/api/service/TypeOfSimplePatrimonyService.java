package br.iff.bji.patrimony.api.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.iff.bji.patrimony.api.entity.TypeOfSimplePatrimony;
import br.iff.bji.patrimony.api.repository.TypeOfSimplePatrimonyRepository;

@Service
public class TypeOfSimplePatrimonyService {

	@Autowired
	private TypeOfSimplePatrimonyRepository typeOfSimplePatrimonyRepository;

	@Transactional
	public String createTypeOfSimplePatrimony(TypeOfSimplePatrimony typeOfSimplePatrimony) {
		try {
			if (!typeOfSimplePatrimonyRepository.existsByDescription(typeOfSimplePatrimony.getDescription())) {
				typeOfSimplePatrimony.setId(null == typeOfSimplePatrimonyRepository.findMaxId() ? 0 : typeOfSimplePatrimonyRepository.findMaxId() + 1);
				typeOfSimplePatrimonyRepository.save(typeOfSimplePatrimony);
				return "TypeOfSimplePatrimony record created successfully.";
			} else {
				return "TypeOfSimplePatrimony already exists in the database.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public List<TypeOfSimplePatrimony> readTypeOfSimplePatrimonys() {
		return typeOfSimplePatrimonyRepository.findAll();
	}

	@Transactional
	public String updateTypeOfSimplePatrimony(TypeOfSimplePatrimony typeOfSimplePatrimony) {
		if (typeOfSimplePatrimonyRepository.existsByDescription(typeOfSimplePatrimony.getDescription())) {
			try {
				List<TypeOfSimplePatrimony> typeOfSimplePatrimonys = typeOfSimplePatrimonyRepository.findByDescription(typeOfSimplePatrimony.getDescription());
				typeOfSimplePatrimonys.stream().forEach(s -> {
					TypeOfSimplePatrimony typeOfSimplePatrimonyToBeUpdate = typeOfSimplePatrimonyRepository.findById(s.getId()).get();
					typeOfSimplePatrimonyToBeUpdate.setDescription(typeOfSimplePatrimony.getDescription());
					typeOfSimplePatrimonyRepository.save(typeOfSimplePatrimonyToBeUpdate);
				});
				return "TypeOfSimplePatrimony record updated.";
			} catch (Exception e) {
				throw e;
			}
		} else {
			return "TypeOfSimplePatrimony does not exists in the database.";
		}
	}

	@Transactional
	public String deleteTypeOfSimplePatrimony(TypeOfSimplePatrimony typeOfSimplePatrimony) {
		if (typeOfSimplePatrimonyRepository.existsByDescription(typeOfSimplePatrimony.getDescription())) {
			try {
				List<TypeOfSimplePatrimony> typeOfSimplePatrimonys = typeOfSimplePatrimonyRepository.findByDescription(typeOfSimplePatrimony.getDescription());
				typeOfSimplePatrimonys.stream().forEach(s -> {
					typeOfSimplePatrimonyRepository.delete(s);
				});
				return "TypeOfSimplePatrimony record deleted successfully.";
			} catch (Exception e) {
				throw e;
			}

		} else {
			return "TypeOfSimplePatrimony does not exist";
		}
	}
}
