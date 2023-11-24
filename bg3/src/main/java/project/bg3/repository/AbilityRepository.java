package project.bg3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import project.bg3.entity.Ability;

@RepositoryRestResource
public interface AbilityRepository extends CrudRepository<Ability, Long> {

	Ability findByAttribute(String string);

}