package ar.edu.utn.frba.dds;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Transmision {
    public Chat chat;
    public String titulo;
    public List<String> categorias;
    public Integer numMaxParticipantesUnidos;
    public Integer numParticipantesUnidos;
    public List<Usuario> participantes;
    public LocalDateTime fechaInicio;
    public LocalDateTime fechaFin;

    public Transmision(String titulo,Chat chat,List <String> categorias){
    this.chat = chat;
    this.titulo = titulo;
    this.categorias = categorias;
    this.fechaInicio = LocalDateTime.now();
    this.participantes = new ArrayList<>();
    this.numMaxParticipantesUnidos = 0;
    this.numParticipantesUnidos = 0;
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

    public void unirseATransmision(Usuario usuario){
        this.numParticipantesUnidos++;
        if(this.numMaxParticipantesUnidos<this.numParticipantesUnidos){
            this.numMaxParticipantesUnidos = this.numParticipantesUnidos;
        }

        this.participantes.add(usuario);
        this.chat.participantes.add(usuario);
    }
    public void irseDeTransmision(Usuario usuario){
        this.numParticipantesUnidos--;
        this.participantes.remove(usuario);
        this.chat.participantes.remove(usuario);
    }

    public List<Mensaje> listarMensajesEnviadosPor(Usuario usuario){
        return this.chat.listarMensajesEnviadosPor(usuario);
    }
    public void enviarMensaje(Mensaje mensaje){
        this.chat.enviarMensaje(mensaje);
    }

}
