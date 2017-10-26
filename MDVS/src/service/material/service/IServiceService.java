package service.material.service;

import beans.material.service.service;
import beans.material.service.environment.environment;
import beans.material.service.test.test;

/*
 * @Author: Ove
 * @Date: 2017-10-26
 * */
public interface IServiceService 
{
	void addService(service service);
	void removeService(service service);
	void modifyService(service service);
	
	//根据service的id去查下属的environment
	environment findServiceEnvironment(int id);
	//根据service的id去查下属的test
	test findServiceTest(int id);
}