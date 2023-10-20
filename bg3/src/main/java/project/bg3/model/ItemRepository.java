package project.bg3.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ItemRepository extends CrudRepository<Item, Long> {
	List<Item> findByName(@Param("name") String name);
	List<Item> findByRarity(@Param("name") String rarity);
	
}