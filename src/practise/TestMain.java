package practise;

public class TestMain { 
	
	public static void printCharacterPattern( int num ){  
	      int i , j , value = 1;
	      char ch = 'a';
	      char print;
	      for( i = 0 ; i < num ; i ++ ){
	        print = ch;
	        for( j = 0 ; j <= i ; j ++ )
	          System.out.print( ( ch ++ ) ) ;
	        System.out.println( "" );
	        ch = print;
	      }   
	  }
	
    public static void main(String[] args) 
    { 
    	printCharacterPattern(10);
    } 
    
}