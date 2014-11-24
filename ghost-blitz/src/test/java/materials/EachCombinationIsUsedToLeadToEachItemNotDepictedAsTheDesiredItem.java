package materials;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

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
public class EachCombinationIsUsedToLeadToEachItemNotDepictedAsTheDesiredItem {
	Item desiredItem;
	Item item1;
	Item item2;
	
	public EachCombinationIsUsedToLeadToEachItemNotDepictedAsTheDesiredItem(
			Item desiredItem, Item item1, Item item2) {
		this.desiredItem = desiredItem;
		this.item1 = item1;
		this.item2 = item2;
	}



	@Test
	public void thereShouldBeACardShowingItem1AndItem2ForWhichTheDesiredItemIsItem3() {
		Deck deck = new Deck();
		int found = 0;
		while (deck.hasNext()) {
			Card card = deck.draw();
			if (card.depictsItem(item1) && card.depictsItem(item2) 
					&& card.desiredItem() == desiredItem) {
				found++;
			}
		}
		assertThat(found, is(greaterThanOrEqualTo(1)));
	}

	@Parameters
	public static Collection<Object[]> combos() {
		return Arrays.asList(new Object[][] { 
				{ Item.Bottle, Item.Ghost, Item.Chair },
				{ Item.Mouse, Item.Ghost, Item.Chair }
		});
	}


}
