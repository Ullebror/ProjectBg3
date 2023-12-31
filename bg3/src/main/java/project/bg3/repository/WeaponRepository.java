package project.bg3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import project.bg3.entity.Weapon;

@RepositoryRestResource
public interface WeaponRepository extends CrudRepository<Weapon, Long> {
	List<Weapon> findByName(@Param("name") String name);

}