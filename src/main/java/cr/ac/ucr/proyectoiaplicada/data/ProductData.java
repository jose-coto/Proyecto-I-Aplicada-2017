package cr.ac.ucr.proyectoiaplicada.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
					1500,12,"sds","LineaBlanca");
			p.setDolarPrice(ConvertToDollar(p.getPrice()));
			productList.add(p);
		}
		
		return productList;
	}
	
	private float ConvertToDollar(float price) {
		return price/exchangeRate();
	}
	
	private static String obtenerFecha(){
        Calendar calendario = GregorianCalendar.getInstance();
        //Me obtiene la fecha del sistema
        Date fecha = calendario.getTime();
        //me perimite darle forma a la fecha
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");

        int hora,minutos,segundos;
        
        String fechaModificada=formatoDeFecha.format(fecha);

       
        return fechaModificada;
    }
	
	private float exchangeRate() {
		final String  indicatorCode="317";
		String date=obtenerFecha();	
		final String name="Jose";
		final String subNivel="N";
		
		float valueDolar=0;
		
		String url = "http://indicadoreseconomicos.bccr.fi.cr/indicadoreseconomicos/WebServices/wsIndicadoresEconomicos.asmx/"
				+ "ObtenerIndicadoresEconomicosXML?tcIndicador="+indicatorCode
				+"&tcFechaInicio="+date
				+"&tcFechaFinal="+date
				+"&tcNombre="+name
				+"&tnSubNiveles="+subNivel;
		try {
			URL ficheroUrl = new URL(url);

			BufferedReader br = new BufferedReader(new InputStreamReader(ficheroUrl.openStream()));

			String entrada;
			String cadena = "";

			while ((entrada = br.readLine()) != null) {
				cadena = cadena + entrada;
			}

			int pos= cadena.indexOf("R&gt;");
			
			valueDolar=Float.parseFloat(cadena.substring(pos+5, pos+17));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return valueDolar;
	}
}
