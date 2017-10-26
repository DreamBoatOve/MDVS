package service.material;

import java.util.List;

import beans.material.material;
import beans.material.service.service;

/*
 * @Author: Ove
 * @Date: 2017-10-26
 * */
public interface IMaterialService 
{
	void addMaterial(material material);
	void removeMaterialByName(String materialName);
	void modifyMaterial(material material);

	//查询要模糊匹配
	List<String> findMaterialNames();
	List<String> findMaterialsByName(String materialName);
	List<String> findMaterialsByColor(String materialColor);
	List<String> findMaterialsByDensity(String materialDensity);
	List<String> findMaterialsByReserves(String materialReserves);
	
	//查询材料的功能模块-成分
	//查询材料的功能模块-加工
	//查询材料的功能模块-结构
	
	//查询材料的功能模块-服役
	//通过材料的ID查询
	service findMaterialServiceById(int id);
}
