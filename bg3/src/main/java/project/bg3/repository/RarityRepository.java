package project.bg3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import project.bg3.entity.Rarity;

@RepositoryRestResource
public interface RarityRepository extends CrudRepository<Rarity, Long> {

	Rarity findByRarity(String string);
	
}