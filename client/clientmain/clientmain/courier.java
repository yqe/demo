package clientmain;

import static org.junit.Assert.*;

import org.junit.Test;

import documentbl.Diliverdocu;
import po.DiliverDocuPO;

public class courier {

	@Test
	public void test() {
//		Goodsdocu godo=new Goodsdocu();
		Diliverdocu dido=new Diliverdocu(null,null);
		boolean bo=dido.BuildDiliverDocu(new DiliverDocuPO("ww", "2015-11-24", "张三", "李四"));
		assertEquals(true,bo);
		
	}

}
