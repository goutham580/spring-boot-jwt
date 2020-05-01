package ezc.service;

import java.util.List;

import ezc.model.DistributorMaster;

public interface IDistService {

	DistributorMaster addNewDistributor(DistributorMaster distDto);
	List<DistributorMaster> findAll();

}
