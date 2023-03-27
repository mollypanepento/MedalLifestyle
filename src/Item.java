import java.awt.Image;

import javax.swing.ImageIcon;

public class Item {
	private Image img;
	private String desc;
	private double price;
	private String name;
	private String department;
	
	public Item(String name, Image img, double price, String department, String desc){
		this.name = name;
		this.img = img;
		this.price = price;
		this.desc = desc;
		this.department = department;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
	
	

}
