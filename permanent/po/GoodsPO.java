/**
 * 
 */
/**
 * @author acer-pc
 *
 */
package po;

import java.io.Serializable;

public class GoodsPO implements Serializable{
	String ID,State,Info;
    public GoodsPO(String id) {
		// TODO Auto-generated constructor stub
	}

	public String getState(){
    	return State;
    }
    public String getinfo(){
    	return Info;
    }
	
	
}
