package project.bg3.repository;


import org.springframework.data.repository.CrudRepository;

import project.bg3.entity.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
	AppUser findByUsername(String username);
}