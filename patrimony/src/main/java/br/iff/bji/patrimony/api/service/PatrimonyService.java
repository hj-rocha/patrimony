package br.iff.bji.patrimony.api.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.iff.bji.patrimony.api.entity.Patrimony;
import br.iff.bji.patrimony.api.repository.PatrimonyRepository;

@Service
public class PatrimonyService {

	@Autowired
	private PatrimonyRepository patrimonyRepository;

	@Transactional
	public String createPatrimony(Patrimony patrimony) {
		try {
			if (!patrimonyRepository.existsByName(patrimony.getName())) {
				patrimony.setId(null == patrimonyRepository.findMaxId() ? 1 : patrimonyRepository.findMaxId() + 1);
				patrimonyRepository.save(patrimony);
				return "Patrimony record created successfully.";
			} else {
				return "Patrimony already exists in the database.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Patrimony> readPatrimonys() {
		return patrimonyRepository.findAll();
	}

	@Transactional
	public String updatePatrimony(Patrimony patrimony) {
		if (patrimonyRepository.existsByName(patrimony.getName())) {
			try {
				List<Patrimony> patrimonys = patrimonyRepository.findByName(patrimony.getName());
				patrimonys.stream().forEach(s -> {
					Patrimony patrimonyToBeUpdate = patrimonyRepository.findById(s.getId()).get();
					patrimonyToBeUpdate.setName(patrimony.getName());
					patrimonyRepository.save(patrimonyToBeUpdate);
				});
				return "Patrimony record updated.";
			} catch (Exception e) {
				throw e;
			}
		} else {
			return "Patrimony does not exists in the database.";
		}
	}

	@Transactional
	public String deletePatrimony(Patrimony patrimony) {
	//	if (patrimonyRepository.existsByName(patrimony.getName())) {
			try {
				//List<Patrimony> patrimonys = patrimonyRepository.findByName(patrimony.getName());
				//patrimonys.stream().forEach(s -> {
					patrimonyRepository.deleteById(patrimony.getId());
				//});
				return "Patrimony record deleted successfully.";
			} catch (Exception e) {
				throw e;
			}

		//} else {
		//	return "Patrimony does not exist";
		//}
	}
}
