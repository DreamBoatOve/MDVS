package service.material;

import java.util.List;

import beans.material.material;

public interface IMaterialService 
{
	void addMaterial(material material);
	void removeMaterialByName(String materialName);
	void modifyMaterialByName(String materialName);

	//查询要模糊匹配
	List<String> findMaterialNames();
	List<String> findMaterialsByName(String materialName);
	List<String> findMaterialsByColor(String materialColor);
	List<String> findMaterialsByDensity(String materialDensity);
	List<String> findMaterialsByReserves(String materialReserves);
}
