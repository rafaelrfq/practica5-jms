import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.LocalDateTime;
import java.util.Random;

public class Mensaje {
    private LocalDateTime fechaGeneracion;
    private int idDispositivo;
    private float temperatura;
    private float humedad;

    public Mensaje(int idDispositivo){
        this.fechaGeneracion = LocalDateTime.now();
        this.idDispositivo = idDispositivo;
        this.temperatura = generarRandom();
        this.humedad = generarRandom();
    }

    public LocalDateTime getFechaGeneracion() { return fechaGeneracion; }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    public int getIdDispositivo() { return idDispositivo; }

    public void setIdDispositivo(int idDispositivo) { this.idDispositivo = idDispositivo; }

    public float getTemperatura() { return temperatura; }

    public void setTemperatura(float temperatura) { this.temperatura = temperatura; }

    public float getHumedad() { return humedad; }

    public void setHumedad(float humedad) { this.humedad = humedad; }

    float generarRandom(){
        Random r = new Random();
        return (1 + r.nextFloat() * (100 - 1));
    }

    public String getJson(){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode mensaje = mapper.createObjectNode();
        mensaje.put("fechaGeneracion", fechaGeneracion.toString());
        mensaje.put("idDispositivo", 1);
        mensaje.put("temperatura", temperatura);
        mensaje.put("humedad", humedad);

        String json = "";
        try{
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mensaje);
        } catch (Exception e){
            e.printStackTrace();
        }

        return json;
    }
}