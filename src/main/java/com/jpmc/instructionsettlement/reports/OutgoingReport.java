package com.jpmc.instructionsettlement.reports;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.jpmc.instructionsettlement.model.Instruction;
import com.jpmc.instructionsettlement.model.TradeAction;

public class OutgoingReport implements InstructionReport 
{
	private static Predicate<Instruction> outgoingPredicate = instruction -> instruction.getTradeAction().equals(TradeAction.BUY);

	@Override
	public void printSettlementReport(Map<LocalDate, BigDecimal> settlementMap) {
		System.out.println("********** Outgoing Settlement Report ************");
		System.out.println("Date, Trade Amount");
		settlementMap.forEach((k,v) -> System.out.println(k + ", " + v));
		
	}

	@Override
	public void printRankingReport(Map<String, BigDecimal> settlementMap) {
		
		System.out.println("********** Outgoing Ranking Report ************");
		System.out.println("Entity, Trade Amount");
		
		settlementMap.entrySet().stream().sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed())
        .forEach(k -> System.out.println(k.getKey() + ", " + k.getValue()));
		
	}
	
	public Map<LocalDate, BigDecimal> calculateOutgoingSettlementReport(Set<Instruction> instrunctions)
	{
		return calculateSettlementReport(instrunctions, outgoingPredicate);
	}
	
	public Map<String, BigDecimal> calculateOutgoingRankingReport(Set<Instruction> instrunctions)
	{
		return calculateRankingReport(instrunctions, outgoingPredicate);
	}
	
	

}
