package cr.ac.ucr.proyectoiaplicada.domain;

public class Category {

	private String name;
	private String urlCategory;
	
	public Category() {
		
	}
	
	public Category(String name, String urlCategory) {
		super();
		this.name = name;
		this.urlCategory = urlCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrlCategory() {
		return urlCategory;
	}

	public void setUrlCategory(String urlCategory) {
		this.urlCategory = urlCategory;
	}
	
	
}
