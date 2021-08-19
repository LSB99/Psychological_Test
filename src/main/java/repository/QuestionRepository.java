package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	Question findAllById(Long id);
}