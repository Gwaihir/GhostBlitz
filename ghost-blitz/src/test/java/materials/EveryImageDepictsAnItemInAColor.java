package materials;

import org.junit.Test;

/**
 * Unit test
 */
public class EveryImageDepictsAnItemInAColor {

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateImageWithoutItem() {
		new Image(null, Color.Red);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateImageWithoutColor() throws Exception {
		new Image(Item.Book, null);
	}

}
