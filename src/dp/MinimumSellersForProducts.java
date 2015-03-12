package dp;

import java.util.Arrays;
import java.util.HashSet;

/**
 * http://www.careercup.com/question?id=5752825168527360
 * 
 * Use dp
 * 	minimumSellers(P1, P2) = minimimSellers(P1) + those who give P2 
 *   
 */
public class MinimumSellersForProducts {

	public static class Seller {
		
		String id_;
		HashSet<Product> products_;
		
		public Seller(String id) {
			id_ = id;
			products_ = new HashSet<Product>();
		}
		
		public String name() {
			return id_;
		}
		
		public String toString() {
			return id_;
		}
		
	}
	
	public static class Product {
		
		String id_;
		
		public Product(String id) {
			id_ = id;
		}
		
		public String name() {
			return id_;
		}
		
	}
	
	private static HashSet<Seller> getMinimumSellers(HashSet<Product> prods, HashSet<Seller> sellers) {
		
		HashSet<HashSet<Seller>> hs = new HashSet<HashSet<Seller>>();
		for(Product p : prods) {
			System.out.println(p.id_);
			HashSet<HashSet<Seller>> temp = getMinimumSellersHelper(p, hs, sellers);
			hs.clear();
			hs.addAll(temp);
		}
		
		return hs.iterator().next();
		
	}
	
	private static HashSet<HashSet<Seller>> getMinimumSellersHelper(Product p, HashSet<HashSet<Seller>> previousSellers, HashSet<Seller> sellers) {

		//TODO: minimize the space complexity
		HashSet<HashSet<Seller>> temp = new HashSet<HashSet<Seller>>();
		
		if(previousSellers.isEmpty()) {
			for(Seller s : sellers) {
				if(s.products_.contains(p)) { temp.add(new HashSet<Seller>(Arrays.asList(s))); }
			}
			System.out.println(temp.toString());
			return temp;
		}
		
		for(HashSet<Seller> ps : previousSellers) {
			if(!contains(ps, p)) {
				for(Seller s : sellers) {
					if(s.products_.contains(p)) { 
						 HashSet<Seller> local = new HashSet<Seller>(ps);
						 local.add(s);
						 for(HashSet<Seller> t : new HashSet<HashSet<Seller>>(temp)) {
							 if(local.size() < t.size()) {
								 temp.remove(t);
							 }
							 temp.add(local);
						 }
						 System.out.println(local.toString());
					}
				}
			} else {
				temp.add(ps);
				System.out.println(ps.toString());
			}
		}

		return temp;
		
	}
	
	private static boolean contains(HashSet<Seller> ps, Product p) {
		for(Seller s : ps) {
			if(s.products_.contains(p)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		Product p1 = new Product("p1");
		Product p2 = new Product("p2");
		Product p3 = new Product("p3");
		Product p4 = new Product("p4");
		Product p5 = new Product("p5");
		
		Seller s1 = new Seller("s1");
		s1.products_.add(p1);
		s1.products_.add(p2);
		s1.products_.add(p3);
		
		Seller s2 = new Seller("s2");
		s2.products_.add(p2);
		s2.products_.add(p3);
		
		Seller s3 = new Seller("s3");
		s3.products_.add(p1);
		s3.products_.add(p2);
		
		Seller s4 = new Seller("s4");
		s4.products_.add(p1);
		s4.products_.add(p4);
		s4.products_.add(p5);
		
		HashSet<Seller> result = getMinimumSellers(new HashSet<Product>(Arrays.asList(p1, p2, p3, p4, p5)), new HashSet<Seller>(Arrays.asList(s1, s2, s3, s4)));
		System.out.println("Minimum number of Sellers = " + result.size());
		for(Seller s : result) {
			System.out.println(s.name());
		}

	}

}
