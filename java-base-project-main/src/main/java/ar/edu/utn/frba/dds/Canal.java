package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.Preferencia.Chat;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Canal {
    public String nombre;
    public GestorDeTransmisiones gestorDeTransmisiones;
    public List<Integer> muestrasApoyo;
    public List<Canal> suscriptores;
    public List<Canal>baneados;
    public Canal(String nombre,GestorDeTransmisiones gestorDeTransmisiones){
        this.nombre = nombre;
        this.gestorDeTransmisiones = gestorDeTransmisiones;
        this.muestrasApoyo = new ArrayList<>();
        this.suscriptores = new ArrayList<>();
    }

    public void banear(Canal canal){
        this.baneados.add(canal);
    }
    public void quitarBanea(Canal canal){
        this.baneados.remove(canal);
    }

    public void recibirMuestraApoya(Integer valor){
        if(valor<1||valor>10){
            throw new RuntimeException("el valor debe ser entre 1 a 10");
        }
        this.muestrasApoyo.add(valor);
    }
    public void iniciarTransmisionEnVivo(String titulo, Chat chat, List<String>categorias){
        this.gestorDeTransmisiones.iniciarTransmision(titulo,chat,categorias);
    }
    public void detenerTransmisionEnVivo(){
        this.gestorDeTransmisiones.detenerTransmision();
    }
    public List<Transmision> getTransmisionesHistoricas(){
        return this.gestorDeTransmisiones.getTransmisionesHistoricas();
    }
    public boolean hayTransmisionEnVivo(){
        return this.gestorDeTransmisiones.hayTransmisionEnVivo();
    }
    public Transmision getTransmisionEnVivo(){
        if(!this.hayTransmisionEnVivo()){
            throw new RuntimeException("No hay una transmision en vivo");
        }
        return this.gestorDeTransmisiones.getTransmisionEnVivo();
    }
    public void suscribirUsuario(Canal suscriptor){
        this.suscriptores.add(suscriptor);
    }
    public void desuscribirUsuario(Canal suscriptor){
        this.suscriptores.remove(suscriptor);
    }
    public void unirseATransmision(Canal participante){
        if(!this.hayTransmisionEnVivo()){
            throw new RuntimeException("No hay una transmision en vivo");
        }
        this.gestorDeTransmisiones.getTransmisionEnVivo().unirseATransmision(participante);
    }

    public void irseDeTransmision(Canal participante){
        this.gestorDeTransmisiones.getTransmisionEnVivo().irseDeTransmision(participante);
    }
}
