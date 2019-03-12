package com.jpmc.instructionsettlement.workingdays;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

abstract class WorkingDayImpl implements WorkingDay
{
	public Map<DayOfWeek, Boolean> workingDaysMap;

	public LocalDate findWorkingDay(LocalDate settlementDate) {
        DayOfWeek day = settlementDate.getDayOfWeek();
		
		if(workingDaysMap.get(day))
		{
			return settlementDate;
		}
		else
		{
			return findWorkingDay(settlementDate.plusDays(1));
		}
	}

}
