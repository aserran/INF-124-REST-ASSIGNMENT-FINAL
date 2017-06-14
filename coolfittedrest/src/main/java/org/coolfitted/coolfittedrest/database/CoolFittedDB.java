package org.coolfitted.coolfittedrest.database;


import java.util.List;


import org.coolfitted.coolfittedrest.model.Hat;

public class CoolFittedDB {

	//private static List<Hat> hats = DatabaseAccess.getHomeHats();
	public CoolFittedDB(){
		
	}
	public static List<Hat> getHats(){
		List<Hat> hats = DatabaseAccess.getHomeHats();
		return hats;
	}
	
	public static List<Hat> getArrHats(){
		List<Hat> hats = DatabaseAccess.getArrivalHats();
		return hats;
	}
	
	public static List<Hat> getSnapHats(){
		List<Hat> hats = DatabaseAccess.getSnapHats();
		return hats;
	}
	
	public static List<Hat> getStrapHats(){
		List<Hat> hats = DatabaseAccess.getStrapHats();
		return hats;
	}
	public static List<Hat> getHatDetails(String name){
		List<Hat> hatlist = DatabaseAccess.getHatDetails(name);
		return hatlist;
	}	
}
