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

	public Image getImage(Item item) {
		if (image1.item() == item) return image1;
		if (image2.item() == item) return image2;	
		throw new IllegalArgumentException("Item " + item + "not depicted");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + desiredItem.hashCode();
		result = prime * result + image1.hashCode() + image2.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Card)) {
			return false;
		}
		Card other = (Card) obj;
		if (desiredItem != other.desiredItem) {
			return false;
		}
		if (!other.depictsItem(image1.item())) {
			return false;
		}
		if (!other.getImage(image1.item()).equals(image1)) {
			return false;
		}
		if (!other.depictsItem(image2.item())) {
			return false;
		}
		if (!other.getImage(image2.item()).equals(image2)) {
			return false;
		}
		return true;
	}

	
	
}
