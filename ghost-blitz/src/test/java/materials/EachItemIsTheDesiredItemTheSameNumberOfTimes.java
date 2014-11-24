package materials;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Example (acceptance test)
 */
@RunWith(Parameterized.class)
public class EachItemIsTheDesiredItemTheSameNumberOfTimes {
	Item desiredItem;

	public EachItemIsTheDesiredItemTheSameNumberOfTimes(Item desiredItem) {
		this.desiredItem = desiredItem;
	}

	@Test
	public void thereShouldBe16CardsForEachDesiredItem() {
		Deck deck = new Deck();
		int found = 0;
		while (deck.hasNext()) {
			Card card = deck.draw();
			if (card.desiredItem() == desiredItem) {
				found++;
			}
		}
		assertThat(found, is(16));

	}

	@Parameters
	public static Collection<Object[]> combos() {
		return Arrays.asList(new Object[][] { 
				{ Item.Ghost },
				{ Item.Chair }
		});
	}

}
