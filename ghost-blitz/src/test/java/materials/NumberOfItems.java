package materials;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Example (acceptance test)
 */
public class NumberOfItems {

	@Test
	public void thereShouldBe5Items() {
		assertThat(Item.values().length, is(5));
	}

}
