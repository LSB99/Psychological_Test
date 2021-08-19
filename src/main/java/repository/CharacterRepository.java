package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Character;

public interface CharacterRepository extends JpaRepository<Character, Long> {

}