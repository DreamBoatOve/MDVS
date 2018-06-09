package com.cyl.newread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;

public class ReadWord {

	public static void main(String[] args) {
		ReadWord rtf = new ReadWord();
		//String filePath = "d:\\word\\line.docx";
		String filePath = "d:\\word\\LINE2-5-9-时.docx";
//		String savepicturePath = "d:\\word\\image\\";
		rtf.readtextfield(filePath);
		//rtf.readpicture(filePath, savepicturePath);
	}

	/*
	 * 提取表格内容
	 */
	public void readtextfield(String filePath){
		File file = null;
		FileInputStream fis = null;
		XWPFDocument xdoc = null;
		int size = 0;
		String comment = "";
		try{
			file = new File(filePath);
			fis = new FileInputStream(file);
			xdoc = new XWPFDocument(fis);
			List<XWPFParagraph> paragraphList = xdoc.getParagraphs();  //
			size = paragraphList.size();
//			System.out.println("paragraph共"+size+"个");
//			size=1;	
			for(int i=0;i<size;i++)
			{
				/*
				 * 提取文本内容
				 */
				 XWPFParagraph paragraph = paragraphList.get(i);  //得到每一页内容
				 XmlObject xmlobject = paragraph.getCTP();   //把每页的内容转换为xmlobject
//				 int RArraySize = paragraph.getCTP().sizeOfRArray();
//				 System.out.println(RArraySize);
//				 List<XmlObject> xmlobject = paragraph.getCTP().getRArray();
//				 XmlObject xmlobject = paragraph.getCTP().getRArray(0);  //把每页内容的第一个文本框（好像是以栈的形式存储的也就是最后一个）转换为xmlobject
//				 System.out.println("XmlObject内容：" + "/r/n" + object); 
				 XmlCursor xpathCursor = xmlobject.newCursor();  //创建游标
				 xpathCursor.selectPath("$this");  //执行XPath语句，$this代表当前游标位置
				 String context = xpathCursor.getTextValue();  //将其转换为文本值
				 System.out.println("第" + (i+1) + "Paragraph的文本内容为" + context); 
				 /*
				  * 提炼关键内容
				  */
				 //提取comment
				 int commentIndex = context.indexOf("Comment", context.indexOf("Comment")+1);  //寻找第二个Comment的位置 
				 if(commentIndex!=-1)
				 {
					 int abIndex = context.indexOf("-A", commentIndex);  //结束标志
					 if(abIndex==-1)
					 {
						 abIndex=context.indexOf("-B", commentIndex);
					 }
					 comment = context.substring(commentIndex+8,abIndex+2);
					 System.out.println("第" + (i+1) + "Paragraph的Comment为" + comment);
					 //分割
					 String[] comments = comment.split("-");
					 int row = Integer.parseInt(comments[0]);
					 int column = Integer.parseInt(comments[1]);
					 String scanType = comments[2];
					 System.out.println("Row："+row);
					 System.out.println("Column："+column);
					 System.out.println("ScanType："+scanType);
					 if(scanType.equals("mapping"))
					 {
						 String experiment = comments[3];
						 System.out.println("Experiment："+experiment);
					 }
					 else
					 {
						 String point = comments[3];
						 String experiment = comments[4];
						 System.out.println("Point："+point);
						 System.out.println("Experiment："+experiment);
					 }
					
				 } 
				 //提取元素组成比例
				 int atomicIndex = context.indexOf("Atomic", context.indexOf("Atomic")+1);  //寻找第二个Atomic的位置 
				 if(atomicIndex!=-1)
				 {
					 int totalIndex = context.indexOf("Total", atomicIndex);  //结束标志
					 String composition = context.substring(atomicIndex+12,totalIndex+12);
					 System.out.println("第" + (i+1) + "Paragraph的Composition为" + composition);
					 //分割
					 while(!composition.equals("Totals100.00"))  //迭代
					 {
						 int space = composition.indexOf(" ");
						 String element = composition.substring(0, space);  //元素
						 String orbital = composition.substring(space+1, space+2);  //核外电子层
						 int pointWeight = composition.indexOf(".");  //Weight小数点位置
						 int pointAtomic = composition.indexOf(".", pointWeight+1);  //Atomic小数点位置
						 double Weight = new Double(composition.substring(space+2, pointWeight+3));  //Weight值
						 double Atomic = new Double(composition.substring(pointWeight+3, pointAtomic+3));  //Atomic值
						 System.out.println("元素：" + element + " 核外电子层：" + orbital);
						 System.out.println("Weight值：" + Weight);
						 System.out.println("Atomic值：" + Atomic);
						 composition = composition.substring(pointAtomic+3);
					 }	 
				 }
//				 System.out.println("第" + (i+1) + "Paragraph的Comment为" + comment);
				 System.out.println("-------------------------------------------");
				 xpathCursor.dispose();  //取消分配管理游标所需的资源，使该游标不可操作
			}
//			System.out.println("表格数为" + count);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(xdoc!=null)
				{
					xdoc.close();
				}
				if(fis!=null)
				{
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			
		}
		
	}
	
	/*
	 * 提取图片
	 */
	public void readpicture(String filePath, String savepicturePath){
		 File file = new File(filePath);
		 FileInputStream fis = null;
		 XWPFDocument xdoc = null;
		 FileOutputStream fos = null;
		 try {
		      fis = new FileInputStream(file);
		      xdoc = new XWPFDocument(fis);
		      List<XWPFPictureData> picList = xdoc.getAllPictures();
		      for (XWPFPictureData pic : picList) {
		        System.out.println(pic.getFileName());
		        byte[] bytev = pic.getData();
		        fos = new FileOutputStream(savepicturePath+pic.getFileName()); 
		        fos.write(bytev);
		      }

		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    finally{
		    	try {
		    		xdoc.close();
					fis.close();
			    	fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 	
		    }
	}
}
