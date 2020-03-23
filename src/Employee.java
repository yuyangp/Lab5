
public class Employee {
	private String name;
	private int type;
	private int hours;
	private double sales;
	private double rate;
	private double weeklypay;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		this.sales = sales;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getWeeklypay() {
		return weeklypay;
	}
	public void setWeeklypay(double weeklypay) {
		this.weeklypay = weeklypay;
	}
	public Employee(String name, int type, int hours, double sales, double rate, double weeklypay) {
		super();
		this.name = name;
		this.type = type;
		this.hours = hours;
		this.sales = sales;
		this.rate = rate;
		this.weeklypay = weeklypay;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
}
