package materials;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Example (acceptance test)
 */
public class ValidCards {

	@Test
	public void GrayMouseInOriginalColorIsDesired() {
		Card card = givenACardForDesiredItemDepicting(Item.Mouse, Item.Mouse, Item.Ghost);
		assertThat(card.getImage(Item.Mouse).color(), is(Color.Gray));
		Color colorOfGhost = card.getImage(Item.Ghost).color();
		assertThat(colorOfGhost, is(not(Color.Gray)));
		assertThat(colorOfGhost, is(not(Color.White)));
	}

	@Test
	public void RedChairInOriginalColorIsDesired() {
		Card card = givenACardForDesiredItemDepicting(Item.Chair, Item.Mouse, Item.Chair);
		assertThat(card.getImage(Item.Chair).color(), is(Color.Red));
		Color colorOfMouse = card.getImage(Item.Mouse).color();
		assertThat(colorOfMouse, is(not(Color.Red)));
		assertThat(colorOfMouse, is(not(Color.Gray)));
	}
	
	@Test
	public void GreenBottleNotDepictedIsDesired() {
		Card card = givenACardForDesiredItemDepicting(Item.Bottle, Item.Mouse, Item.Ghost);
		Color colorOfMouse = card.getImage(Item.Mouse).color();
		Color colorOfGhost = card.getImage(Item.Ghost).color();
		assertThat(colorOfMouse, is(anyOf(is(Color.Blue), is(Color.Red))));
		assertThat(colorOfGhost, is(anyOf(is(Color.Blue), is(Color.Red))));
		assertThat(colorOfMouse, is(not(colorOfGhost)));
	}

	@Test
	public void WhiteGhostNotDepictedIsDesired() {
		Card card = givenACardForDesiredItemDepicting(Item.Ghost, Item.Bottle, Item.Chair);
		Color colorOfBottle = card.getImage(Item.Bottle).color();
		Color colorOfChair = card.getImage(Item.Chair).color();
		assertThat(colorOfBottle, is(anyOf(is(Color.Blue), is(Color.Gray))));
		assertThat(colorOfChair, is(anyOf(is(Color.Blue), is(Color.Gray))));
		assertThat(colorOfBottle, is(not(colorOfChair)));
	}
	
	private Card givenACardForDesiredItemDepicting(Item desiredItem, Item item1, Item item2) {
		Deck deck = new Deck();
		while (deck.hasNext()) {
			Card card = deck.draw();
			if (card.desiredItem() == desiredItem && card.depictsItem(item1) && card.depictsItem(item2)) {
				return card;
			}
		}
		return null;
	}
}
