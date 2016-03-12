package test.search;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sooba.search.AdvanceGetSearcheResult;
import sooba.search.DocumentEntity;
import sooba.search.GetSearcheResult;


public class TestGetSearcheResult {
	
	GetSearcheResult gsr=null;
	@Before
	public void setUp() throws Exception {
		gsr=new GetSearcheResult();
	}
    @After
    public void tearDown(){
    	gsr = null;
    }
    
    @Test
    public void test1() throws Exception{
    	
    	
     List<DocumentEntity> list=	gsr.getResult("ÍÚ¾ò", 1, 20);
     for(DocumentEntity docEntity:list){
    	 System.out.print(docEntity.getId()+" ");
    	 System.out.print(docEntity.getType()+" ");
    	 System.out.println(docEntity.getFilename());
    	 System.out.println(docEntity.getOriginalFileName());
     }
    	
    }
	
	
	

}
