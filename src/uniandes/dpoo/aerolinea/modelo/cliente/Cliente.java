package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.Vuelo;


public abstract class Cliente {
	
	ArrayList <Tiquete> tiquetesSinUsar;
	ArrayList <Tiquete> tiquetesUsados;
	
	public Cliente() {
		
		tiquetesSinUsar=new ArrayList<Tiquete>();
		tiquetesUsados = new ArrayList<Tiquete>();
		
	}
public abstract String getTipoCliente();

public abstract String getIdentificador();

public void agregarTiquete(Tiquete tiquete) {

		tiquetesSinUsar.add(tiquete);
}

public int calcularValorTotalTiquetes() {
	
	int valorTotal = 0;
	
	for(Tiquete tiquete:tiquetesUsados) {
		valorTotal+=tiquete.getTarifa();
	}
	
	for (Tiquete tiquete:tiquetesSinUsar) {
		valorTotal+=tiquete.getTarifa();
		
	}
	
	return valorTotal;
	
}

public void usarTiquetes(Vuelo vuelo) {
	Collection<Tiquete> tiquetes = vuelo.getTiquetes();
	
	for (Tiquete tiquete:tiquetes) {
		if(tiquetesSinUsar.contains(tiquete)) {
			tiquetesSinUsar.remove(tiquete);
		}
		
		tiquetesUsados.add(tiquete);
		
	}
}
	

}
