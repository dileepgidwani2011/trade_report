package com.jpmc.instructionsettlement.workingdays;

import java.time.LocalDate;

public interface WorkingDay 
{
	public LocalDate findWorkingDay(LocalDate settlementDate);
}
