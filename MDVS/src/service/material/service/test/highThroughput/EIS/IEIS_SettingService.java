package service.material.service.test.highThroughput.EIS;

import beans.material.service.test.highThroughput.EIS.EIS_Setting;

public interface IEIS_SettingService 
{
	void addEIS_Setting(EIS_Setting eis_Setting);
	void removeEIS_Setting(EIS_Setting eis_Setting);
	void modifyEIS_Setting(EIS_Setting eis_Setting);
}