package service.material.service.test.highThroughput.EIS;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.material.service.test.highThroughput.EIS.EIS_Bode_Nyquist;
import dao.material.service.test.highThroughput.EIS.IEIS_Bode_NyquistDao;

@Service("EIS_Bode_NyquistService")
public class EIS_Bode_NyquistService implements IEIS_Bode_NyquistService 
{
	@Resource
	private IEIS_Bode_NyquistDao eis_Bode_NyquistDao;

	public IEIS_Bode_NyquistDao getEis_Bode_NyquistDao() 
	{
		return eis_Bode_NyquistDao;
	}
	public void setEis_Bode_NyquistDao(IEIS_Bode_NyquistDao eis_Bode_NyquistDao) 
	{
		this.eis_Bode_NyquistDao = eis_Bode_NyquistDao;
	}

	@Transactional
	@Override
	public void addEIS_Bode_Nyquist(EIS_Bode_Nyquist eis_Bode_Nyquist) 
	{
		eis_Bode_NyquistDao.addEIS_Bode_Nyquist(eis_Bode_Nyquist);
	}
	@Transactional
	@Override
	public void removeEIS_Bode_Nyquist(EIS_Bode_Nyquist eis_Bode_Nyquist) 
	{
		eis_Bode_NyquistDao.removeEIS_Bode_Nyquist(eis_Bode_Nyquist);
	}
	@Transactional
	@Override
	public void modifyEIS_Bode_Nyquist(EIS_Bode_Nyquist eis_Bode_Nyquist) 
	{
		eis_Bode_NyquistDao.modifyEIS_Bode_Nyquist(eis_Bode_Nyquist);
	}
}
