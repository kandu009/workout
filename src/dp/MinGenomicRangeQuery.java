package dp;



/* Find the minimal nucleotide from a range of sequence DNA.  */
public class MinGenomicRangeQuery {

	public static enum GenomicSequence {
		
		A(1),
		C(2),
		G(3),
		T(4);
		
		int m_value;
		GenomicSequence(int value) {
			m_value = value;
		}

		public static int valueOf(char d) {
			for(GenomicSequence g : GenomicSequence.values()) {
				String temp = new StringBuilder().append(d).toString().toUpperCase();
				if( temp.equals(g.name())) {
					return g.m_value;
				}
			}
			return -1;
		}
	}
	
	public static int getMinGenomicSequenceNumber(String input, int start, int end) {
	
		if(end > input.length()-1) {
			return -1;
		}
		
		int retVal = Integer.MAX_VALUE;
		for(int i = start; i <= end; ++i) {
			int temp = GenomicSequence.valueOf(input.charAt(i));  
			if(temp == -1) {
				return -1;
			}
			retVal = retVal < temp ? retVal : temp;
		}
		return retVal;
		
	}
	
	public static void main(String[] args) {

		String input = "ACAGCCTATAGCGGTCAAC";
		
		int[] P = new int[] {2,5,0};
		int[] Q = new int[] {4,5,6};
		
		System.out.println(getMinGenomicSequenceNumber(input, P[1], Q[2]));
	}

}
