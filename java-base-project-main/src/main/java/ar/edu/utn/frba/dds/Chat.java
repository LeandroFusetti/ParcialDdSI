package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    private List<Canal> participantes;
    private List<Mensaje> mensajes;

    public Chat() {
        this.participantes = new ArrayList<>();
        this.mensajes = new ArrayList<>();
    }
    public void enviarMensaje(Mensaje mensaje){
        this.mensajes.add(mensaje);
    }
    public List<Mensaje> listarMensajesEnviadosPor(Canal participante){
        return this.mensajes.stream().filter(m->m.getEnviadoPor().equals(participante)).toList();
    }
    public void agregarParticipante(Canal participante){
        this.participantes.add(participante);
    }

    public void quitarParticipante(Canal participante){
        this.participantes.remove(participante);
    }
}

