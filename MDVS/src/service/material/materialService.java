package service.material;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.material.material;
import dao.material.IMaterialDao;

@Service("materialService")
public class materialService implements IMaterialService 
{
	@Resource
	private IMaterialDao materialDao;
	
	public IMaterialDao getMaterialDao() 
	{
		return materialDao;
	}
	public void setMaterialDao(IMaterialDao materialDao) 
	{
		this.materialDao = materialDao;
	}
	
	@Transactional
	@Override
	public void addMaterial(material material) 
	{
		materialDao.addMaterial(material);
	}
	@Transactional
	@Override
	public void removeMaterialByName(String materialName) 
	{
		materialDao.removeMaterialByName(materialName);
	}
	@Transactional
	@Override
	public void modifyMaterial(material material) 
	{
		materialDao.updateMaterial(material);
	}
	@Transactional(readOnly=true)
	@Override
	public List<String> findMaterialNames() 
	{
		return materialDao.findMaterialNames();
	}
	@Transactional(readOnly=true)
	@Override
	public List<String> findMaterialsByName(String materialName) 
	{
		return materialDao.findMaterialsByName(materialName);
	}
	@Transactional(readOnly=true)
	@Override
	public List<String> findMaterialsByColor(String materialColor) 
	{
		return materialDao.findMaterialsByColor(materialColor);
	}
	@Transactional(readOnly=true)
	@Override
	public List<String> findMaterialsByDensity(String materialDensity) 
	{
		return materialDao.findMaterialsByDensity(materialDensity);
	}
	@Transactional(readOnly=true)
	@Override
	public List<String> findMaterialsByReserves(String materialReserves) 
	{
		return materialDao.findMaterialsByReserves(materialReserves);
	}
}