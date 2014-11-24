package materials;

import org.junit.Test;

/**
 * Unit test
 */
public class EveryCardDepictsTwoItemsAndLeadsToADesiredItem {

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithDesiredItemMissing() throws Exception {
		new Card(null, new Image(Item.Mouse, Color.Grey), new Image(Item.Book, Color.Red));
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithFirstImageMissing() throws Exception {
		new Card(Item.Mouse, null, new Image(Item.Book, Color.Red));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithSecondImageMissing() {
		new Card(Item.Mouse, new Image(Item.Book, Color.Red), null);
	}

}
