package cr.ac.ucr.proyectoiaplicada.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.proyectoiaplicada.data.ProductData;
import cr.ac.ucr.proyectoiaplicada.domain.Product;

@Service
public class ProductBusiness {

	@Autowired
	private ProductData productData;
	
	public List<Product> GetAllProducts(){
		return productData.GetAllProducts();
	}
}
