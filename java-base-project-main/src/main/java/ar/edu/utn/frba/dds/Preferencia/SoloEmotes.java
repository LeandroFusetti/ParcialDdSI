package ar.edu.utn.frba.dds.Preferencia;

public class SoloEmotes implements Preferencia{
  @Override
  public Boolean pasaPreferencia(Mensaje mensaje) {
    return new Analizador().soloContieneEmojis(mensaje.getTexto());
  }
}
