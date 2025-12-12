package ar.edu.utn.frba.dds;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Transmision {
    private Chat chat;
    private String titulo;
    private List<String> categorias;
    private Integer numMaxParticipantesUnidos;
    private List<Canal> participantes;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public Transmision(String titulo,Chat chat,List <String> categorias){
    this.chat = chat;
    this.titulo = titulo;
    this.categorias = categorias;
    this.fechaInicio = LocalDateTime.now();
    this.participantes = new ArrayList<>();
    this.numMaxParticipantesUnidos = 0;
    }
    public void setFechaFin(LocalDateTime fechaFin){
        if(fechaFin.isBefore(this.fechaInicio)){
            throw new RuntimeException("la fecha de fin debe ser posterior a la fecha de inicio");
        }
        this.fechaFin = fechaFin;
    }

    public void agregarCategoria(String categoria){
        if(this.categorias.contains(categoria)){
            throw new RuntimeException("la categoria ya existe");
        }
        this.categorias.add(categoria);

    }
    public void eliminarCategoria(String categoria){
        if(!this.categorias.contains(categoria)){
            throw new RuntimeException("la categoria no existe");
        }
        this.categorias.remove(categoria);
    }

    public void unirseATransmision(Canal participante){
        this.numMaxParticipantesUnidos++;
        this.participantes.add(participante);
        this.chat.agregarParticipante(participante);
    }
    public void irseDeTransmision(Canal participante){
        this.participantes.remove(participante);
        this.chat.quitarParticipante(participante);
    }

    public List<Mensaje> listarMensajesEnviadosPor(Canal participante){
        return this.chat.listarMensajesEnviadosPor(participante);
    }
    public void enviarMensaje(Mensaje mensaje){
        this.chat.enviarMensaje(mensaje);
    }

}
