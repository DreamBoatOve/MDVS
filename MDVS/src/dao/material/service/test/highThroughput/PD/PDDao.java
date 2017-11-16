package dao.material.service.test.highThroughput.PD;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.material.service.test.highThroughput.PD.PD;

@Repository("PDDao")
public class PDDao implements IPDDao 
{
	@Autowired
	private SessionFactory sf;
	
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void addPD(PD pd) 
	{
		sf.getCurrentSession().save(pd);
	}
}
