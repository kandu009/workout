package google;

import java.util.ArrayList;

/**
 * http://www.careercup.com/question?id=5736766531174400
 * 
 * Brute force approach, try out all possible combinations and choose best
 * price.
 * 
 * for each item to be bought, get the list of combo's then get the rest of the
 * items in the other combos.
 * 
 * When all the items are bought, we will see the total price of the comboList
 * and update minCombo if the price is lower than minimum
 * 
 * @author rkandur
 *
 */
public class FindMinimumCostForItems {

	public static class ItemCombo {
		
		int price_;
		ArrayList<String> items_;
		
		public ItemCombo(int id) {
			price_ = id;
			items_ = new ArrayList<String>();
		}
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<ItemCombo> comboList =  new ArrayList<ItemCombo>();
		ItemCombo c1 = new ItemCombo(5);
		c1.items_.add("burger");
		
		ItemCombo c2 = new ItemCombo(4);
		c2.items_.add("french_fries");
		
		ItemCombo c3 = new ItemCombo(8);
		c3.items_.add("colddrink");
		
		ItemCombo c4 = new ItemCombo(12);
		c4.items_.add("burger");
		c4.items_.add("colddrink");
		c4.items_.add("french_fries");
		
		ItemCombo c5 = new ItemCombo(14);
		c5.items_.add("burger");
		c5.items_.add("colddrink");
		
		comboList.add(c1);
		comboList.add(c2);
		comboList.add(c3);
		comboList.add(c4);
		comboList.add(c5);

		ArrayList<String> toBuy = new ArrayList<String>();
		toBuy.add("burger");
//		toBuy.add("colddrink");
		toBuy.add("french_fries");
		
		ArrayList<ItemCombo> list = getItemsWithMinimumPrice(comboList, toBuy, 
										new ArrayList<FindMinimumCostForItems.ItemCombo>());
		for(ItemCombo l : list) {
			System.out.println(l.price_ + " " + l.items_.toString());
		}
		
	}

	private static ArrayList<ItemCombo> getComboListWithFirstItem(ArrayList<ItemCombo> comboList, String item) {
		ArrayList<ItemCombo> result = new ArrayList<FindMinimumCostForItems.ItemCombo>();
		for(ItemCombo c: comboList) {
			if(c.items_.contains(item)) {
				result.add(c);
			}
		}
		return result;
	}
	
	private static ArrayList<ItemCombo> getItemsWithMinimumPrice(
			ArrayList<ItemCombo> comboList, ArrayList<String> itemsToBuy, ArrayList<ItemCombo> combosBought) {

		if(itemsToBuy.isEmpty()) {
			return combosBought;
		}
		
		ArrayList<ItemCombo> firstComboList = getComboListWithFirstItem(comboList, itemsToBuy.get(0));
		
		Integer bestPrice = Integer.MAX_VALUE;
		ArrayList<ItemCombo> bestCombo = new ArrayList<FindMinimumCostForItems.ItemCombo>();
		
		for(ItemCombo c : firstComboList) {
		
			ArrayList<String> toBuyCopy = new ArrayList<String>(itemsToBuy);
			for(String item : c.items_) {
				toBuyCopy.remove(item);
			}
			ArrayList<ItemCombo> combosBoughtCopy = new ArrayList<FindMinimumCostForItems.ItemCombo>(combosBought);
			combosBoughtCopy.add(c);
			ArrayList<ItemCombo> list = getItemsWithMinimumPrice(comboList, toBuyCopy, combosBoughtCopy);
			
			int listPrice = priceOf(list);
			if( listPrice < bestPrice) {
				bestPrice = listPrice;
				bestCombo.clear();
				bestCombo.addAll(list);
			}
			
		}
		
		return bestCombo;
	}

	private static int priceOf(ArrayList<ItemCombo> list) {
		int price = 0;
		for(ItemCombo i : list) {
			price += i.price_;
		}
		return price;
	}

}
