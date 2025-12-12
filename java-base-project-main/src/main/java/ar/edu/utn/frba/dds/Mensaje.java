package ar.edu.utn.frba.dds;

import lombok.Getter;

@Getter
public class Mensaje {
    private String texto;
    private Canal enviadoPor;

    public Mensaje(String texto,Canal enviadoPor){
        this.texto = texto;
        this.enviadoPor = enviadoPor;
    }
}
