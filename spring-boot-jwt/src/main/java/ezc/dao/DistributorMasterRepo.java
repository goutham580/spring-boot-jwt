/**
 * 
 */
package ezc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ezc.model.DistributorMaster;


public interface DistributorMasterRepo extends JpaRepository<DistributorMaster, String> {
	
	
	
	/*
	 * @Query(nativeQuery = true) DistributorMaster
	 * distributorDetails(@Param("code") String code);
	 */
	
	

}
