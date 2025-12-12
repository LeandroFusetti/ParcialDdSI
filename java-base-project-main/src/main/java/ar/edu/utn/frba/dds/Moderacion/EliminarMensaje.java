package ar.edu.utn.frba.dds.Moderacion;

import ar.edu.utn.frba.dds.Canal;
import ar.edu.utn.frba.dds.Preferencia.Mensaje;
import ar.edu.utn.frba.dds.Transmision;

import java.security.MessageDigest;

public class EliminarMensaje implements Moderacion {

  private Mensaje mensaje;
  @Override
  public void ejecutarModeracion(Transmision transmision) {
  transmision.getChat().eliminarMensaje(mensaje);
  }

  @Override
  public void deshacerModeracion(Transmision transmision) {
    transmision.getChat().mensajes.add(mensaje);
  }

  @Override
  public Boolean puedeEnviarMensaje(Canal participante, Transmision transmision) {
    return true;
  }

}
