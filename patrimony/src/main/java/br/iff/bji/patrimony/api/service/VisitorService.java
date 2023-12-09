package br.iff.bji.patrimony.api.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.iff.bji.patrimony.api.entity.Visitor;
import br.iff.bji.patrimony.api.repository.VisitorRepository;

@Service
public class VisitorService {

	@Autowired
	private VisitorRepository visitorRepository;

	@Transactional
	public String createVisitor(Visitor visitor) {
		try {
			if (!visitorRepository.existsByCPF(visitor.getCPF())) {
				visitor.setId(null == visitorRepository.findMaxId() ? 0 : visitorRepository.findMaxId() + 1);
				visitorRepository.save(visitor);
				return "Visitor record created successfully.";
			} else {
				return "Visitor already exists in the database.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Visitor> readVisitors() {
		return visitorRepository.findAll();
	}

	@Transactional
	public String updateVisitor(Visitor visitor) {
		if (visitorRepository.existsByCPF(visitor.getCPF())) {
			try {
				List<Visitor> visitors = visitorRepository.findByCPF(visitor.getCPF());
				visitors.stream().forEach(s -> {
					Visitor visitorToBeUpdate = visitorRepository.findById(s.getId()).get();
					visitorToBeUpdate.setName(visitor.getName());
					visitorToBeUpdate.setCPF(visitor.getCPF());
					visitorToBeUpdate.setRg(visitor.getRg());
					visitorToBeUpdate.setBirthday(visitor.getBirthday());
					visitorToBeUpdate.setAddress(visitor.getAddress());
					visitorToBeUpdate.setComplement(visitor.getComplement());
					visitorToBeUpdate.setTown(visitor.getTown());
					visitorToBeUpdate.setDistrict(visitor.getDistrict());
					visitorToBeUpdate.setUf(visitor.getUf());
					visitorToBeUpdate.setState(visitor.getState());
					visitorToBeUpdate.setPostalCode(visitor.getPostalCode());
					visitorToBeUpdate.setPhone(visitor.getPhone());
					visitorToBeUpdate.setEmail(visitor.getEmail());
					visitorRepository.save(visitorToBeUpdate);
				});
				return "Visitor record updated.";
			} catch (Exception e) {
				throw e;
			}
		} else {
			return "Visitor does not exists in the database.";
		}
	}

	@Transactional
	public String deleteVisitor(Visitor visitor) {
		if (visitorRepository.existsByCPF(visitor.getCPF())) {
			try {
				List<Visitor> visitors = visitorRepository.findByCPF(visitor.getCPF());
				visitors.stream().forEach(s -> {
					visitorRepository.delete(s);
				});
				return "Visitor record deleted successfully.";
			} catch (Exception e) {
				throw e;
			}

		} else {
			return "Visitor does not exist";
		}
	}
}
