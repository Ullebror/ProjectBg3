package project.bg3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import project.bg3.entity.Armor;



@RepositoryRestResource
public interface ArmorRepository extends CrudRepository<Armor, Long> {
	public List<Armor> findByid(@Param("id") long id);
	public Armor findArmorByid(long id);
	public List<Armor> findByName(@Param("name") String name);
	public List<Armor> findByAc(@Param("ac") int ac);
	
	//Testing if I can make search functionality, works ok.
	@Query("SELECT armor FROM Armor armor WHERE CONCAT(armor.name, ' ', armor.rarity.rarity, ' ', armor.ac, ' ',armor.type) LIKE %?1%")
	public List<Armor> findAllArmor(String keyword);
}