package ar.edu.utn.frba.dds.Preferencia;

import ar.edu.utn.frba.dds.Canal;
import ar.edu.utn.frba.dds.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    public AnalizadorDeTexto analizador;
    public List<Canal> participantes;
    public List<Mensaje> mensajes;

    public Chat() {
        this.participantes = new ArrayList<>();
        this.mensajes = new ArrayList<>();
    }


    public void eliminarMensaje(Mensaje mensaje){
        this.mensajes.remove(mensaje);
    }


    public List<Mensaje> listarMensajesEnviadosPor(Canal participante){
        return this.mensajes.stream().filter(m->m.getEnviadoPor().equals(participante)).toList();
    }
}

