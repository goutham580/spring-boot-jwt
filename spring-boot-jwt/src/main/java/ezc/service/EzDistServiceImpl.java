package ezc.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezc.dao.DistributorMasterRepo;
import ezc.model.DistributorMaster;
@Service
@Transactional
public class EzDistServiceImpl implements IDistService {

	@Autowired
	DistributorMasterRepo distMastRepo;
	
	@Override
	public DistributorMaster addNewDistributor(DistributorMaster distDto) {
	
		return distMastRepo.save(distDto);
	}

	@Override
	public List<DistributorMaster> findAll() {
		List<DistributorMaster> distList = new ArrayList<DistributorMaster>();

		distList.addAll(distMastRepo.findAll());

		return distList;
	}

}
