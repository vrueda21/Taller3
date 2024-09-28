package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;


public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	
	
	protected static int COSTO_POR_KM_NATURAL = 600;
	protected static int COSTO_POR_KM_CORPORATIVO = 900;
	protected static double DESCUENTO_PEQ = 0.02;
	protected static double DESCUENTO_MEDIANAS = 0.1;
	protected static double DESCUENTO_GRANDES = 0.2;
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int dist = super.calcularDistanciaVuelo(vuelo.getRuta());
		if (cliente.getTipoCliente().equals("Natural")) {
			return (int) (COSTO_POR_KM_NATURAL*dist);
		}
		
		if (cliente.getTipoCliente().equals("Corporativo")) {
			return (int)(COSTO_POR_KM_CORPORATIVO*dist);
		}
		
		return 0; ////Si entra aca, es porque no encontro ninguno de los dos tipos de clientes.
	
		
	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
		if (cliente instanceof ClienteCorporativo){
			int tamano = ((ClienteCorporativo) cliente).getTamanoEmpresa();
			
			if (tamano == 1) {
				return DESCUENTO_GRANDES;
			}
			else if (tamano ==2){
				return DESCUENTO_MEDIANAS;
				
			}
			
			else if (tamano==3) {
				return DESCUENTO_PEQ;
			}
			
		}
		return 0; //Si entra aca, es porque no encontro Cliente Corporativo.
		
		
		
	}
	

}
