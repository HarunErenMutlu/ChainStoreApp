package Shopping;
/*
 *Item class and it's getters and setters 
 * 
 * @author Harun Eren Mutlu 270201089
 *
 * */
public class Item {
	private int id;
	private String name;
	private String category;
	
	public Item(int id, String name, String category) {//constructor of class
		
		this.id = id;
		this.category = category;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
