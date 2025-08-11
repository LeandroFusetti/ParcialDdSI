package ar.edu.utn.frba.dds;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Canal {
    public String nombre;
    public GestorDeTransmisiones gestorDeTransmisiones;
    public List<Integer> muestrasApoyo;
    public List<Usuario> suscriptores;
    public Canal(String nombre,GestorDeTransmisiones gestorDeTransmisiones){
        this.nombre = nombre;
        this.gestorDeTransmisiones = gestorDeTransmisiones;
        this.muestrasApoyo = new ArrayList<>();
        this.suscriptores = new ArrayList<>();
    }

    public void recibirMuestraApoya(Integer valor){
        if(valor<1||valor>10){
            throw new RuntimeException("el valor debe ser entre 1 a 10");
        }
        this.muestrasApoyo.add(valor);
    }
    public void iniciarTransmisionEnVivo(String titulo,Chat chat,List<String>categorias){
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
    public void suscribirUsuario(Usuario usuario){
        this.suscriptores.add(usuario);
    }
    public void desuscribirUsuario(Usuario usuario){
        this.suscriptores.remove(usuario);
    }
    public void unirseATransmision(Usuario usuario){
        if(!this.hayTransmisionEnVivo()){
            throw new RuntimeException("No hay una transmision en vivo");
        }
        this.gestorDeTransmisiones.getTransmisionEnVivo().unirseATransmision(usuario);
    }

    public void irseDeTransmision(Usuario usuario){
        this.gestorDeTransmisiones.getTransmisionEnVivo().irseDeTransmision(usuario);
    }
}
