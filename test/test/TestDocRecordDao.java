package test;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sooba.db.DocRecord;
import sooba.db.DocRecordDao;
import sooba.db.admin.AdminDaoImpl;
import sooba.db.admin.User;


public class TestDocRecordDao {
	
	
	private String path="applicationContext.xml";
	private ApplicationContext ctx;
	private DocRecordDao docDao;
    @Before
    public void setUp() throws Exception {
		ctx=new ClassPathXmlApplicationContext(path);
		docDao=(DocRecordDao)ctx.getBean("docDao");
	}
    
	@After
	public void tearDown() throws Exception {
		ctx=null;
		docDao=null;
	}
	
	@Test
	public void testget(){
	
		long ldate=docDao.getTop1(".pdf");
		Date date2=new Date();
		if(ldate>date2.getTime())System.out.println(new Date(ldate));
		else System.out.println(date2);
		System.out.println(new Date(ldate));
	}

}
