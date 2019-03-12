package com.jpmc.instructionsettlement.reports;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.jpmc.instructionsettlement.model.Instruction;

public interface InstructionReport 
{
	public void printSettlementReport(Map<LocalDate, BigDecimal> settlementMap);
	public void printRankingReport(Map<String, BigDecimal> settlementMap);
	
	default public Map<LocalDate, BigDecimal> calculateSettlementReport(Set<Instruction> instrunctions, Predicate<Instruction> predicate) 
	{
		return instrunctions.stream().filter(predicate).collect(Collectors.groupingBy(Instruction::getSettlementDate, 
				Collectors.mapping(Instruction::getTradeAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
	}
	
	default public Map<String, BigDecimal> calculateRankingReport(Set<Instruction> instrunctions, Predicate<Instruction> predicate) 
	{
		return instrunctions.stream().filter(predicate).collect(Collectors.groupingBy(Instruction::getEntity, 
				Collectors.mapping(Instruction::getTradeAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
	}

}
