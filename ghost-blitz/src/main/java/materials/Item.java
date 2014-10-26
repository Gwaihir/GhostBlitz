package materials;

public enum Item {
    Ghost (Color.White),
    Chair (Color.Red),
    Bottle (Color.Green),
    Book (Color.Blue),
    Mouse (Color.Grey);
    
    private Color color;
    
	private Item(Color color) {
		this.color = color;
	}

	public Color color() {
		return color;
	}
}
