package project.bg3.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends CrudRepository<Weapon, Long> {
	List<Weapon> findByName(@Param("name") String name);
	List<Weapon> findByRarity(@Param("rarity") String rarity);
	
	
}