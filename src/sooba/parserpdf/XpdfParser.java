package sooba.parserpdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import sooba.util.Constant;


public class XpdfParser {
	
	
	
//	@Test 
	public void test1(){
		XpdfParser xpdf=new XpdfParser();
//		xpdf.getEachFile();
		
	}
	
	@Test
   public String getPDFFileContent(String strtmp) throws InterruptedException{
			int beginIndex=strtmp.indexOf("pdfdir")+7;
			int endIndex =strtmp.indexOf(".pdf");	
			System.out.println(beginIndex+" "+strtmp+" "+endIndex);
			System.out.println("strtmp.substring(beginIndex, endIndex) :" + strtmp.substring(beginIndex, endIndex));
			String canonicalPath=xpdfParser(strtmp,strtmp.substring(beginIndex, endIndex));
	        Thread.sleep(150);
	        System.out.println("canonicalPath :" + canonicalPath);
		    String strRet= getTxtContents(canonicalPath);
		    System.out.println("-------20--------"+strRet);
		    return strRet;
		    
	}
//	@Test
	public String xpdfParser(String getSoure,String fileName){
	    XpdfParams xparam=new XpdfParams();
	    xparam.setConvertor(Constant.ConvertorPATH);
	    xparam.setEncoding("-enc UTF-8");
//	    xparam.setLayout("-layout");
	    xparam.setSource(getSoure);
	    xparam.setTarget(Constant.PDFTxtdir+fileName+".txt");
	    String cmd=xparam.getCMD();
	    System.out.println("cmd:" + cmd);
	    try {
//	    	System.out.println("------2222-------"+cmd);
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return xparam.getTarget();
	}
	
	public String getTxtContents(String canonicalPath){
		StringBuffer strBuffer = new StringBuffer();
//		System.out.println("------------30-----------");
		try{
			
			String line = "";
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(canonicalPath), "UTF-8"));
			line = reader.readLine();
			while (line != null) {
				if (line.length() > 0) {
					strBuffer.append(line.trim());
					//            		strBuffer.append("\n");
				}
				line = reader.readLine();
//				System.out.println(line);
			}
		reader.close();
		}catch(Exception e){
			e.printStackTrace();
			return "exception";
		}
//		if(strBuffer.toString().length()<=500)
		return strBuffer.toString();
//		else return strBuffer.toString().substring(0,500);
	}
	
	public   XpdfParser(){
		File fileTxt=new File(Constant.PDFTxtdir);
		if(!fileTxt.exists())fileTxt.mkdir();
	}
	

}
