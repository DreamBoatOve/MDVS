package test;

import java.io.File;

import org.junit.Test;

import Utils.service.test.highThroughput.EIS.EISParser;
import Utils.service.test.highThroughput.PD.PDParser;

public class ParserTest 
{
	File EISFile = new File("H:\\Data\\Original_Data\\EIS\\20170415-EIS-2-1.DTA");
	EISParser e = new EISParser();
	@Test
	public void getEIS_SettingTest()
	{
		e.getEIS_Setting(EISFile);
	}
	@Test
	public void getEIS_OCVSetTest()
	{
		e.getEIS_OCVSet(EISFile);
	}
	@Test
	public void getEIS_Bode_NyquistSetTest()
	{
		e.getEIS_Bode_NyquistSet(EISFile);
	}
	File PDFile = new File("H:\\Data\\Test_Data\\PD\\20170415-pd-2-1.DTA");
	PDParser p = new PDParser();
	@Test
	public void getPD_SettingTest()
	{
		p.getPD_Setting(PDFile);
	}
	@Test
	public void getPD_OcvSetTest()
	{
		p.getPD_OcvSet(PDFile);
	}
	@Test
	public void getPD_ChartSetTest()
	{
		p.getPD_ChartSet(PDFile);
	}
}
