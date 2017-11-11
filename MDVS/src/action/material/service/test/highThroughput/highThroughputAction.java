package action.material.service.test.highThroughput;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import service.material.service.test.highThroughput.IHighThroughputService;

@Component("highThroughputAction")
@Scope("prototype")
@Namespace("/highThroughput")
@ParentPackage("struts-default")
public class highThroughputAction 
{
	private Integer row;
	private Integer column;
	private File EISFile;
	private File PDFile;
	
	@Autowired
	@Qualifier("highThroughputService")
	private IHighThroughputService highThroughputService;
	
	public Integer getRow() 
	{
		return row;
	}
	public void setRow(Integer row) 
	{
		this.row = row;
	}
	public Integer getColumn() 
	{
		return column;
	}
	public void setColumn(Integer column) 
	{
		this.column = column;
	}
	public File getEISFile() 
	{
		return EISFile;
	}
	public void setEISFile(File eISFile) 
	{
		EISFile = eISFile;
	}
	public File getPDFile() 
	{
		return PDFile;
	}
	public void setPDFile(File pDFile) 
	{
		PDFile = pDFile;
	}
	public IHighThroughputService getHighThroughputService() 
	{
		return highThroughputService;
	}
	public void setHighThroughputService(IHighThroughputService highThroughputService) 
	{
		this.highThroughputService = highThroughputService;
	}
	
	/*把获取到的实验文件输出到指定位置
	 * 用于测试是否获取到文件
	 */
	@Action(value="restoreFile",results=@Result(location="/success.jsp"))
	public void restoreFile()
	{
		BufferedReader br = null;
		BufferedWriter bw = null;
		try 
		{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(EISFile)));
			bw = new  BufferedWriter(new OutputStreamWriter(new FileOutputStream("J:"+File.separator+"eis.DTA")));
			
			String line = new String();
			while((line = br.readLine() + "\n") != null)
			{
				bw.write(line);
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
				if(br != null)
				{ br.close();}
			}
			catch (IOException e) 
			{e.printStackTrace();}
			try 
			{
				if(bw != null)
				{ bw.close();}
			}
			catch (IOException e) 
			{e.printStackTrace();}
		}
	}
	//解析EIS.DTA文件并将对应数据放入数据库
	public void addEIS()
	{
		
	}
	//解析PD.DTA文件并将对应数据放入数据库
	public void addPD()
	{
		
	}
}
