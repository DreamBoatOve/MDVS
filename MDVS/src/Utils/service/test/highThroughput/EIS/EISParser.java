package Utils.service.test.highThroughput.EIS;

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

import beans.material.service.test.highThroughput.EIS.EIS_Bode_Nyquist;
import beans.material.service.test.highThroughput.EIS.EIS_OCV;
import beans.material.service.test.highThroughput.EIS.EIS_Setting;
import dao.material.service.test.highThroughput.EIS.IEIS_Bode_NyquistDao;
import service.material.service.test.highThroughput.EIS.IEIS_Bode_NyquistService;
import service.material.service.test.highThroughput.EIS.IEIS_OCVService;
import service.material.service.test.highThroughput.EIS.IEIS_SettingService;

public class EISParser implements IEISParser 
{
	private File EISFile; 

	@Override
	public EIS_Setting getEIS_Setting() 
	{
		EIS_Setting eis_Setting = new EIS_Setting();
		DataInputStream dis = null;
		try 
		{
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(EISFile)));
			
			String s = new String();
			String[] date = new String[2];
			int count = 1;
			while((s = dis.readLine()) != null)
			{
				String[] ss = s.split("\t");
				if(count == 3)
				{
					eis_Setting.setTest_Identifier(ss[2]);
					//eis_Setting.setTest_Identifier(ss[2]+ss[3]);
				}
				else if((count == 4)||(count == 5))
				{
					date[count-4] = ss[2];
					if(date[1] != null)
					{
						//用于Test
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd h:mm:ss");
						//用于项目正式启动时
						//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd h:mm:ss"); 
						Date d = sdf.parse(date[0]+" "+date[1]);
						eis_Setting.setExperimentTime(d);
					}
				}
				else if(count == 10)
				{
					eis_Setting.setDC(Double.valueOf(ss[2]));
				}
				else if(count == 11)
				{
					eis_Setting.setInitial_Freq(Double.valueOf(ss[2]));
				}
				else if(count == 12)
				{
					eis_Setting.setFinal_Freq(Double.valueOf(ss[2]));
				}
				else if(count == 13)
				{
					eis_Setting.setPoint_Decade(Double.valueOf(ss[2]));
				}
				else if(count == 14)
				{
					eis_Setting.setAC(Double.valueOf(ss[2]));
				}
				else if(count == 15)
				{
					eis_Setting.setArea(Double.valueOf(ss[2]));
				}
				else if(count == 16)
				{
					eis_Setting.setConditioningStatus(ss[2].toCharArray()[0]);
					eis_Setting.setConditioning(Double.valueOf(ss[3]));
				}
				else if(count == 17)
				{
					eis_Setting.setInit_DelayStatus(ss[2].toCharArray()[0]);
					eis_Setting.setInit_Delay(Double.valueOf(ss[3]));
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
		return eis_Setting;
	}
	@Override
	public Set<EIS_OCV> getEIS_OCVSet() 
	{
		Set<EIS_OCV> EIS_OcvSet = new HashSet<EIS_OCV>();
		DataInputStream dis = null;
		try 
		{
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(EISFile)));
			
			String s = new String();
			int count = 1;
			while((s = dis.readLine()) != null)
			{
				String[] ss = s.split("\t"); 
				if(count > 22)
				{
					if("EOC".equals(ss[0]))
					{
						break;
					}
					EIS_OCV o = new EIS_OCV();
					o.setOriginalID(Integer.valueOf(ss[1]));
					o.setT(Double.valueOf(ss[2]));
					o.setVf(Double.valueOf(ss[3]));
					o.setVm(Double.valueOf(ss[4]));
					o.setAch(Double.valueOf(ss[5]));
					EIS_OcvSet.add(o);
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
		return EIS_OcvSet;
	}
	@Override
	public Set<EIS_Bode_Nyquist> getEIS_Bode_NyquistSet() 
	{
		Set<EIS_Bode_Nyquist> bnSet = new HashSet<EIS_Bode_Nyquist>();
		DataInputStream dis = null;
		try 
		{
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(EISFile)));
			
			String s = new String();
			int count = 0;
			int n = 0;
			boolean r = false;
			while((s = dis.readLine()) != null)
			{
				String[] ss = s.split("\t");
				count++;
				if(count > 10)
				{
					if("ZCURVE".equals(ss[0]) || r)
					{
						r = true;
						n++;
						if(n > 3)
						{
							EIS_Bode_Nyquist bn = new EIS_Bode_Nyquist();
							bn.setOriginal_ID(Integer.valueOf(ss[1]));
							bn.setT(Double.valueOf(ss[2]));
							bn.setFreq(Double.valueOf(ss[3]));
							bn.setZreal(Double.valueOf(ss[4]));
							bn.setZimg(Double.valueOf(ss[5]));
							bn.setZsig(Double.valueOf(ss[6]));
							bn.setZmod(Double.valueOf(ss[7]));
							bn.setZphz(Double.valueOf(ss[8]));
							bnSet.add(bn);
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
		return bnSet;
	}
	
	public EISParser() 
	{
		super();
	}
	public EISParser(File EISFile) 
	{
		this.EISFile = EISFile;
	}
}
