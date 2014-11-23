package materials;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Deck {

	private List<Card> cards = new ArrayList<Card>();
	private ListIterator<Card> iterator;

	public Deck() {
		createCardsForAllItemCombinations();
		iterator = cards.listIterator();
	}

	private void createCardsForAllItemCombinations() {
		Item[] items = Item.values();
		for (int i = 0; i < items.length; i++) {
			for (int j = i + 1; j < items.length; j++) {
				createCardsForItemCombination(items[i], items[j]);
			}
		}
	}

	private void createCardsForItemCombination(Item itemOne, Item itemTwo) {
		for (int k = 0; k < 8; k++) {
			cards.add(new Card(new Image(itemOne, Color.Blue),
					new Image(itemTwo, Color.Grey)));
		}
	}

	public int size() {
		return cards.size();
	}

	public Card draw() {
		return iterator.next();
	}

	public boolean hasNext() {
		return iterator.hasNext();
	}

}
