package cr.ac.ucr.proyectoiaplicada.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cr.ac.ucr.proyectoiaplicada.business.CategoryBusiness;
import cr.ac.ucr.proyectoiaplicada.business.ProductBusiness;
import cr.ac.ucr.proyectoiaplicada.domain.Category;
import cr.ac.ucr.proyectoiaplicada.domain.Product;

@Controller
public class ListController {
    
	@Autowired
	private ProductBusiness productBusiness;
	@Autowired
	private CategoryBusiness categoryBusiness;
	
	private List<Product> productList;
	private List<Category> categoryList;
	
	private PagedList paged;//instancia de la clase que permite realizar la paginacion

	private int pagActual = 0;//pagina actual en la paginacion
	private int quantity = 0;//elementos totales que retorna el web services
	private final int ELEM_PAGES = 5; // elementos visibles por cada pagina

	String criterioBusqueda = "";
	
	@RequestMapping(value = {"/List"},method = RequestMethod.GET)
    public String runList(Model model) {
		
		
//		criterioBusqueda = (String) request.getParameter("search");

		productList = productBusiness.GetAllProducts();
		categoryList= categoryBusiness.GetAllCategories();
		
		pagActual = 0; // reinicia la pagina visible actual a 0
		paged = new PagedList(ELEM_PAGES, productList);

		quantity = productList.size();

		model.addAttribute("categoryList", categoryList);
		model.addAttribute("search", criterioBusqueda);
		model.addAttribute("quantityProducts", quantity);
		model.addAttribute("productList", paged.getPage(pagActual));
		model.addAttribute("pageActual", pagActual);
		model.addAttribute("totalPages", paged.totalPages - 1);

		return "List";
    }
	
	@RequestMapping(value = {"/List/next"})
	public String next(Model model) {
		if (pagActual < paged.pages.size() - 2) {
			pagActual++;
		}
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("search", criterioBusqueda);
		model.addAttribute("quantityProducts", quantity);
		model.addAttribute("productList", paged.getPage(pagActual));
		model.addAttribute("pageActual", pagActual);
		model.addAttribute("totalPages", paged.totalPages - 1);
		return "List";
	}

	@RequestMapping(value = {"/List/prev"})
	public String prev(Model model) {
		if (pagActual != 0) {
			pagActual--;
		}
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("search", criterioBusqueda);
		model.addAttribute("quantityProducts", quantity);
		model.addAttribute("productList", paged.getPage(pagActual));
		model.addAttribute("pageActual", pagActual);
		model.addAttribute("totalPages", paged.totalPages - 1);
		return "List";
	}

	//Clase privada que permite realizar la paginacion
	private class PagedList {

		private int Quantity_Element;
		private int totalPages;
		private List<List<Product>> pages;
		private List<Product> products;

		public PagedList(int Quantity, List<Product> product) {
			this.Quantity_Element = Quantity;
			this.products = product;
			pages = new LinkedList<>();
			generatePages();

		} // cosntructor

		private void generatePages() {
			// el total de paginas es calculado con el modulo de la cantidad de
			// productos entre la cantidad de elementos visibles por pagina

			totalPages = (products.size() % Quantity_Element == 0 ? products.size() / Quantity_Element
					: products.size() / Quantity_Element + 1);
			if (totalPages == 0)
				totalPages = 1;
			
			int contador = 0;
			for (int i = 0; i <= totalPages; i++) {
				List<Product> productsActual = new ArrayList<>();
				for (int k = 0; k < Quantity_Element; k++) {
					try {
						Product aux = products.get(contador);
						productsActual.add(aux);
						contador++;
					} catch (IndexOutOfBoundsException e) {
						break;
					}
				}
				pages.add(productsActual);
			}
		}// generatePages()

		//retorna una lista con la cantidad de elementos que se quiere visualizar
		public List<Product> getPage(int page) {
			return pages.get(page);
		}// getPage()
	}
}
