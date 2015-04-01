import java.util.HashMap;


public class TestMain { 
	
	public static class Test {
	
		int i = 1;
		
		@Override
		public int hashCode() {
			return i;
		}
	}
	
    public static void main(String[] args) 
    { 
    	HashMap<Test, Integer> hm = new HashMap<TestMain.Test, Integer>();
    	
    	Test t = new Test();
    	hm.put(t, 1);
    	
    	System.out.println(hm.get(t));
    	
    	t.i = 10;
    	System.out.println(hm.get(t));
    	
    	int n = 1220;
    	int n1 = n&1;
    	System.out.println(n1);
    	
    } 
    
}