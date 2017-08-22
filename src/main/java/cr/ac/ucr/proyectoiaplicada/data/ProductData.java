package cr.ac.ucr.proyectoiaplicada.data;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cr.ac.ucr.proyectoiaplicada.domain.Product;

@Repository
public class ProductData {

	public List<Product> GetAllProducts(){
		LinkedList<Product> productList= new LinkedList<>();
		
		for(int i=0;i<=10;i++) {
			Product p= new Product(i,"Product"+i,"Description"+i,
					123,12,"sds","LineaBlanca");
			
			productList.add(p);
		}
		
		return productList;
	}
}
