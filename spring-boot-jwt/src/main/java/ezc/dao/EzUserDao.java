package ezc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ezc.model.EzcUsers;

@Repository
public interface EzUserDao extends CrudRepository<EzcUsers, String> {
	
 
	
}