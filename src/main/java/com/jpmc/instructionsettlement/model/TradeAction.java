package com.jpmc.instructionsettlement.model;

public enum TradeAction 
{
	BUY("B"),
	SELL("S");
	
	String text;
	
	TradeAction(String text)
	{
		this.text = text;
		
	}
	
	public String getText() {
        return this.text;
    }

    public static TradeAction fromString(String text) {
        if (text != null) {
            for (TradeAction tmp : TradeAction.values()) {
                if (text.equalsIgnoreCase(tmp.text)) {
                    return tmp;
                }
            }

            throw new IllegalArgumentException("No enumeration constant with text " + text + " found!");
        } else {
            throw new NullPointerException("Null pointer supplied.");
        }
}

}
