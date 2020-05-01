package ezc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ezc.model.DistributorMaster;
import ezc.service.IDistService;

@RestController
@CrossOrigin
@RequestMapping("api/dist")
public class DistController {

	@Autowired
	IDistService distService;
	
	@RequestMapping({ "/list" })
	public List<DistributorMaster> listDist() {
		return distService.findAll();
	}

}