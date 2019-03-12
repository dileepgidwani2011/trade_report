package com.jpmc.instructionsettlement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

import com.jpmc.instructionsettlement.Processor.ProcessInstrunctions;
import com.jpmc.instructionsettlement.model.Instruction;
import com.jpmc.instructionsettlement.model.InstructionDetails;
import com.jpmc.instructionsettlement.model.TradeAction;
import com.jpmc.instructionsettlement.reports.IncomingReport;
import com.jpmc.instructionsettlement.reports.OutgoingReport;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Set<Instruction> instructions = new HashSet<>(Arrays.asList(
                new Instruction(
                    "foo",
                    TradeAction.BUY,
                    new InstructionDetails(
                            BigDecimal.valueOf(0.50),
                            200,
                            BigDecimal.valueOf(100.25)),
                    LocalDate.of(2019, 3, 1),
                    LocalDate.of(2019, 3, 2),
                    Currency.getInstance("SGD")),
                new Instruction(
                        "bar",
                        TradeAction.BUY,
                        new InstructionDetails(
                                BigDecimal.valueOf(0.22),
                                450,
                                BigDecimal.valueOf(150.5)),
                        LocalDate.of(2019, 3, 1),
                        LocalDate.of(2019, 3, 2),
                        Currency.getInstance("AED")),
                new Instruction(
                        "foo",
                        TradeAction.SELL,
                        new InstructionDetails(
                                BigDecimal.valueOf(0.27),
                                150,
                                BigDecimal.valueOf(400.8)),
                        LocalDate.of(2019, 3, 2),
                        LocalDate.of(2019, 3, 4),
                        Currency.getInstance("SAR")),
                new Instruction(
                        "bar",
                        TradeAction.SELL,
                        new InstructionDetails(
                                BigDecimal.valueOf(0.34),
                                20,
                                BigDecimal.valueOf(40.6)),
                        LocalDate.of(2019, 3, 5),
		                LocalDate.of(2019, 3, 7),
                        Currency.getInstance("EUR")),
                new Instruction(
                        "test",
                        TradeAction.BUY,
                        new InstructionDetails(
                                BigDecimal.valueOf(0.34),
                                20,
                                BigDecimal.valueOf(40.6)),
                        LocalDate.of(2019, 3, 5),
                        LocalDate.of(2019, 3, 7),
                        Currency.getInstance("EUR")),
                new Instruction(
                        "test",
                        TradeAction.SELL,
                        new InstructionDetails(
                                BigDecimal.valueOf(0.34),
                            1000,
                                BigDecimal.valueOf(160.6)),
                        LocalDate.of(2019, 3, 7),
                        LocalDate.of(2019, 3, 8),
                        Currency.getInstance("EUR")),
                new Instruction(
                        "foo",
                        TradeAction.SELL,
                        new InstructionDetails(
                                BigDecimal.valueOf(0.34),
                            120,
                                BigDecimal.valueOf(500.6)),
                        LocalDate.of(2019, 3, 7),
                        LocalDate.of(2019, 3, 8),
                        Currency.getInstance("EUR"))));
        
        ProcessInstrunctions.process(instructions);
        
        OutgoingReport outgoingReport = new OutgoingReport();
        outgoingReport.printSettlementReport(outgoingReport.calculateOutgoingSettlementReport(instructions));
        outgoingReport.printRankingReport(outgoingReport.calculateOutgoingRankingReport(instructions));
        
        IncomingReport incomingReport = new IncomingReport();
        incomingReport.printSettlementReport(incomingReport.calculateIncommingSettlementReport(instructions));
        incomingReport.printRankingReport(incomingReport.calculateIncommingRankingReport(instructions));
        
        
        
    }
}
