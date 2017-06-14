package org.coolfitted.coolfittedrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.coolfitted.coolfittedrest.database.CoolFittedDB;
import org.coolfitted.coolfittedrest.model.Hat;

public class HatService {
	
	private static List<Hat> hats = CoolFittedDB.getHats();
	private static List<Hat> newarrivals = CoolFittedDB.getArrHats();
	private static List<Hat> snaphats = CoolFittedDB.getSnapHats();
	private static List<Hat> straphats = CoolFittedDB.getStrapHats();

	public HatService(){
		
	}
	public static List<Hat> getAllHats(){
		return hats;
	}
	
	public static List<Hat> getArrivalHats(){
		return newarrivals;
	}
	
	public static List<Hat> getSnapHats(){
		return snaphats;
	}
	
	public static List<Hat> getStrapHats(){
		return straphats;
	}
	
	public static List<Hat> getHatByName(String hatname){
		List<Hat> hatlist = CoolFittedDB.getHatDetails(hatname);
		return hatlist;
	}
	
	
	
}
