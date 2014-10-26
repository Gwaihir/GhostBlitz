package materials;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class AColorValue {

	@Test
	public void aColorValue() {
		String color = "White";
		assertThat(Color.valueOf(color).toString(), is(color));
	}

}
