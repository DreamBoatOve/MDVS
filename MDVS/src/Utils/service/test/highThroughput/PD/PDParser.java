package Utils.service.test.highThroughput.PD;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import beans.material.service.test.highThroughput.PD.PD_Chart;
import beans.material.service.test.highThroughput.PD.PD_OCV;
import beans.material.service.test.highThroughput.PD.PD_Setting;

public class PDParser implements IPDParser 
{
	@Override
	public PD_Setting getPD_Setting(File PDFile) 
	{
		PD_Setting pd_Setting = new PD_Setting();
		pd_Setting.setPD_fileName(PDFile.getName());
		
		DataInputStream dis = null;
		try 
		{
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(PDFile)));
			
			String s = new String();
			int count = 1;
			String[] date = new String[2];
			while((s = dis.readLine()) != null)
			{
				String[] ss = s.split("\t");
				
				if(count == 3)
				{
					pd_Setting.setTest_Identifier(ss[2]);
					System.out.println(pd_Setting.getTest_Identifier());
				}
				else if((count == 4) || (count == 5))
				{
					date[count-4] = ss[2];
					if(date[1] != null)
					{
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd h:mm:ss");
						Date d = sdf.parse(date[0]+" "+date[1]);
						pd_Setting.setExperimentTime(d);
						System.out.println(pd_Setting.getExperimentTime());
					}
				}
				else if(count == 9)
				{
					pd_Setting.setInitialE(Double.valueOf(ss[2]));
				}
				else if(count == 10)
				{
					pd_Setting.setFinalE(Double.valueOf(ss[2]));
				}
				else if(count == 11)
				{
					pd_Setting.setScanRate(Double.valueOf(ss[2]));
				}
				else if(count == 12)
				{
					pd_Setting.setSamplePeriod(Double.valueOf(ss[2]));
				}
				else if(count == 13)
				{
					pd_Setting.setSampleArea(Double.valueOf(ss[2]));
				}
				else if(count == 14)
				{
					pd_Setting.setDensity(Double.valueOf(ss[2]));
				}
				else if(count == 15)
				{
					pd_Setting.setEquiv(Double.valueOf(ss[2]));
				}
				else if(count == 16)
				{
					pd_Setting.setConditioningStatus(ss[2].toCharArray()[0]);
					pd_Setting.setConditioning(Double.valueOf(ss[3]));
					System.out.println(pd_Setting.getConditioningStatus()+"---"+pd_Setting.getConditioning());
				}
				else if(count == 17)
				{
					pd_Setting.setInitDelayStatus(ss[2].toCharArray()[0]);
					pd_Setting.setInitDelay(Double.valueOf(ss[3]));
					System.out.println(pd_Setting.getInitDelayStatus()+"---"+pd_Setting.getInitDelay());
				}
				else if(count > 20)
				{
					break;
				}
				count++;
			}
		}
		catch (FileNotFoundException e) 
		{e.printStackTrace();} 
		catch (IOException e) 
		{e.printStackTrace();} 
		catch (ParseException e) 
		{e.printStackTrace();}
		finally
		{
			try 
			{
				if(dis != null)
				{dis.close();}
			}
			catch (IOException e) 
			{e.printStackTrace();}
		}
		return pd_Setting;
	}
	@Override
	public Set<PD_OCV> getPD_OcvSet(File PDFile) 
	{
		Set<PD_OCV> set = new HashSet<PD_OCV>();
		DataInputStream dis = null;
		
		String s = new String();
		try 
		{
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(PDFile)));
			int count = 1;
			while((s = dis.readLine()) != null)
			{
				String[] ss = s.split("\t");
				if(count > 21)
				{
					if("EOC".equals(ss[0]))
					{
						break;
					}
					PD_OCV ocv = new PD_OCV();
					ocv.setOriginalID(Integer.valueOf(ss[1]));
					//System.out.println(ocv.getOriginalID());
					ocv.setTime(Double.valueOf(ss[2]));
					//System.out.println(ocv.getTime());
					ocv.setVf(Double.valueOf(ss[3]));
					//System.out.println(ocv.getVf());
					ocv.setVm(Double.valueOf(ss[4]));
					//System.out.println(ocv.getVm());
					ocv.setAch(Double.valueOf(ss[5]));
					//System.out.println(ocv.getAch());
					set.add(ocv);
				}
				count++;
			}
		}
		catch (FileNotFoundException e) 
		{e.printStackTrace();}
		catch (IOException e) 
		{e.printStackTrace();}
		finally
		{
			try 
			{
				if(dis != null)
				{dis.close();}
			}
			catch (IOException e) 
			{e.printStackTrace();}
		}
		return set;
	}
	@Override
	public Set<PD_Chart> getPD_ChartSet(File PDFile) 
	{
		Set<PD_Chart> chart = new HashSet<PD_Chart>();
		DataInputStream dis = null;
		try 
		{
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(PDFile)));
			String s = new String();
			int count = 0;
			boolean r = false;
			int n = 0;
			while((s = dis.readLine()) != null)
			{
				String[] ss = s.split("\t");
				count++;
				if(count > 8)
				{
					if("CURVE".equals(ss[0]) || r)
					{
						r = true;
						n++;
						if(n > 3)
						{
							PD_Chart c = new PD_Chart();
							c.setOriginalID(Integer.valueOf(ss[1]));
							System.out.println(c.getOriginalID());
							c.setTime(Double.valueOf(ss[2]));
							System.out.println(c.getTime());
							c.setVf(Double.valueOf(ss[3]));
							System.out.println(c.getVf());
							c.setIm(Double.valueOf(ss[4]));
							System.out.println(c.getIm());
							c.setVu(Double.valueOf(ss[5]));
							System.out.println(c.getVu());
							c.setSig(Double.valueOf(ss[6]));
							System.out.println(c.getSig());
							c.setAch(Double.valueOf(ss[7]));
							System.out.println(c.getAch());
							c.setIERange(Double.valueOf(ss[8]));
							System.out.println(c.getIERange());
							chart.add(c);
						}
					}
				}
			}
		}
		catch (FileNotFoundException e) 
		{e.printStackTrace();} 
		catch (IOException e) 
		{e.printStackTrace();}
		finally
		{
			try 
			{
				if(dis != null)
				{dis.close();}
			}
			catch (IOException e) 
			{e.printStackTrace();}
		}
		return chart;
	}
}