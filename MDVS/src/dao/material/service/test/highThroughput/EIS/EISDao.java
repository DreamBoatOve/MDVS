package dao.material.service.test.highThroughput.EIS;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.material.service.test.highThroughput.EIS.EIS;
import beans.material.service.test.highThroughput.EIS.EIS_Bode_Nyquist;
import beans.material.service.test.highThroughput.EIS.EIS_OCV;

@Repository("EISDao")
public class EISDao implements IEISDao 
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
	public void addEIS(EIS eis) 
	{
		sf.getCurrentSession().save(eis);
	}
	@Override
	public void removeEIS(EIS eis) 
	{
		sf.getCurrentSession().remove(eis);
	}
	@Override
	public void modifyEIS(EIS eis) 
	{
		sf.getCurrentSession().update(eis);
	}
	@Override
	public Set<EIS_OCV> findEIS_OCV_Set(int id) 
	{
		String hql = "from eis e where e.id = ?";
		EIS eis = (EIS) sf.getCurrentSession().createQuery(hql).setInteger(0, id).uniqueResult();
		return eis.getEIS_OCV_Set();
	}
	@Override
	public Set<EIS_Bode_Nyquist> findEIS_Bode_Nyquist(int id) 
	{
		String hql = "from eis e where e.id = ?";
		EIS e = (EIS)sf.getCurrentSession().createQuery(hql).setInteger(0, id).uniqueResult();
		return e.getEIS_Bode_Nyquist_Set();
	}
}