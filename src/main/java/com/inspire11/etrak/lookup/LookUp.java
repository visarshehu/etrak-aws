package com.inspire11.etrak.lookup;
import java.util.TreeMap;


public class LookUp {
	
	TreeMap<String, TreeMap<Integer,Integer>> tm=new TreeMap<String, TreeMap<Integer,Integer>>();
	
	
	public LookUp(){
		
		TreeMap<Integer,Integer> scores=new TreeMap<Integer,Integer>();
		scores.put(0, 1);
		scores.put(160, 1);
		scores.put(190, 1);
		scores.put(220, 1);
		scores.put(250, 1);
		scores.put(280, 1);
		scores.put(310, 1);
		scores.put(340, 1);
		scores.put(370, 1);
		scores.put(400, 1);
		tm.put("DeepSquatHipFlexion",scores);
	}
	 
	public int getScore(String type, int value) {
	
		TreeMap<Integer, Integer> t = new 	TreeMap<Integer, Integer>();
		t = tm.get(type);
		return t.floorEntry(value).getValue();
}
}
