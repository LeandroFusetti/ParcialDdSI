package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.Preferencia.Chat;
import ar.edu.utn.frba.dds.Preferencia.Mensaje;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

//public class LiveSreamTest {
//
//  private Canal canal;
//  private Canal canal2;
//  private Canal participante;
//  private Canal usuario2;
//  private Canal usuario3;
//  private RepositorioCanales repositorioCanales;
//  private Chat chat;
//  private Chat chat2;
//
//  @BeforeEach
//  public void setUp(){
//    this.canal = new Canal("canal",new GestorDeTransmisiones());
//    this.canal2 = new Canal("canal2",new GestorDeTransmisiones());
//    this.repositorioCanales = new RepositorioCanales();
//    this.repositorioCanales.agregarCanal(canal);
//    this.repositorioCanales.agregarCanal(canal2);
//    this.participante = new Canal("Lea");
//    this.canal2 = new Canal("Juan");
//    this.canal3 =new Canal("Maria");
//
//    this.chat = new Chat();
//    this.chat2 = new Chat();
//  }
//
//  @Test
//  @DisplayName("Se registra una canal")
//  public void seRegistraUnCanal(){
//    RepositorioCanales repositorioCanales = new RepositorioCanales();
//    repositorioCanales.agregarCanal(canal);
//
//
//    assertEquals("canal",repositorioCanales.buscarCanal(canal).getNombre());
//  }
//  @Test
//  @DisplayName("no hay transmision en vivo")
//  public void noHayTransmisionEnVivo(){
//    assertFalse(canal.hayTransmisionEnVivo());
//    canal.iniciarTransmisionEnVivo("estamos en vivo",new Chat(), Arrays.asList("cocina","cocinando"));
//  }
//  @Test
//  @DisplayName("se inicia una transmision en vivo")
//  public void seIniciaTransmisionEnVivo(){
//    canal.iniciarTransmisionEnVivo("estamos en vivo",new Chat(), Arrays.asList("cocina","cocinando"));
//    assertTrue(canal.hayTransmisionEnVivo());
//  }
//
//  @Test
//  @DisplayName("se detiene una transmision en vivo")
//  public void seDetieneTransmisionEnVivo(){
//    canal.iniciarTransmisionEnVivo("estamos en vivo",new Chat(), Arrays.asList("cocina","cocinando"));
//    canal.detenerTransmisionEnVivo();
//    assertFalse(canal.hayTransmisionEnVivo());
//  }
//
//  @Test
//  @DisplayName("listo canales")
//  public void listoDosCanales(){
//    assertEquals(2,repositorioCanales.listarCanales().size());
//    assertEquals("canal",repositorioCanales.listarCanales().get(0).getNombre());
//    assertEquals("canal2",repositorioCanales.listarCanales().get(1).getNombre());
//  }
//
//  @Test
//  @DisplayName("se lista una transmision en curso")
//  public void seListaUnaTransmisionEnVivo(){
//    assertEquals(0,repositorioCanales.listarTransmisionesEnVivo().size());
//    canal2.iniciarTransmisionEnVivo("estamos en vivo",new Chat(), Arrays.asList("cocina","cocinando"));
//    assertEquals(1,repositorioCanales.listarTransmisionesEnVivo().size());
//    assertEquals("estamos en vivo",canal2.getTransmisionEnVivo().getTitulo());
//  }
//  @Test
//  @DisplayName("se listan 2 transmisiones historicas")
//  public void seListanUnaTransmisionHistoricaEnCadaCanal(){
//    assertEquals(0,repositorioCanales.listarTransmisionesHistoricas(canal).size());
//    canal.iniciarTransmisionEnVivo("estamos en vivo ahora",new Chat(), Arrays.asList("cocina","cocinando"));
//    canal2.iniciarTransmisionEnVivo("estamos en vivo",new Chat(), Arrays.asList("cocina","cocinando"));
//    assertEquals(0,repositorioCanales.listarTransmisionesHistoricas(canal).size());
//    canal.detenerTransmisionEnVivo();
//    canal2.detenerTransmisionEnVivo();
//    assertEquals(1,repositorioCanales.listarTransmisionesHistoricas(canal).size());
//    assertEquals(1,repositorioCanales.listarTransmisionesHistoricas(canal2).size());
//
//    assertEquals("estamos en vivo ahora",repositorioCanales.listarTransmisionesHistoricas(canal).get(0).getTitulo());
//    assertEquals("estamos en vivo",repositorioCanales.listarTransmisionesHistoricas(canal2).get(0).getTitulo());
//  }
//
//  @Test
//  @DisplayName("me suscribo a un canal")
//  public void usuarioSeSuscribeAlCanal(){
//
//
//    canal.suscribirUsuario(participante);
//    assertTrue(canal.suscriptores.contains(participante));
//
//  }
//
//  @Test
//  @DisplayName("se otorga una muetra de apoyo valida")
//  public void seOtorgaUnaMuestraDeApoyoValida(){
//    canal.recibirMuestraApoya(1);
//    assertEquals(1,canal.muestrasApoyo.get(0));
//  }
//  @Test
//  @DisplayName("no se otorga una muetra de apoyo invalida")
//  public void noSeOtorgaUnaMuestraDeApoyoInvalida(){
//    assertThrows(RuntimeException.class,()->canal.recibirMuestraApoya(-5));
//    assertEquals(0,canal.muestrasApoyo.size());
//  }
//  @Test
//  @DisplayName("usuario se une a transmision")
//  public void usuarioSeUneATransmision(){
//    canal.iniciarTransmisionEnVivo("estamos en vivo",chat,Arrays.asList("cocina","cocinando"));
//    canal.unirseATransmision(participante);
//    assertTrue(canal.getTransmisionEnVivo().participantes.contains(participante));
//  }
//  @Test
//  @DisplayName("usuario sale de transmision")
//  public void usuarioSaleDeTransmision(){
//    canal.iniciarTransmisionEnVivo("estamos en vivo",chat,Arrays.asList("cocina","cocinando"));
//    canal.unirseATransmision(participante);
//    canal.irseDeTransmision(participante);
//    assertFalse(canal.getTransmisionEnVivo().participantes.contains(participante));
//  }
//  @Test
//  @DisplayName("hubo 2 usuarios como numero maximo de una transmision")
//  public void seRegistraDosParticipantesComoMaximoEnUnaTransmision(){
//    canal.iniciarTransmisionEnVivo("estamos en vivo",chat,Arrays.asList("cocina","cocinando"));
//    canal.unirseATransmision(participante);
//    canal.irseDeTransmision(participante);
//    canal.unirseATransmision(participante2);
//    canal.unirseATransmision(usuario3);
//    canal.irseDeTransmision(usuario3);
//    canal.irseDeTransmision(usuario2);
//    assertEquals(2,canal.getTransmisionEnVivo().numMaxParticipantesUnidos);
//    //assertEquals(0,canal.getTransmisionEnVivo().numParticipantesUnidos);
//  }
//  @Test
//  @DisplayName("envio y listo los mensajes que envio el usuario")
//  public void envioYListoLosMensajesQueEnvioElUsuario(){
//    canal.iniciarTransmisionEnVivo("estamos en vivo",chat,Arrays.asList("cocina","cocinando"));
//    canal.unirseATransmision(participante);
//    canal.unirseATransmision(participante2);
//    canal.getTransmisionEnVivo().enviarMensaje(new Mensaje("hola",participante));
//    canal.getTransmisionEnVivo().enviarMensaje(new Mensaje("que tal",participante2));
//    canal.getTransmisionEnVivo().enviarMensaje(new Mensaje("todo bien por suerte",participante));
//    assertEquals(2,canal.getTransmisionEnVivo().listarMensajesEnviadosPor(participante).size());
//    assertEquals(1,canal.getTransmisionEnVivo().listarMensajesEnviadosPor(participante2).size());
//    assertEquals("hola",canal.getTransmisionEnVivo().listarMensajesEnviadosPor(participante).get(0).texto);
//    assertEquals("todo bien por suerte",canal.getTransmisionEnVivo().listarMensajesEnviadosPor(participante).get(1).texto);
//  }
//
//}
