package materials;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

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
		Set<Card> cards = new HashSet<Card>();
		Deck deck = new Deck();
		while (deck.hasNext()) {
			cards.add(deck.draw());
		}
		assertThat(cards.size(), is(80));
	}

}
