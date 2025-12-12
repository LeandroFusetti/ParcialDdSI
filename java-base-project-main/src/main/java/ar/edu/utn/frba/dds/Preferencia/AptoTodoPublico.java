package ar.edu.utn.frba.dds.Preferencia;

public class AptoTodoPublico implements Preferencia{
  @Override
  public Boolean pasaPreferencia(Mensaje mensaje) {
    return new Analizador().esAptoTodoPublic(mensaje.getTexto());
  }
}
