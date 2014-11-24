package materials;

import java.util.List;
import java.util.ListIterator;

public class Deck {

	private List<Card> cards;
	private ListIterator<Card> iterator;

	public Deck() {
		cards = new DeckGenerator().generate();
		iterator = cards.listIterator();
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
