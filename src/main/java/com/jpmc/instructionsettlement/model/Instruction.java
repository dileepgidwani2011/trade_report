package com.jpmc.instructionsettlement.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

public class Instruction 
{
	private final String entity;
	private final TradeAction tradeAction;
	private final InstructionDetails instructionDetails;
	private final LocalDate instructionDate;
	private final Currency currency;
	private LocalDate settlementDate;
	private BigDecimal tradeAmount;
	
	public Instruction(String entity, TradeAction tradeAction, InstructionDetails instrunctionDetails, LocalDate instrunctionDate, LocalDate settlementDate, Currency currency)
	{
		this.entity = entity;
		this.tradeAction = tradeAction;
		this.instructionDetails = instrunctionDetails;
		this.instructionDate = instrunctionDate;
		this.settlementDate = settlementDate;
		this.currency = currency;
	}
	
	
	public Currency getCurrency() {
		return currency;
	}


	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}



	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}



	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getEntity() {
		return entity;
	}

	public TradeAction getTradeAction() {
		return tradeAction;
	}

	public InstructionDetails getInstructionDetails() {
		return instructionDetails;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}
	
	

}
