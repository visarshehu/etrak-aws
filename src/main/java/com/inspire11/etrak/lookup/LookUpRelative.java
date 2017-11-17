package com.inspire11.etrak.lookup;

import java.util.TreeMap;

import org.springframework.stereotype.Component;


@Component
public class LookUpRelative {
	TreeMap<String, TreeMap<Double, Integer>> relative = new TreeMap<String, TreeMap<Double, Integer>>();

	public LookUpRelative() {

		TreeMap<Double, Integer> scores = new TreeMap<Double, Integer>();
		scores.put(0.00, 1);
		scores.put(0.40, 2);
		scores.put(0.60, 3);
		scores.put(0.80, 4);
		scores.put(1.00, 5);
		scores.put(1.20, 6);
		scores.put(1.40, 7);
		scores.put(1.60, 8);
		scores.put(1.80, 9);
		scores.put(2.00, 10);
		relative.put("PowerRatio", scores);

		TreeMap<Double, Integer> lowerRelative = new TreeMap<Double, Integer>();
		lowerRelative.put(0.00, 1);
		lowerRelative.put(0.90, 2);
		lowerRelative.put(1.10, 3);
		lowerRelative.put(1.30, 4);
		lowerRelative.put(1.50, 5);
		lowerRelative.put(1.70, 6);
		lowerRelative.put(1.90, 7);
		lowerRelative.put(2.10, 8);
		lowerRelative.put(2.30, 9);
		lowerRelative.put(2.50, 10);
		relative.put("LowerRelativeForce", lowerRelative);

		TreeMap<Double, Integer> lowerRelativeWomen = new TreeMap<Double, Integer>();
		lowerRelativeWomen.put(0.00, 1);
		lowerRelativeWomen.put(0.40, 2);
		lowerRelativeWomen.put(0.60, 3);
		lowerRelativeWomen.put(0.80, 4);
		lowerRelativeWomen.put(1.00, 5);
		lowerRelativeWomen.put(1.20, 6);
		lowerRelativeWomen.put(1.40, 7);
		lowerRelativeWomen.put(1.60, 8);
		lowerRelativeWomen.put(1.80, 9);
		lowerRelativeWomen.put(2.00, 10);
		relative.put("LowerRelativeWomen", lowerRelativeWomen);

		TreeMap<Double, Integer> pushpull = new TreeMap<Double, Integer>();
		pushpull.put(0.00, 1);
		pushpull.put(0.90, 2);
		pushpull.put(1.00, 3);
		pushpull.put(1.10, 4);
		pushpull.put(1.20, 5);
		pushpull.put(1.30, 6);
		pushpull.put(1.40, 7);
		pushpull.put(1.50, 8);
		pushpull.put(1.60, 9);
		pushpull.put(1.70, 10);
		relative.put("PushPullRelative", pushpull);

		TreeMap<Double, Integer> pushpullWomen = new TreeMap<Double, Integer>();
		pushpullWomen.put(0.00, 1);
		pushpullWomen.put(0.30, 2);
		pushpullWomen.put(0.45, 3);
		pushpullWomen.put(0.60, 4);
		pushpullWomen.put(0.75, 5);
		pushpullWomen.put(0.92, 6);
		pushpullWomen.put(1.05, 7);
		pushpullWomen.put(1.20, 8);
		pushpullWomen.put(1.35, 9);
		pushpullWomen.put(1.50, 10);
		relative.put("PushPullWomenRelative", pushpullWomen);

		TreeMap<Double, Integer> peakrelative = new TreeMap<Double, Integer>();
		peakrelative.put(0.00, 1);
		peakrelative.put(4.00, 2);
		peakrelative.put(6.00, 3);
		peakrelative.put(8.00, 4);
		peakrelative.put(10.00, 5);
		peakrelative.put(12.00, 6);
		peakrelative.put(14.00, 7);
		peakrelative.put(16.00, 8);
		peakrelative.put(18.00, 9);
		peakrelative.put(20.00, 10);
		relative.put("PeakRelative", peakrelative);
		
		TreeMap<Double, Integer> min4RelativeMen = new TreeMap<Double, Integer>();
		peakrelative.put(0.00, 1);
		peakrelative.put(1.19, 2);
		peakrelative.put(1.63, 3);
		peakrelative.put(2.07, 4);
		peakrelative.put(2.52, 5);
		peakrelative.put(2.96, 6);
		peakrelative.put(3.41, 7);
		peakrelative.put(3.85, 8);
		peakrelative.put(4.30, 9);
		peakrelative.put(4.75, 10);
		relative.put("min4RelativeMen", min4RelativeMen);
		
		TreeMap<Double, Integer> min4RelativeWomen = new TreeMap<Double, Integer>();
		peakrelative.put(0.00, 1);
		peakrelative.put(1.04, 2);
		peakrelative.put(1.43, 3);
		peakrelative.put(1.82, 4);
		peakrelative.put(2.22, 5);
		peakrelative.put(2.61, 6);
		peakrelative.put(3.00, 7);
		peakrelative.put(3.39, 8);
		peakrelative.put(3.78, 9);
		peakrelative.put(4.18, 10);
		relative.put("min4RelativeWomen", min4RelativeWomen);

		TreeMap<Double, Integer> peakrelativeMen = new TreeMap<Double, Integer>();
		peakrelativeMen.put(0.00, 1);
		peakrelativeMen.put(1.25, 2);
		peakrelativeMen.put(1.75, 3);
		peakrelativeMen.put(2.25, 4);
		peakrelativeMen.put(2.75, 5);
		peakrelativeMen.put(3.25, 6);
		peakrelativeMen.put(3.75, 7);
		peakrelativeMen.put(4.25, 8);
		peakrelativeMen.put(4.75, 9);
		peakrelativeMen.put(5.25, 10);
		relative.put("PeakRelativeMen60", peakrelativeMen);

		TreeMap<Double, Integer> peakRelativeWomen = new TreeMap<Double, Integer>();
		peakRelativeWomen.put(0.00, 1);
		peakRelativeWomen.put(1.00, 2);
		peakRelativeWomen.put(1.25, 3);
		peakRelativeWomen.put(1.50, 4);
		peakRelativeWomen.put(1.75, 5);
		peakRelativeWomen.put(2.00, 6);
		peakRelativeWomen.put(2.25, 7);
		peakRelativeWomen.put(2.50, 8);
		peakRelativeWomen.put(2.75, 9);
		peakRelativeWomen.put(3.00, 10);
		relative.put("PeakRelativeWomen60", peakRelativeWomen);
		
		TreeMap<Double, Integer> s10women = new TreeMap<Double, Integer>();
		s10women.put(0.00, 1);
		s10women.put(1.00, 2);
		s10women.put(1.40, 3);
		s10women.put(1.80, 4);
		s10women.put(2.20, 5);
		s10women.put(2.60, 6);
		s10women.put(3.00, 7);
		s10women.put(3.40, 8);
		s10women.put(3.80, 9);
		s10women.put(4.20, 10);
		relative.put("s10RelativePowerWomen", s10women);
		
		TreeMap<Double, Integer> s60women = new TreeMap<Double, Integer>();
		s60women.put(0.00, 1);
		s60women.put(1.02, 2);
		s60women.put(1.25, 3);
		s60women.put(1.50, 4);
		s60women.put(1.75, 5);
		s60women.put(2.00, 6);
		s60women.put(2.25, 7);
		s60women.put(2.50, 8);
		s60women.put(2.75, 9);
		s60women.put(3.00, 10);
		relative.put("s60RelativePowerWomen", s60women);
		
		TreeMap<Double, Integer> s10men = new TreeMap<Double, Integer>();
		s10men.put(0.00, 1);
		s10men.put(1.25, 2);
		s10men.put(1.75, 3);
		s10men.put(2.25, 4);
		s10men.put(2.75, 5);
		s10men.put(3.25, 6);
		s10men.put(3.75, 7);
		s10men.put(4.25, 8);
		s10men.put(4.75, 9);
		s10men.put(5.25, 10);
		relative.put("s10RelativePowerMen", s10men);
		
		TreeMap<Double, Integer> s60men = new TreeMap<Double, Integer>();
		s60men.put(0.00, 1);
		s60men.put(1.25, 2);
		s60men.put(1.75, 3);
		s60men.put(2.25, 4);
		s60men.put(2.75, 5);
		s60men.put(3.25, 6);
		s60men.put(3.75, 7);
		s60men.put(4.25, 8);
		s60men.put(4.75, 9);
		s60men.put(5.25, 10);
		relative.put("s60RelativePowerMen", s60men);
		
		TreeMap<Double, Integer> s10womenMetric = new TreeMap<Double, Integer>();
		s10women.put(0.00, 1);
		s10women.put(1.60, 2);
		s10women.put(2.60, 3);
		s10women.put(3.60, 4);
		s10women.put(4.60, 5);
		s10women.put(5.60, 6);
		s10women.put(6.60, 7);
		s10women.put(7.60, 8);
		s10women.put(8.60, 9);
		s10women.put(9.60, 10);
		relative.put("s10RelativePowerWomenMetric", s10womenMetric);
		
		TreeMap<Double, Integer> s60womenMetric = new TreeMap<Double, Integer>();
		s60women.put(0.00, 1);
		s60women.put(1.32, 2);
		s60women.put(1.82, 3);
		s60women.put(2.31, 4);
		s60women.put(2.81, 5);
		s60women.put(3.30, 6);
		s60women.put(3.80, 7);
		s60women.put(4.29, 8);
		s60women.put(4.79, 9);
		s60women.put(5.28, 10);
		relative.put("s60RelativePowerWomenMetric", s60womenMetric);
		
		TreeMap<Double, Integer> s10menMetric = new TreeMap<Double, Integer>();
		s10men.put(0.00, 1);
		s10men.put(2.00, 2);
		s10men.put(3.25, 3);
		s10men.put(4.50, 4);
		s10men.put(5.75, 5);
		s10men.put(7.00, 6);
		s10men.put(8.25, 7);
		s10men.put(9.50, 8);
		s10men.put(10.75, 9);
		s10men.put(12.00, 10);
		relative.put("s10RelativePowerMenMetric", s10menMetric);
		
		TreeMap<Double, Integer> s60menMetric = new TreeMap<Double, Integer>();
		s60men.put(0.00, 1);
		s60men.put(1.50, 2);
		s60men.put(2.06, 3);
		s60men.put(2.63, 4);
		s60men.put(3.19, 5);
		s60men.put(3.75, 6);
		s60men.put(4.31, 7);
		s60men.put(4.88, 8);
		s60men.put(5.44, 9);
		s60men.put(6.00, 10);
		relative.put("s60RelativePowerMenMetric", s60menMetric);

	}

	public int getScore(String type, double value) {

		TreeMap<Double, Integer> t = new TreeMap<Double, Integer>();
		t = relative.get(type);
		return t.floorEntry(value).getValue();
	}
}
