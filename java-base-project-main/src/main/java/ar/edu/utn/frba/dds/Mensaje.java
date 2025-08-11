package ar.edu.utn.frba.dds;

import lombok.Getter;

@Getter
public class Mensaje {
    public String texto;
    public Usuario enviadoPor;

    public Mensaje(String texto,Usuario enviadoPor){
        this.texto = texto;
        this.enviadoPor = enviadoPor;
    }
}
