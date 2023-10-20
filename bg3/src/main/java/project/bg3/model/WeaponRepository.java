package project.bg3.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WeaponRepository extends CrudRepository<Weapon, Long> {
	
}