package ar.edu.utn.frba.dds.Moderacion;

import ar.edu.utn.frba.dds.Canal;
import ar.edu.utn.frba.dds.Transmision;

public class Baneo implements Moderacion{
  private Canal participante;
  @Override
  public void ejecutarModeracion(Transmision transmision) {
    transmision.duenio.banear(participante);
  }

  @Override
  public void deshacerModeracion(Transmision transmision) {
    transmision.duenio.quitarBanea(participante);
  }

  @Override
  public Boolean puedeEnviarMensaje(Canal participante, Transmision transmision) {
    return !transmision.duenio.baneados.contains(participante);
  }
}
