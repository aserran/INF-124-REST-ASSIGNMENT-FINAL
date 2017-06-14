package org.coolfitted.coolfittedclient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hat {
	
	private String imagepath;
	private String imagename;
	private String imagetitle;
	private String imageprice;
	private String imagedetails;
	
	
	public Hat(){
		
	}
	
	public Hat(String path, String name, String title, String price, String details){
		this.imagepath = path;
		this.imagename = name;
		this.imagetitle = title;
		this.imageprice = price;
		this.imagedetails = details;
	}
	
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getImagedetails() {
		return imagedetails;
	}
	public void setImagedetails(String imagedetails) {
		this.imagedetails = imagedetails;
	}
	public String getImageprice() {
		return imageprice;
	}
	public void setImageprice(String imageprice) {
		this.imageprice = imageprice;
	}
	public String getImagetitle() {
		return imagetitle;
	}
	public void setImagetitle(String imagetitle) {
		this.imagetitle = imagetitle;
	}
}
