package dao.material;

import java.util.List;

import beans.material.material;
import beans.material.service.service;

public interface IMaterialDao 
{
	public void addMaterial(material material);
	public void removeMaterialByName(String materialName);
	public void updateMaterial(material material);

	//查询要模糊匹配
	public List<String> findMaterialNames();
	public List<String> findMaterialsByName(String materialName);
	public List<String> findMaterialsByColor(String materialColor);
	public List<String> findMaterialsByDensity(String materialDensity);
	public List<String> findMaterialsByReserves(String materialReserves);
	
	service findMaterialServiceById(int id);
}
