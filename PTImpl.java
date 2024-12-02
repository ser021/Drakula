package Codes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PTImpl implements PeriodTracker {
	
	private List<LocalDate> periodStartDates;
	private List<LocalDate> periodEndDates;
	
	public PTImpl() {
		periodStartDates = new ArrayList<>();
		periodEndDates = new ArrayList<>();
	}
	
	@Override
	public void addPeriodStart(LocalDate startDate) {
		periodStartDates.add(startDate);
	}
	
	@Override
	public void addPeriodEnd(LocalDate endDate) {
		periodEndDates.add(endDate);
	}
	
	@Override
	public double getAvgCycleLength() {
		if(periodStartDates.size() < 2) return 0;
		long totalDays = 0;
		for (int i = 1; i < periodStartDates.size(); i++) {
			totalDays += ChronoUnit.DAYS.between(periodStartDates.get(i - 1), periodStartDates.get(i));
		}
		return (double) totalDays / (periodStartDates.size() - 1);
	}
	
	@Override
	public LocalDate predictNextPeriod() {
		if(periodStartDates.isEmpty()) return null;
		LocalDate lastPeriod = periodStartDates.get(periodStartDates.size()-1);
		double avgCycleLength = getAvgCycleLength();
		return lastPeriod.plusDays((long) avgCycleLength);
	}
	
	@Override
	public List<String> getPeriodHistory(){
		List<String> history = new ArrayList<>();
		int size = Math.min(periodStartDates.size(), periodEndDates.size());
		
		for (int i = 0; i < size; i++) {
			String period = periodStartDates.get(i) + " - " + periodEndDates.get(i);
			history.add(period);
		}
		
		return history;
	}

}
