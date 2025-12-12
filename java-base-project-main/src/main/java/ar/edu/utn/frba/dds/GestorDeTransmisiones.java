package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.Preferencia.Chat;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class GestorDeTransmisiones {
    public Transmision transmisionEnVivo;
    public List<Transmision> transmisionesHistoricas;


    public GestorDeTransmisiones(){
        this.transmisionesHistoricas = new ArrayList<>();
    }

    public void iniciarTransmision(String titulo, Chat chat, List<String>categorias){
        if(this.transmisionEnVivo!=null){
            throw new RuntimeException("Ya hay una transmision en vivo");
        }
        //this.transmisionEnVivo= new Transmision(titulo,Idioma.ESPANIOL,chat,categorias);
    }
    public void detenerTransmision(){
        if(this.transmisionEnVivo==null){
            throw new RuntimeException("No hay una transmision en vivo");
        }
        this.transmisionEnVivo.setFechaFin(LocalDateTime.now());
        this.transmisionesHistoricas.add(this.transmisionEnVivo);
        this.transmisionEnVivo=null;
    }

    public boolean hayTransmisionEnVivo(){
        return this.transmisionEnVivo!=null;
    }
}
