package cr.ac.ucr.proyectoiaplicada.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.proyectoiaplicada.data.CategoryData;
import cr.ac.ucr.proyectoiaplicada.domain.Category;

@Service
public class CategoryBusiness {

	@Autowired
	private CategoryData categoryData;
	
	public List<Category> GetAllCategories(){
		return categoryData.GetAllCategories();
	}
}
