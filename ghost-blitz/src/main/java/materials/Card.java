package materials;

import org.eclipse.jdt.annotation.NonNullByDefault;

@NonNullByDefault
public class Card {

	private final Item desiredItem;
	private final Image image1;
	private final Image image2;

	Card(Item desiredItem, Image image1, Image image2) {
		if (desiredItem == null || image1 == null || image2 == null) {
			throw new IllegalArgumentException(
					"Every card should contain two images and lead to a desired item");
		}
		this.desiredItem = desiredItem;
		this.image1 = image1;
		this.image2 = image2;
	}

	public Item desiredItem() {
		return desiredItem;
	}

	public boolean depictsItem(Item item) {
		return image1.item() == item || image2.item() == item;
	}

}
