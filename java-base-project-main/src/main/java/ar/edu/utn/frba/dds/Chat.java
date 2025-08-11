package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    public List<Usuario> participantes;
    public List<Mensaje> mensajes;

    public Chat() {
        this.participantes = new ArrayList<>();
        this.mensajes = new ArrayList<>();
    }
    public void enviarMensaje(Mensaje mensaje){
        this.mensajes.add(mensaje);
    }
    public List<Mensaje> listarMensajesEnviadosPor(Usuario usuario){
        return this.mensajes.stream().filter(m->m.getEnviadoPor().equals(usuario)).toList();
    }
}

