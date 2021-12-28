package comecocos;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/** The type Comecocos. */
public class Comecocos {

  private int x;
  private int y;
  private Direccion direccion;

  /**
   * Instantiates a new Comecocos.
   *
   * @param x the x
   * @param y the y
   * @param direccion the direccion
   */
  public Comecocos(int x, int y, Direccion direccion) {
    this.x = x;
    this.y = y;
    this.direccion = direccion;
  }

  /** Instantiates a new Comecocos. Contructor por defecto, no recibe parámetros. */
  public Comecocos() {
    x = 0;
    y = 0;
    direccion = Direccion.NORTE;
  }

  /**
   * Grados adireccion direccion. Metodo estatico que transforma los grados que recibe por parametro
   * a tipo direccion.
   *
   * @param grados the grados
   * @return the direccion
   */
  public static Direccion gradosAdireccion(int grados) {
    grados = grados % 360;
    Direccion convertida = null; // Inicialización de convertida a null para poder usar el return.
    switch (grados) {
      case 0:
        convertida = Direccion.NORTE;
        break;
      case 90:
        convertida = Direccion.ESTE;
        break;
      case 180:
        convertida = Direccion.SUR;
        break;
      case 270:
        convertida = Direccion.OESTE;
        break;
    }
    return convertida; // Devuelve la direccion ya convertida
  }

  /**
   * Numero entero boolean.
   *
   * <p>Método eståtico que devuelve un true o false en caso de que el número recibido o la división
   * entera de éste por 360 sea igual a 0, 90, 180, 270.
   *
   * @param numero the numero
   * @return the boolean
   */
  public static boolean numeroEntero(int numero) {
    int gradosNormalizados = numero % 360;
    boolean esEntero = (gradosNormalizados == 0) | (gradosNormalizados == 90) | (gradosNormalizados == 180) | (gradosNormalizados == 270);

    return esEntero;
  }
  /**
   * ToString. Metodo que devuelve un mensaje con la información que queremos.
   *
   * @return the string
   */
  public String toString() {
    return "Coordenadas x=" + x + ", y=" + y + ", con dirección=" + direccion;
  }

  /**
   * Gets x.
   *
   * @return the x
   */
  public int getX() {
    return x;
  }

  /**
   * Sets x.
   *
   * @param x the x
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Gets y.
   *
   * @return the y
   */
  public int getY() {
    return y;
  }

  /**
   * Sets y.
   *
   * @param y the y
   */
  public void setY(int y) {
    this.y = y;
  }

  /**
   * Gets direccion. Toma la dirección en la que está el objeto y devuelve un objeto tipo Direccion.
   *
   * @return the direccion
   */
  public Direccion getDireccion() {
    return direccion;
  }

  /**
   * Sets direccion. Determina la dirección del objeto.
   *
   * @param direccion the direccion
   */
  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  /** Sets gira derecha. */
  /*Simple método setter para que el objeto gire a la derecha de la posición que ya ocupa*/
  public void setGiraDerecha() {

    switch (direccion) {
      case NORTE:
        direccion = Direccion.ESTE;
        break;
      case ESTE:
        direccion = Direccion.SUR;
        break;
      case SUR:
        direccion = Direccion.OESTE;
        break;
      case OESTE:
        direccion = Direccion.NORTE;
        break;
    }
  }

  /** Sets gira izquierda. */
  /*Simple método setter para que el objeto gire a la izquierda de la posición que ya ocupa*/
  public void setGiraIzquierda() {

    switch (direccion) {
      case NORTE:
        direccion = Direccion.OESTE;
        break;
      case OESTE:
        direccion = Direccion.SUR;
        break;
      case SUR:
        direccion = Direccion.ESTE;
        break;
      case ESTE:
        direccion = Direccion.NORTE;
        break;
    }
  }

  /**
   * Sets avanzar. Método para que avance el objeto en un eje de coordenadas y abcisas. Recibe por
   * parámetro el número de pasos y dependiendo de la dirección del objeto suma o resta el número de
   * pasos.
   *
   * @param pasos the pasos
   */
  public void setAvanzar(int pasos) {
    if (getDireccion().equals(Direccion.NORTE)) { // equals para comparar dos objetos.
      y += pasos;
    } else if (getDireccion().equals(Direccion.ESTE)) {
      x += pasos;
    } else if (getDireccion().equals(Direccion.SUR)) {
      y -= pasos;
    } else if (getDireccion().equals(Direccion.OESTE)) {
      x -= pasos;
    }
  }

  /**
   * Direccion a grados int. Método que devuelve un integer cuando se le pasa por parámetro un
   * objetivo/enumera de tipo dirección.
   *
   * @param direccion the direccion
   * @return the int
   */
  public int direccionAgrados(Direccion direccion) {

    int grados = 1; // variable int inicializada en 1 para que no cumpla en principio ningún caso.
    switch (direccion) {
      case NORTE:
        grados = 0;
        break;
      case ESTE:
        grados = 90;
        break;
      case SUR:
        grados = 180;
        break;
      case OESTE:
        grados = 270;
        break;
    }
    return grados; // Devuelve los grados de cada de dirección
  }

  /**
   * Clase Reproducir sonido que arroja error InterruptedException si se interrumpe el Thread.sleep.
   * Recibe por parámnetro un String con el nombre del archivo.
   *
   * @param nombreSonido the nombre sonido
   * @throws InterruptedException the interrupted exception
   */
  public void ReproducirSonido(String nombreSonido) throws InterruptedException {
    /**
     * Control de excepciones que intenta ejecutar toda esta fila de código. Si algo falla, el catch
     * se encargará de capturar los errores, en este caso UnsupportedAudioFileException,
     * LineUnavailableException e IOException que heredan de Exception y a su vez de Throwable
     */
    try {
      AudioInputStream audioInputStream =
          AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
      Thread.sleep(2000);
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
      System.out.println("Error al reproducir el sonido.");
    }
  }

  /** The enum Direccion. Objeto de tipo enumera con las direcciones que puede tener el objeto. */
  enum Direccion {
    /** Norte direccion. */
    NORTE,
    /** Sur direccion. */
    SUR,
    /** Este direccion. */
    ESTE,
    /** Oeste direccion. */
    OESTE
  }
}
