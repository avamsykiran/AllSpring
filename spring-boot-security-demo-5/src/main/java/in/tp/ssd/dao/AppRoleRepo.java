package in.tp.ssd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tp.ssd.model.AppRole;

@Repository
public interface AppRoleRepo extends JpaRepository<AppRole, Long>{

}
