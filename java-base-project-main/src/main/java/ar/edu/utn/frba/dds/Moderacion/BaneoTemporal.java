package ar.edu.utn.frba.dds.Moderacion;

import ar.edu.utn.frba.dds.Canal;
import ar.edu.utn.frba.dds.Transmision;

import java.time.LocalDateTime;

public class BaneoTemporal extends MutearTemporalmente{


  public BaneoTemporal(Canal participante, Integer minutos) {
    super(participante,minutos);
  }

  @Override
  public Boolean puedeEnviarMensaje(Canal participante, Transmision transmision) {
    return !transmision.duenio.baneados.contains(participante) && LocalDateTime.now().isAfter(super.expiracion);

  }
}
