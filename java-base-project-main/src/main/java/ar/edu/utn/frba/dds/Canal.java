package ar.edu.utn.frba.dds;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Canal {
    private String nombre;
    private List<Integer> muestrasApoyo;
    private List<Canal> suscriptores;
    private Transmision transmisionEnVivo;
    private List<Transmision> transmisionesHistoricas;

    public Canal(String nombre){
        this.nombre = nombre;
        this.muestrasApoyo = new ArrayList<>();
        this.suscriptores = new ArrayList<>();
        this.transmisionesHistoricas = new ArrayList<>();
    }

    public void recibirMuestraApoya(Integer valor){
        if(valor<1||valor>10){
            throw new RuntimeException("el valor debe ser entre 1 a 10");
        }
        this.muestrasApoyo.add(valor);
    }


    public boolean hayTransmisionEnVivo(){
        return this.transmisionEnVivo!=null;
    }


    public Transmision getTransmisionEnVivo(){
        if(!this.hayTransmisionEnVivo()){
            throw new RuntimeException("No hay una transmision en vivo");
        }
        return this.transmisionEnVivo;
    }
    public void suscribirUsuario(Canal participante){
        this.suscriptores.add(participante);
    }
    public void desuscribirUsuario(Canal participante){
        this.suscriptores.remove(participante);
    }
    public void unirseATransmision(Canal participante){
        if(!this.hayTransmisionEnVivo()){
            throw new RuntimeException("No hay una transmision en vivo");
        }
        this.transmisionEnVivo.unirseATransmision(participante);
    }

    public void irseDeTransmision(Canal participante){
        this.transmisionEnVivo.irseDeTransmision(participante);
    }

    public void iniciarTransmision(String titulo,Chat chat,List<String>categorias){
        if(this.transmisionEnVivo!=null){
            throw new RuntimeException("Ya hay una transmision en vivo");
        }
        this.transmisionEnVivo= new Transmision(titulo,chat,categorias);
    }
    public void detenerTransmision(){
        if(this.transmisionEnVivo==null){
            throw new RuntimeException("No hay una transmision en vivo");
        }
        this.transmisionEnVivo.setFechaFin(LocalDateTime.now());
        this.transmisionesHistoricas.add(this.transmisionEnVivo);
        this.transmisionEnVivo=null;
    }


}
