package dao.material;

import java.util.List;

import org.hibernate.SessionFactory;

import beans.material.material;

public class materialDao implements IMaterialDao 
{
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
	}
	@Override
	public void removeMaterialByName(String materialName) 
	{
	}
	@Override
	public void modifyMaterialByName(String materialName) 
	{
	}
	@Override
	public List<String> findMaterialNames() 
	{
		return null;
	}
	@Override
	public List<String> findMaterialsByName(String materialName) 
	{
		return null;
	}
	@Override
	public List<String> findMaterialsByColor(String materialColor) 
	{
		return null;
	}
	@Override
	public List<String> findMaterialsByDensity(String materialDensity)
	{
		return null;
	}
	@Override
	public List<String> findMaterialsByReserves(String materialReserves)
	{
		return null;
	}
}
