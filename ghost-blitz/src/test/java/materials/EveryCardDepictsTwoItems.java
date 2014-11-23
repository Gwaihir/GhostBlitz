package materials;

import org.junit.Test;

/**
 * Unit test
 */
public class EveryCardDepictsTwoItems {

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithFirstImageMissing() throws Exception {
		new Card(null, new Image(Item.Book, Color.Red));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateCardWithSecondImageMissing() {
		new Card(new Image(Item.Book, Color.Red), null);
	}

}
