package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente
{
    // TODO completar
    
	public static final String CORPORATIVO = "Corporativo";
	public static final int GRANDE = 1;
	public static final int MEDIANA = 2;
	public static final int PEQUENA = 3;
	private String nombreEmpresa;
	private int tamanoEmpresa;
	
	public ClienteCorporativo(String nombreEmpresa, int tamano) {
		
		this.nombreEmpresa = nombreEmpresa;
		this.tamanoEmpresa = tamano;
		
	}
	
	public String getNombreEmpresa() {
		
		return nombreEmpresa;
	
	}
	
	public int getTamanoEmpresa() {
		
		return tamanoEmpresa;
	}
	
	@Override
	public String getTipoCliente(){
		
		return CORPORATIVO;
		
	}
	
	public String getIdentificador() {
		
		return nombreEmpresa;
		
	}
	
	
	

    /**
     * Crea un nuevo objeto de tipo a partir de un objeto JSON.
     * 
     * El objeto JSON debe tener dos atributos: nombreEmpresa (una cadena) y tamanoEmpresa (un número).
     * @param cliente El objeto JSON que contiene la información
     * @return El nuevo objeto inicializado con la información
     */
    public static ClienteCorporativo cargarDesdeJSON( JSONObject cliente )
    {
        String nombreEmpresa = cliente.getString( "nombreEmpresa" );
        int tam = cliente.getInt( "tamanoEmpresa" );
        return new ClienteCorporativo( nombreEmpresa, tam );
    }

    /**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject para que ese objeto se almacene en un archivo
     * @return El objeto JSON con toda la información del cliente corporativo
     */
    public JSONObject salvarEnJSON( )
    {
        JSONObject jobject = new JSONObject( );
        jobject.put( "nombreEmpresa", this.nombreEmpresa );
        jobject.put( "tamanoEmpresa", this.tamanoEmpresa );
        jobject.put( "tipo", CORPORATIVO );
        return jobject;
    }
}
