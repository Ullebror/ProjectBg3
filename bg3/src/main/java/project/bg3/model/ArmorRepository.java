package project.bg3.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
public interface ArmorRepository extends CrudRepository<Armor, Long> {
	List<Armor> findByName(@Param("name") String name);
	List<Armor> findByRarity(@Param("rarity") String rarity);
	List<Armor> findByAc(@Param("ac") int ac);
}