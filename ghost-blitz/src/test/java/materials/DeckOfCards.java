package materials;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Example (acceptance test)
 */
public class DeckOfCards {

	@Test
	public void ThereShouldBeADeckOf80Cards() {
		Deck deck = new Deck();
		assertThat(deck.size(), is(80));
	}

}
