package ar.edu.utn.frba.dds.Preferencia;

import ar.edu.utn.frba.dds.Idioma;

public class IdiomaApto implements Preferencia{
  private Idioma idioma;

  @Override
  public Boolean pasaPreferencia(Mensaje mensaje) {
    return new Analizador().determinarIdioma(mensaje.getTexto()) == idioma;
  }
}
