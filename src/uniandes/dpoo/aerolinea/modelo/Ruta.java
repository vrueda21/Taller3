package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
    // TODO completar
	private String horaSalida;
	private String horaLlegada;
	private String codigoRuta;
	private Aeropuerto destino;
	private Aeropuerto origen;
	
	public Ruta(Aeropuerto origen, Aeropuerto destino, String horaSalida, String horaLlegada, String codigoRuta){
		
		this.origen=origen;
		this.destino=destino;
		this.horaSalida=horaSalida;
		this.horaLlegada=horaLlegada;
		this.codigoRuta=codigoRuta;
		
	}
	
	public String getCodigoRuta() {
		return codigoRuta;
	}
	
	public Aeropuerto getOrigen() {
		return origen;
	}
	
	public Aeropuerto getDestino() {
		return destino;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	
	public String getHoraLlegada() {
		return horaLlegada;
		
	}
	
	public int getDuracion() {
		
		int heureSalida = Integer.parseInt(horaSalida);
		int heureLlegada = Integer.parseInt(horaLlegada);
		
	
		int heureSalidaMinutos=heureSalida%100;
		int heureSalidaHoras=heureSalida/100;
		int heureLlegadaMinutos=heureLlegada%100;
		int heureLlegadaHoras=heureLlegada/100;
		
		int heureSalidaEnMin=(heureSalidaHoras*60)+heureSalidaMinutos;
		int heureLlegadaEnMin=(heureLlegadaHoras*60)+heureLlegadaMinutos;
		
		 if (heureLlegadaEnMin < heureSalidaEnMin) {
		        heureLlegadaEnMin += 24 * 60;
		 }
	
		int duracion=heureLlegadaEnMin-heureSalidaEnMin;
		
		return duracion;


	}


    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta )
    {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }
    
    

    
}
