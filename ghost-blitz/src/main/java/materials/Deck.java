package materials;

import java.util.ArrayList;
import java.util.Arrays;
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

	private void createCardsForItemCombination(Item item1, Item item2) {
		createCardsWithItemDepictedInOriginalColor(item1, item2);
		for (int k = 0; k < 6; k++) {
			cards.add(new Card(Item.Mouse, new Image(item1, Color.Blue),
					new Image(item2, Color.Grey)));
		}
	}

	private void createCardsWithItemDepictedInOriginalColor(Item item1,
			Item item2) {
		cards.add(new Card(item1, new Image(item1, item1.color()),
				new Image(item2, aRandomColorThatIsnt(item1.color(), item2.color()))));
		cards.add(new Card(item2, new Image(item1, aRandomColorThatIsnt(item1.color(), item2.color())),
				new Image(item2, item2.color())));
	}

	private Color aRandomColorThatIsnt(Color... skipColors) {
		ArrayList<Color> colors = new ArrayList<Color>(Arrays.asList(Color.values()));
		for (int i = 0; i < skipColors.length; i++) {
			colors.remove(skipColors[i]);
		}
		return colors.get((int) Math.round(-0.5+ Math.random()*colors.size()));
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
