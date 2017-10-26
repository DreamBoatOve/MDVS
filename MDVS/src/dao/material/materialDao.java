package dao.material;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beans.material.material;
import beans.material.service.service;

@Repository("materialDao")
public class materialDao implements IMaterialDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addMaterial(material material) 
	{
		sessionFactory.getCurrentSession().save(material);
	}
	@Override
	public void removeMaterialByName(String materialName) 
	{
		String hql = "from material m where m.materialName = ?";
		material m = (material) sessionFactory.getCurrentSession().createQuery(hql).setString(0,materialName).uniqueResult();
		sessionFactory.getCurrentSession().remove(m);
	}
	@Override
	public void updateMaterial(material material) 
	{
		sessionFactory.getCurrentSession().update(material);
	}
	@Override
	public List<String> findMaterialNames() 
	{
		String hql = "select materialName from material";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	@Override
	public List<String> findMaterialsByName(String materialName) 
	{
		String hql = "from material m where m.materialName = ?";
		return sessionFactory.getCurrentSession().createQuery(hql).setString(0,materialName).list();
	}
	@Override
	public List<String> findMaterialsByColor(String materialColor) 
	{
		String hql = "from material m where m.black_Colorful = ?";
		return sessionFactory.getCurrentSession().createQuery(hql).setString(0, materialColor).list();
	}
	@Override
	public List<String> findMaterialsByDensity(String materialDensity)
	{
		String hql = "from material m where m.light_Heavy = ?";
		return sessionFactory.getCurrentSession().createQuery(hql).setString(0, materialDensity).list();
	}
	@Override
	public List<String> findMaterialsByReserves(String materialReserves)
	{
		String hql = "from material m where m.common_Rare = ?";
		return sessionFactory.getCurrentSession().createQuery(hql).setString(0, materialReserves).list();
	}
	@Override
	public service findMaterialServiceById(int id) 
	{
		String hql = "from material m where m.id = ?";
		material m = (material) sessionFactory.getCurrentSession().createQuery(hql).setInteger(0, id).uniqueResult();
		service service = (service) m.getService();
		return service;
	}
}
