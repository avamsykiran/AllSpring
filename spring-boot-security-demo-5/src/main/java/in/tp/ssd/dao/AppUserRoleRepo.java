package in.tp.ssd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tp.ssd.model.AppUser;
import in.tp.ssd.model.UserRole;

@Repository
public interface AppUserRoleRepo extends JpaRepository<UserRole, Long>{
	List<UserRole> findAllByAppUser(AppUser appUser);
}
