package com.jpmc.instructionsettlement.workingdays;

import java.time.DayOfWeek;
import java.util.HashMap;

public class EnglishWorkingDays extends WorkingDayImpl
{
	private static WorkingDay instance = null;

	public static WorkingDay getInstance() {
		if (instance != null)
		{
			return instance;
		}
		{
			instance = new EnglishWorkingDays();
			return instance;
		}
	}
	
	private EnglishWorkingDays()
	{
		initWorkingDaysMap();
	}
	
	public void initWorkingDaysMap()
	{
		workingDaysMap = new HashMap<DayOfWeek, Boolean>();
		workingDaysMap.put(DayOfWeek.MONDAY, true);
		workingDaysMap.put(DayOfWeek.TUESDAY, true);
		workingDaysMap.put(DayOfWeek.WEDNESDAY, true);
		workingDaysMap.put(DayOfWeek.THURSDAY, true);
		workingDaysMap.put(DayOfWeek.FRIDAY, true);
		workingDaysMap.put(DayOfWeek.SATURDAY, false);
		workingDaysMap.put(DayOfWeek.SUNDAY, false);
	}

}
