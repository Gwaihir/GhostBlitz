package materials;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Example (acceptance test)
 */
public class DeckOfCards {

	@Test
	public void thereShouldBeADeckOf80Cards() {
		Deck deck = new Deck();
		assertThat(deck.size(), is(80));
	}
	
	@Test
	public void allCardsAreDifferent() {
		List<Card> cards = getCards();
		for (int i = 0; i < cards.size(); i++) {
				for (int j = i + 1; j < cards.size(); j++) {
					assertThat(cards.get(i), is(not(equalTo(cards.get(j)))));
				}
			}
		}

	private List<Card> getCards() {
		List<Card> cards = new ArrayList<Card>();
		Deck deck = new Deck();
		while (deck.hasNext()) {
			cards.add(deck.draw());
		}
		return cards;
	}

}
