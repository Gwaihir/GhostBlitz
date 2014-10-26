package materials;


public enum Items {
    Ghost (Color.White),
    Chair (Color.Red),
    Bottle (Color.Green),
    Book (Color.Blue),
    Mouse (Color.Grey);
    
    private Color color;
    
	private Items(Color color) {
		this.color = color;
	}

	public Color color() {
		return color;
	}
}
