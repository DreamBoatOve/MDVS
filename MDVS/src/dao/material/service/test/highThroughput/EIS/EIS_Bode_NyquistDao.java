package dao.material.service.test.highThroughput.EIS;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.material.service.test.highThroughput.EIS.EIS_Bode_Nyquist;

@Repository("EIS_Bode_NyquistDao")
public class EIS_Bode_NyquistDao implements IEIS_Bode_NyquistDao 
{
	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() 
	{
		return sf;
	}
	public void setSf(SessionFactory sf) 
	{
		this.sf = sf;
	}

	@Override
	public void addEIS_Bode_Nyquist(EIS_Bode_Nyquist eis_Bode_Nyquist) 
	{
		sf.getCurrentSession().save(eis_Bode_Nyquist);
	}
	@Override
	public void removeEIS_Bode_Nyquist(EIS_Bode_Nyquist eis_Bode_Nyquist) 
	{
		sf.getCurrentSession().remove(eis_Bode_Nyquist);
	}
	@Override
	public void modifyEIS_Bode_Nyquist(EIS_Bode_Nyquist eis_Bode_Nyquist) 
	{
		sf.getCurrentSession().remove(eis_Bode_Nyquist);
	}
}
