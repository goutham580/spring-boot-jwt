/**
 * 
 */
package ezc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ezc.model.EzcPoAcknowledgement;


public interface PurchaseOrderRepo extends JpaRepository<EzcPoAcknowledgement, String> {
	
	
	
	/*
	 * @Query(nativeQuery = true) DistributorMaster
	 * distributorDetails(@Param("code") String code);
	 */
	
	

}
