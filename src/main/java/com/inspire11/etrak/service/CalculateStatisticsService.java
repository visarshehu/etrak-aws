package com.inspire11.etrak.service;

import java.util.Collection;

public interface CalculateStatisticsService {

	public double[] CalculateStatistics();
	public Double CalculateImprovement(char gender);
	public int[] AverageAge();
	public Double top10(char gender);
	public double activeScore();
	
}
