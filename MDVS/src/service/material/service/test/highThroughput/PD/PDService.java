package service.material.service.test.highThroughput.PD;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.material.service.test.highThroughput.PD.PD;
import dao.material.service.test.highThroughput.PD.IPDDao;

@Service("PDService")
public class PDService implements IPDService 
{
	@Resource
	private IPDDao pdDao;
	
	public IPDDao getPdDao() {
		return pdDao;
	}
	public void setPdDao(IPDDao pdDao) {
		this.pdDao = pdDao;
	}

	@Transactional
	@Override
	public void addPD(PD pd) 
	{
		pdDao.addPD(pd);
	}
}