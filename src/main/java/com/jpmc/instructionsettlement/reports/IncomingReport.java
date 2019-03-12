package com.jpmc.instructionsettlement.reports;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import com.jpmc.instructionsettlement.model.Instruction;
import com.jpmc.instructionsettlement.model.TradeAction;

public class IncomingReport implements InstructionReport 
{
	private static Predicate<Instruction> incommingPredicate = instruction -> instruction.getTradeAction().equals(TradeAction.SELL);

	@Override
	public void printSettlementReport(Map<LocalDate, BigDecimal> settlementMap) {
		System.out.println("********** Incoming Settlement Report ************");
		System.out.println("Date, Trade Amount");
		settlementMap.forEach((k,v) -> System.out.println(k + ", " + v));
		
	}

	@Override
	public void printRankingReport(Map<String, BigDecimal> settlementMap) {
		
		System.out.println("********** Incoming Ranking Report ************");
		System.out.println("Entity, Trade Amount");
		
		settlementMap.entrySet().stream().sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed())
		.forEach(k -> System.out.println(k.getKey() + ", " + k.getValue()));
		
	}
	
	public Map<LocalDate, BigDecimal> calculateIncommingSettlementReport(Set<Instruction> instrunctions)
	{
		return calculateSettlementReport(instrunctions, incommingPredicate);
	}
	
	public Map<String, BigDecimal> calculateIncommingRankingReport(Set<Instruction> instrunctions)
	{
		return calculateRankingReport(instrunctions, incommingPredicate);
	}

}
