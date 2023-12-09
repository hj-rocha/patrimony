package br.iff.bji.patrimony.api.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.iff.bji.patrimony.api.entity.Question;
import br.iff.bji.patrimony.api.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Transactional
	public String createQuestion(Question question) {
		try {
			if (!questionRepository.existsByDescription(question.getDescription())) {
				question.setId(null == questionRepository.findMaxId() ? 0 : questionRepository.findMaxId() + 1);
				questionRepository.save(question);
				return "Question record created successfully.";
			} else {
				return "Question already exists in the database.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Question> readQuestions() {
		return questionRepository.findAll();
	}

	@Transactional
	public String updateQuestion(Question question) {
		if (questionRepository.existsByDescription(question.getDescription())) {
			try {
				List<Question> questions = questionRepository.findByDescription(question.getDescription());
				questions.stream().forEach(s -> {
					Question questionToBeUpdate = questionRepository.findById(s.getId()).get();
					questionToBeUpdate.setIsAnswser(question.getIsAnswser());
					questionToBeUpdate.setDescription(question.getDescription());
					questionRepository.save(questionToBeUpdate);
				});
				return "Question record updated.";
			} catch (Exception e) {
				throw e;
			}
		} else {
			return "Question does not exists in the database.";
		}
	}

	@Transactional
	public String deleteQuestion(Question question) {
		if (questionRepository.existsByDescription(question.getDescription())) {
			try {
				List<Question> questions = questionRepository.findByDescription(question.getDescription());
				questions.stream().forEach(s -> {
					questionRepository.delete(s);
				});
				return "Question record deleted successfully.";
			} catch (Exception e) {
				throw e;
			}

		} else {
			return "Question does not exist";
		}
	}
}
