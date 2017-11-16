package test;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import Utils.service.test.highThroughput.EIS.EISParser;
import Utils.service.test.highThroughput.PD.PDParser;
import beans.material.service.test.highThroughput.EIS.EIS_Bode_Nyquist;
import beans.material.service.test.highThroughput.EIS.EIS_Setting;

public class ParserTest 
{
	//File EISFile = new File("H:\\Data\\Original_Data\\EIS\\20170415-EIS-2-1.DTA");
	//File EISFile = new File("H:\\Data\\Original_Data\\EIS\\20170415-EIS-2-2.DTA");
	File EISFile = new File("H:\\Data\\Original_Data\\EIS\\20170415-EIS-2-14.DTA");
	EISParser e = new EISParser(EISFile);
	@Test
	public void getEIS_SettingTest()
	{
		EIS_Setting setting = e.getEIS_Setting();
		System.out.println(setting.toString());
	}
	@Test
	public void getEIS_OCVSetTest()
	{
		e.getEIS_OCVSet();
	}
	@Test
	public void getEIS_Bode_NyquistSetTest()
	{
		Set<EIS_Bode_Nyquist> set = e.getEIS_Bode_NyquistSet();
		Iterator<EIS_Bode_Nyquist> it = set.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().toString());
		}
	}
	//File PDFile = new File("H:\\Data\\Test_Data\\PD\\20170415-pd-2-1.DTA");
	//File PDFile = new File("H:\\Data\\Original_Data\\PD\\20170415-pd-2-5.DTA");
	File PDFile = new File("H:\\Data\\Original_Data\\PD\\20170415-pd-2-12.DTA");
	PDParser p = new PDParser(PDFile);
	@Test
	public void getPD_SettingTest()
	{
		p.getPD_Setting();
	}
	@Test
	public void getPD_OcvSetTest()
	{
		p.getPD_OcvSet();
	}
	@Test
	public void getPD_ChartSetTest()
	{
		p.getPD_ChartSet();
	}
}
