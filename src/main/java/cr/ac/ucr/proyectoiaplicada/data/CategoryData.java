package cr.ac.ucr.proyectoiaplicada.data;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cr.ac.ucr.proyectoiaplicada.domain.Category;

@Repository
public class CategoryData {
	
	public List<Category> GetAllCategories(){
		LinkedList<Category> categoryList= new LinkedList<>();
		
		for(int i=0;i<=5;i++) {
			Category category = new Category("Category"+i,"XXX");
			categoryList.add(category);
		}
		
		return categoryList;
	}
}
