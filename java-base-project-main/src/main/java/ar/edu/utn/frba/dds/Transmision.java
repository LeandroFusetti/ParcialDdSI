package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.Moderacion.Moderacion;
import ar.edu.utn.frba.dds.Preferencia.Chat;
import ar.edu.utn.frba.dds.Preferencia.Mensaje;
import ar.edu.utn.frba.dds.Preferencia.Preferencia;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Transmision {
    public Canal duenio;
    public Chat chat;
    public Idioma idioma;
    public String titulo;
    public List<String> categorias;
    public Integer numMaxParticipantesUnidos;
    public List<Canal> participantes;
    public LocalDateTime fechaInicio;
    public LocalDateTime fechaFin;
    public List<Moderacion> moderaciones;
    public List<Preferencia> preferencias;
    public List<Canal>muteados;
    public Transmision(String titulo,Idioma idioma, Chat chat,List <String> categorias,Canal duenio) {
    this.duenio = duenio;
    this.chat = chat;
    this.titulo = titulo;
    this.idioma = idioma;
    this.categorias = categorias;
    this.fechaInicio = LocalDateTime.now();
    this.participantes = new ArrayList<>();
    this.numMaxParticipantesUnidos = 0;
    this.moderaciones = new ArrayList<>();

    }

    public Boolean puedeEnviarMensaje(Canal participante) {
        return this.moderaciones.stream().allMatch(m->m.puedeEnviarMensaje(participante,this));
    }
    public void enviarMensaje(Mensaje mensaje){
        if(this.preferencias.stream().allMatch(p->p.pasaPreferencia(mensaje))
            && !this.muteados.contains(mensaje.enviadoPor))
            this.chat.mensajes.add(mensaje);
    }


    public void setFechaFin(LocalDateTime fechaFin){
        if(fechaFin.isBefore(this.fechaInicio)){
            throw new RuntimeException("la fecha de fin debe ser posterior a la fecha de inicio");
        }
        this.fechaFin = fechaFin;
    }

    public void moderar(Moderacion moderacion){
        this.moderaciones.add(moderacion);
        moderacion.ejecutarModeracion(this);
    }
    public void deshacerModeracion(Moderacion moderacion){
        this.moderaciones.remove(moderacion);
        moderacion.deshacerModeracion(this);
    }

    public void cargarPreferencia(Preferencia preferencia){
        this.preferencias.add(preferencia);
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
//        if(this.numMaxParticipantesUnidos<this.numParticipantesUnidos){
//            this.numMaxParticipantesUnidos = this.numParticipantesUnidos;
//        }

        this.participantes.add(participante);
        this.chat.participantes.add(participante);
    }
    public void irseDeTransmision(Canal participante){
        //this.numParticipantesUnidos--;
        this.participantes.remove(participante);
        this.chat.participantes.remove(participante);
    }

    public List<Mensaje> listarMensajesEnviadosPor(Canal participante){
        return this.chat.listarMensajesEnviadosPor(participante);
    }



}
