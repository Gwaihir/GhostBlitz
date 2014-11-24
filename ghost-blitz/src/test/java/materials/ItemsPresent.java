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
public class ItemsPresent {
	String item;
	String color;
	
	public ItemsPresent(String item, String color) {
		super();
		this.item = item;
		this.color = color;
	}

	@Test
	public void thereShouldBeAnItemWithColor() {
		assertThat(Item.valueOf(item).color().toString(), is(color));
	}
	
	@Parameters
	public static Collection<Object[]> itemsAndTheirColors() {
	      return Arrays.asList(new Object[][] {
	         { "Ghost", "White" },
	         { "Chair", "Red" },
	         { "Bottle", "Green" },
	         { "Book", "Blue" },
	         { "Mouse", "Gray" }
	      });
	}

}
