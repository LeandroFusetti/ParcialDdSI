package ar.edu.utn.frba.dds.Moderacion;

import ar.edu.utn.frba.dds.Canal;
import ar.edu.utn.frba.dds.Transmision;
import ar.edu.utn.frba.dds.Usuario;

import java.time.LocalDateTime;

public class MutearTemporalmente extends MuteoPermanente {
  private Integer minutos;
  LocalDateTime expiracion;

  public MutearTemporalmente(Canal participante, Integer minutos) {
    super(participante);
    this.minutos = minutos;
    this.expiracion = LocalDateTime.now().plusMinutes(minutos);
  }

  @Override
  public Boolean puedeEnviarMensaje(Canal participante, Transmision transmision) {
    return !transmision.muteados.contains(participante) && LocalDateTime.now().isAfter(this.expiracion);
  }
}
