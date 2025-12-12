package ar.edu.utn.frba.dds.Moderacion;

import ar.edu.utn.frba.dds.Canal;
import ar.edu.utn.frba.dds.Transmision;

public class MuteoPermanente  implements Moderacion {
  private Canal participante;

  public MuteoPermanente(Canal participante) {
    this.participante = participante;
  }
  @Override
  public void ejecutarModeracion(Transmision transmision) {
    transmision.muteados.add(participante);
  }

  @Override
  public void deshacerModeracion(Transmision transmision) {
    transmision.muteados.remove(participante);
  }

  @Override
  public Boolean puedeEnviarMensaje(Canal participante, Transmision transmision) {
    return transmision.muteados.contains(participante);
  }
}
