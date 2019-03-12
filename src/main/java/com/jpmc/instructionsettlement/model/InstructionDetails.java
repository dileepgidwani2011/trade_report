package com.jpmc.instructionsettlement.model;

import java.math.BigDecimal;
import java.util.Currency;

public class InstructionDetails 
{
	private final BigDecimal agreedFx;
	private final int units;
	private final BigDecimal pricePerUnit;

	public InstructionDetails(BigDecimal agreedFx, int units, BigDecimal pricePerUnit) {
		this.agreedFx = agreedFx;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
	}

	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	public int getUnits() {
		return units;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}
	
	
	
	

}
