package system.bean;

public class Bean {
	private String id;
	private String item;
	private String name;
	private String money;
	private String time;
	private String type;
	
	public Bean(String id, String item, String name, String money, String time, String type) {
		this.item = item;
		this.name = name;
		this.money = money;
		this.time = time;
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}




	public void setItem(String item) {
		this.item = item;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getMoney() {
		return money;
	}




	public void setMoney(String money) {
		this.money = money;
	}




	public String getTime() {
		return time;
	}




	public void setTime(String time) {
		this.time = time;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public Bean() {
		super();
	}
	
}
