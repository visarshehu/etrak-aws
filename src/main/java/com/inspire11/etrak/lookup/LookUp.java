package com.inspire11.etrak.lookup;

import java.util.TreeMap;

import org.springframework.stereotype.Component;

@Component
public class LookUp {
	
	TreeMap<String, TreeMap<Integer,Integer>> tm=new TreeMap<String, TreeMap<Integer,Integer>>();
	
	
	public LookUp(){
		
			TreeMap<Integer,Integer> scores=new TreeMap<Integer,Integer>();
			scores.put(0, 1);
			scores.put(64, 2);
			scores.put(71, 3);
			scores.put(78, 4);
			scores.put(85, 5);
			scores.put(92, 6);
			scores.put(99, 7);
			scores.put(106, 8);
			scores.put(113, 9);
			scores.put(120, 10);
			tm.put("DeepSquatHipFlexion",scores);
		
		TreeMap<Integer,Integer> scoresShoulderFlexion=new TreeMap<Integer,Integer>();
		scoresShoulderFlexion.put(0	, 1);
		scoresShoulderFlexion.put(144, 2);
		scoresShoulderFlexion.put(149, 3);
		scoresShoulderFlexion.put(153, 4);
		scoresShoulderFlexion.put(158, 5);
		scoresShoulderFlexion.put(162, 6);
		scoresShoulderFlexion.put(167, 7);
		scoresShoulderFlexion.put(171, 8);
		scoresShoulderFlexion.put(176, 9);
		scoresShoulderFlexion.put(180, 10);
		tm.put("ShoulderFlexion", scoresShoulderFlexion);
		
		TreeMap<Integer,Integer> scoresShoulderExtension=new TreeMap<Integer,Integer>();
		scoresShoulderExtension.put(0, 1);
		scoresShoulderExtension.put(28, 2);
		scoresShoulderExtension.put(33, 3);
		scoresShoulderExtension.put(38, 4);
		scoresShoulderExtension.put(44, 5);
		scoresShoulderExtension.put(49, 6);
		scoresShoulderExtension.put(54, 7);
		scoresShoulderExtension.put(59, 8);
		scoresShoulderExtension.put(65, 9);
		scoresShoulderExtension.put(70, 10);
		tm.put("ShoulderExtension", scoresShoulderExtension);
		
		TreeMap<Integer,Integer> scoresTrunkRotation=new TreeMap<Integer,Integer>();
		scoresTrunkRotation.put(0, 1);
		scoresTrunkRotation.put(14, 2);
		scoresTrunkRotation.put(21, 3);
		scoresTrunkRotation.put(28, 4);
		scoresTrunkRotation.put(35, 5);
		scoresTrunkRotation.put(42, 6);
		scoresTrunkRotation.put(49, 7);
		scoresTrunkRotation.put(56, 8);
		scoresTrunkRotation.put(63, 9);
		scoresTrunkRotation.put(70, 10);
		tm.put("TrunkRotation", scoresTrunkRotation);
		
		TreeMap<Integer,Integer> scoresLowerBody=new TreeMap<Integer,Integer>();
		scoresLowerBody.put(0, 1);
		scoresLowerBody.put(200, 2);
		scoresLowerBody.put(250, 3);
		scoresLowerBody.put(300, 4);
		scoresLowerBody.put(350, 5);
		scoresLowerBody.put(400, 6);
		scoresLowerBody.put(450, 7);
		scoresLowerBody.put(500, 8);
		scoresLowerBody.put(550, 9);
		scoresLowerBody.put(600, 10);
		tm.put("LowerBodyForceMen", scoresLowerBody);
		
		TreeMap<Integer,Integer> scoresLowerBodyWomen=new TreeMap<Integer,Integer>();
		scoresLowerBodyWomen.put(0	, 1);
		scoresLowerBodyWomen.put(160, 2);
		scoresLowerBodyWomen.put(190, 3);
		scoresLowerBodyWomen.put(220, 4);
		scoresLowerBodyWomen.put(250, 5);
		scoresLowerBodyWomen.put(280, 6);
		scoresLowerBodyWomen.put(310, 7);
		scoresLowerBodyWomen.put(340, 8);
		scoresLowerBodyWomen.put(370, 9);
		scoresLowerBodyWomen.put(400, 10);
		tm.put("LowerBodyForceWomen", scoresLowerBodyWomen);
		
		TreeMap<Integer,Integer> scoresPushPull=new TreeMap<Integer,Integer>();
		scoresPushPull.put(0, 1);
		scoresPushPull.put(160, 2);
		scoresPushPull.put(190, 3);
		scoresPushPull.put(220, 4);
		scoresPushPull.put(250, 5);
		scoresPushPull.put(280, 6);
		scoresPushPull.put(310, 7);
		scoresPushPull.put(340, 8);
		scoresPushPull.put(370, 9);
		scoresPushPull.put(400, 10);
		tm.put("PushPullMen", scoresPushPull);
		
		TreeMap<Integer,Integer> scoresPushPullWomen=new TreeMap<Integer,Integer>();
		scoresPushPullWomen.put(0, 1);
		scoresPushPullWomen.put(75, 2);
		scoresPushPullWomen.put(100, 3);
		scoresPushPullWomen.put(125, 4);
		scoresPushPullWomen.put(150, 5);
		scoresPushPullWomen.put(175, 6);
		scoresPushPullWomen.put(200, 7);
		scoresPushPullWomen.put(225, 8);
		scoresPushPullWomen.put(250, 9);
		scoresPushPullWomen.put(275, 10);
		tm.put("PushPullWomen", scoresPushPullWomen);
		
		TreeMap<Integer,Integer> scorevo2=new TreeMap<Integer,Integer>();
		scorevo2.put(0, 1);
		scorevo2.put(20, 2);
		scorevo2.put(25, 3);
		scorevo2.put(30, 4);
		scorevo2.put(35, 5);
		scorevo2.put(40, 6);
		scorevo2.put(45, 7);
		scorevo2.put(50, 8);
		scorevo2.put(55, 9);
		scorevo2.put(60, 10);
		tm.put("VO2", scorevo2);
		
		TreeMap<Integer,Integer> scoresAbsPower=new TreeMap<Integer,Integer>();
		scoresAbsPower.put(0, 1);
		scoresAbsPower.put(108, 2);
		scoresAbsPower.put(144, 3);
		scoresAbsPower.put(180, 4);
		scoresAbsPower.put(216, 5);
		scoresAbsPower.put(252, 6);
		scoresAbsPower.put(288, 7);
		scoresAbsPower.put(324, 8);
		scoresAbsPower.put(360, 9);
		scoresAbsPower.put(400, 10);
		tm.put("AbsolutePower4Min", scoresAbsPower);
		
		TreeMap<Integer,Integer> scoresPowerOutput=new TreeMap<Integer,Integer>();
		scoresPowerOutput.put(0, 1);
		scoresPowerOutput.put(54, 2);
		scoresPowerOutput.put(81, 3);
		scoresPowerOutput.put(108, 4);
		scoresPowerOutput.put(135, 5);
		scoresPowerOutput.put(162, 6);
		scoresPowerOutput.put(189, 7);
		scoresPowerOutput.put(216, 8);
		scoresPowerOutput.put(243, 9);
		scoresPowerOutput.put(300, 10);
		tm.put("PowerOutput4min", scoresPowerOutput);
		
		TreeMap<Integer,Integer> scoresAbsolutePower=new TreeMap<Integer,Integer>();
		scoresAbsolutePower.put(0, 1);
		scoresAbsolutePower.put(300, 2);
		scoresAbsolutePower.put(400, 3);
		scoresAbsolutePower.put(500, 4);
		scoresAbsolutePower.put(600, 5);
		scoresAbsolutePower.put(700, 6);
		scoresAbsolutePower.put(800, 7);
		scoresAbsolutePower.put(900, 8);
		scoresAbsolutePower.put(1000, 9);
		scoresAbsolutePower.put(1100, 10);
		tm.put("AbsolutePowerMen10", scoresAbsolutePower);
		
		TreeMap<Integer,Integer> scoresAbsolutePowerWomen=new TreeMap<Integer,Integer>();
		scoresAbsolutePowerWomen.put(0, 1);
		scoresAbsolutePowerWomen.put(150, 2);
		scoresAbsolutePowerWomen.put(225, 3);
		scoresAbsolutePowerWomen.put(300, 4);
		scoresAbsolutePowerWomen.put(375, 5);
		scoresAbsolutePowerWomen.put(450, 6);
		scoresAbsolutePowerWomen.put(525, 7);
		scoresAbsolutePowerWomen.put(600, 8);
		scoresAbsolutePowerWomen.put(675, 9);
		scoresAbsolutePowerWomen.put(700, 10);
		tm.put("AbsolutePowerWomen10", scoresAbsolutePowerWomen);
		
		TreeMap<Integer,Integer> scoresAbsolute60=new TreeMap<Integer,Integer>();
		scoresAbsolute60.put(0, 1);
		scoresAbsolute60.put(180, 2);
		scoresAbsolute60.put(240, 3);
		scoresAbsolute60.put(300, 4);
		scoresAbsolute60.put(360, 5);
		scoresAbsolute60.put(420, 6);
		scoresAbsolute60.put(480, 7);
		scoresAbsolute60.put(540, 8);
		scoresAbsolute60.put(600, 9);
		scoresAbsolute60.put(660, 10);
		tm.put("AbsolutePowerMen60", scoresAbsolute60);
		
		TreeMap<Integer,Integer> scoresAbsoluteWomen60=new TreeMap<Integer,Integer>();
		scoresAbsoluteWomen60.put(0, 1);
		scoresAbsoluteWomen60.put(90, 2);
		scoresAbsoluteWomen60.put(135, 3);
		scoresAbsoluteWomen60.put(180, 4);
		scoresAbsoluteWomen60.put(225, 5);
		scoresAbsoluteWomen60.put(270, 6);
		scoresAbsoluteWomen60.put(315, 7);
		scoresAbsoluteWomen60.put(360, 8);
		scoresAbsoluteWomen60.put(405, 9);
		scoresAbsoluteWomen60.put(450, 10);
		tm.put("AbsolutePowerWomen60", scoresAbsoluteWomen60);
		
		
		
	}
	 
	public int getScore(String type, int value) {
	
		TreeMap<Integer, Integer> t = new 	TreeMap<Integer, Integer>();
		t = tm.get(type);
		int retValue = t.floorEntry(value).getValue();
		return retValue;
}
	
	
}
