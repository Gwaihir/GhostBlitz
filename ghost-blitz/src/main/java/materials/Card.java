package materials;

import org.eclipse.jdt.annotation.NonNullByDefault;

@NonNullByDefault
public class Card {

	private Image image1;
	private Image image2;
	private Item desiredItem;

	Card(Image image1, Image image2) {
		if (image1 == null || image2 == null) {
			throw new IllegalArgumentException(
					"Every card should contain two images");
		}
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
