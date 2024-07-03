package test;

import java.io.Serializable;

public class Product_elem implements Serializable {
	String[] categoryname ={"الأطباق","الحلويات","بلانر","الخياطة ","الحياكة","الفخار","المناسبات"};
	String name,price,descr,Worker,Type;
	int id;
	private static final long serialVersionUID = 1L;
	//Serializable serialVersionUID = 123456;
	public Product_elem(String name, String price, String descr,String type, String worker, int id) {
		super();
		this.name = name;
		this.price = price;
		this.descr = descr;
		Worker = worker;
		Type = categoryname[Integer.parseInt(type)];
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getWorker() {
		return Worker;
	}
	public void setWorker(String worker) {
		Worker = worker;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
