package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;

public abstract class CalculadoraTarifas {
	public static double IMPUESTO = 0.28;
	private Vuelo vuelo;
	private Cliente cliente;
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		int costoBase = calcularCostoBase(vuelo, cliente);
		
		
		if (!(calcularPorcentajeDescuento(cliente)==0)) {
			double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
			costoBase = (int)(costoBase * (1-porcentajeDescuento));
			
		}
		
		int impuesto = calcularValorImpuestos(costoBase);
		int tarifa = costoBase+impuesto;
		
		return tarifa;
	}

	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	protected int calcularDistanciaVuelo(Ruta ruta) {
		
		Aeropuerto aeropDest = ruta.getDestino();
		Aeropuerto aeropOrigen = ruta.getOrigen();
		int dist = Aeropuerto.calcularDistancia(aeropDest, aeropOrigen);
		return (int) dist;
		
	}
	
	protected abstract int calcularValorImpuestos(int costoBase);

}
