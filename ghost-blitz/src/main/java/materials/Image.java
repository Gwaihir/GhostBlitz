package materials;

import org.eclipse.jdt.annotation.NonNullByDefault;

@NonNullByDefault
public class Image {

	private Item item;
	private Color color;

	public Image(Item item, Color color) {
		if (item == null || color == null) {
			throw new IllegalArgumentException("Every image should depict an item in a color");
		}
		this.item = item;
		this.color = color;
	}

	public Item item() {
		return item;
	}

	public Color color() {
		return color;
	}

}
