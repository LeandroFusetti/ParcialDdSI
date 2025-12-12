package ar.edu.utn.frba.dds.Preferencia;

import ar.edu.utn.frba.dds.Canal;
import ar.edu.utn.frba.dds.Usuario;
import lombok.Getter;

@Getter
public class Mensaje {
    public String texto;
    public Canal enviadoPor;

    public Mensaje(String texto, Canal enviadoPor){
        this.texto = texto;
        this.enviadoPor = enviadoPor;

    }
}
