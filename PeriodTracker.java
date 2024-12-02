package Codes;

import java.time.LocalDate;
import java.util.List;

public interface PeriodTracker {
	
	void addPeriodStart(LocalDate startDate);
	void addPeriodEnd(LocalDate endDate);
	double getAvgCycleLength();
	LocalDate predictNextPeriod();
	List<String> getPeriodHistory();

}
