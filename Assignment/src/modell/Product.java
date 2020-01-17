package modell;

public class Product {
	private String pid;
	private String pname;
	private int msq;
	private int price;
	public Product() {
		//super();
		this.pid = pid;
		this.pname = pname;
		this.msq = msq;
		this.price = price;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getMsq() {
		return msq;
	}
	public void setMsq(int msq) {
		this.msq = msq;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	void display()
	{
		System.out.println("ProductID"+this.pid);
		System.out.println("ProductName"+this.pname);
		System.out.println("ProductMinSellQuantity"+this.msq);
		System.out.println("ProductPrice"+this.price);
		
	}

}
