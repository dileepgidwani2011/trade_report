package com.jpmc.instructionsettlement.Processor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import com.jpmc.instructionsettlement.model.Instruction;
import com.jpmc.instructionsettlement.model.InstructionDetails;
import com.jpmc.instructionsettlement.workingdays.WorkingDay;
import com.jpmc.instructionsettlement.workingdays.WorkingDayFactory;

public class ProcessInstrunctions 
{
	
	public static Set<Instruction> process(Set<Instruction> instructions)
	{
		instructions.stream().forEach(p -> updateSettlementDate(p));
		return instructions;
	}
	
	public static void updateSettlementDate(Instruction instruction)
	{
		WorkingDay workingDay = WorkingDayFactory.getWorkingDay(instruction.getCurrency());
		LocalDate settlementDate = workingDay.findWorkingDay(instruction.getSettlementDate());
		instruction.setSettlementDate(settlementDate);
		
		InstructionDetails instructionDetails = instruction.getInstructionDetails();
		
		BigDecimal tradeAmount = instructionDetails.getAgreedFx().multiply(BigDecimal.valueOf(instructionDetails.getUnits()))
				.multiply(instructionDetails.getPricePerUnit());
		instruction.setTradeAmount(tradeAmount);
		
	}

}
