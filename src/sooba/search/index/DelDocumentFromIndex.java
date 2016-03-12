package sooba.search.index;

import java.io.IOException;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import sooba.util.Constant;


public class DelDocumentFromIndex {
		
	public static Directory dir=null;
	public static IndexReader reader=null;
	
	@Test
	public static int delDocumnentById(String field,String [] strs){
//	public void delDocumnentById(){
//		String field="id";	
//		String [] strs={"0","1"};
		try {
			dir = FSDirectory.getDirectory(Constant.indexDir);
			IndexReader reader=IndexReader.open(dir);
			for(String id:strs){
				System.out.println(reader.numDocs()+"-----------"+id);
				reader.deleteDocuments(new Term(field,id));
//				reader.deleteDocument(0);
				System.out.println(reader.numDocs());
			}
			reader.close();
			dir.close();
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}


}
