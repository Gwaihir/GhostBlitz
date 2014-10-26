package materials;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class NumberOfItems {

	@Test
	public void thereShouldBe5Items() {
		assertThat(Item.values().length, is(5));
	}

}
