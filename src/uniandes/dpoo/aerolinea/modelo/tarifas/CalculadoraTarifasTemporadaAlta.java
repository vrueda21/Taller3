package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{
	
	protected int COSTO_POR_KM = 1000;
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int dist = super.calcularDistanciaVuelo(vuelo.getRuta());
			return (int) (COSTO_POR_KM*dist);
		
		
	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
		
		return 0; //Cuando es temporada alta, no hay descuento.
		
	}

	@Override
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		
		int costoBase = calcularCostoBase(vuelo, cliente);
		int impuesto = calcularValorImpuestos(costoBase);
		int tarifa = costoBase+impuesto;
		
		return tarifa;
	}

	@Override
	protected int calcularDistanciaVuelo(Ruta ruta) {
		// TODO Auto-generated method stub
		return super.calcularDistanciaVuelo(ruta);
	}

	@Override
	protected int calcularValorImpuestos(int costoBase) {
		// TODO Auto-generated method stub
		
		 int valorFinal = (int)(IMPUESTO * costoBase);
		    return valorFinal;
	}

}
