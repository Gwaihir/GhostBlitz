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
public class EachCombinationIsUsedOnceToLeadToEachDepictedItemAsTheDesiredItem {
	Item desiredItem;
	Item item1;
	Item item2;
	
	public EachCombinationIsUsedOnceToLeadToEachDepictedItemAsTheDesiredItem(
			Item desiredItem, Item item1, Item item2) {
		this.desiredItem = desiredItem;
		this.item1 = item1;
		this.item2 = item2;
	}



	@Test
	public void thereShouldBe1CardShowingItem1AndItem2ForWhichTheDesiredItemIsItem1() {
		Deck deck = new Deck();
		int found = 0;
		while (deck.hasNext()) {
			Card card = deck.draw();
			if (card.depictsItem(item1) && card.depictsItem(item2) && card.desiredItem() == item1) {
				found++;
			}
		}
		assertThat(found, is(1));
	}

	@Parameters
	public static Collection<Object[]> combos() {
		return Arrays.asList(new Object[][] { 
				{ Item.Ghost, Item.Ghost, Item.Chair },
				{ Item.Chair, Item.Chair, Item.Ghost }
		});
	}


}
