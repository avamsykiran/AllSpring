package in.tp.ssd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tp.ssd.model.AppUser;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long>{
	AppUser findByUserName(String userName);
}
