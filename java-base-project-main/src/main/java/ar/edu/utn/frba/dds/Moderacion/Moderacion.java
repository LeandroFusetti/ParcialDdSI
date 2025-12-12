package ar.edu.utn.frba.dds.Moderacion;

import ar.edu.utn.frba.dds.Canal;
import ar.edu.utn.frba.dds.Transmision;

public interface  Moderacion {

  public void ejecutarModeracion(Transmision transmision);
  public  void deshacerModeracion(Transmision transmision);
  public  Boolean puedeEnviarMensaje(Canal participante, Transmision transmision);
}
