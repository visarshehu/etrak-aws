package com.inspire11.etrak.service;


public interface CalculateStatisticsService {

	public long CalculateStatistics();
	public Double CalculateImprovement(char gender);
	public Double AverageAge();
	public Double top10(char gender);
	
}
