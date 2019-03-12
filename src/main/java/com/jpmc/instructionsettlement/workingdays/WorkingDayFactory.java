package com.jpmc.instructionsettlement.workingdays;

import java.util.Currency;

public class WorkingDayFactory 
{
	public static WorkingDay getWorkingDay(Currency currency)
	{
		if (currency.getCurrencyCode().equals("AED") || currency.getCurrencyCode().equals("SAR") )
		{
			return ArabicWorkingDays.getInstance();
		}
		else
		{
			return EnglishWorkingDays.getInstance();
		}
	}

}
