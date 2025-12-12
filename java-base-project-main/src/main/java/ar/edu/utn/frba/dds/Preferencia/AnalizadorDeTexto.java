package ar.edu.utn.frba.dds.Preferencia;

import ar.edu.utn.frba.dds.Idioma;

public interface AnalizadorDeTexto {
  public Idioma determinarIdioma(String texto);
  public Boolean esAptoTodoPublic(String texto);
  public Boolean soloContieneEmojis(String texto);
}
