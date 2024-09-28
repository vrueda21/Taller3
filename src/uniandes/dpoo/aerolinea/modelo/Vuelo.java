package uniandes.dpoo.aerolinea.modelo;
import java.util.Collection;
import java.util.Map;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;

public class Vuelo {
	
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Map<String, Tiquete> tiquetes;

	public Vuelo(Ruta ruta, String fecha, Avion avion){
		
		this.fecha=fecha;
		this.ruta=ruta;
		this.avion=avion;
	}
	
	public Ruta getRuta() {
		return ruta;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public Avion getAvion() {
		return avion;
	}
	
	public Collection<Tiquete> getTiquetes(){
		
		return tiquetes.values();
		
	}
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
		Tiquete tiquete = new Tiquete("", this, cliente, cantidad);
		cliente.agregarTiquete(tiquete);
		calculadora.calcularTarifa(this, cliente);
		return 0;
	}
	
	public boolean equals(Object obj) {
		return false;
		
	}
}
