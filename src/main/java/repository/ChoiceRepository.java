package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Choice;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
	Choice findAllById(Long id);
}
