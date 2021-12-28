package comecocos;

import comecocos.Comecocos.Direccion;
import util.ES;

/** The type Principal. */
public class Principal {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    // Declaración de variables.
    int x;
    int y;
    Direccion dir;

    // Pedir los datos iniciales para crear otro comecocos
    x =
        ES.leeEntero(
            "Introduce la posición x del comecocos: ", 0); // Llamada al metedo leeEntero de ES
    y = ES.leeEntero("Introduce la posición y del comecocos: ", 0);

    ES.msgln("Introduce la dirección del comecocos (0, 90, 180, 270): "); // metodo msgln de ES.

    int entradaGrados = ES.leeEntero(); // Asignación de ES.leeEntero() a entradaGrados.

    /* Si son válidos los datos que hemos leído por teclado, entonces
    creamos el objeto con los datos leídos */

    if (Comecocos.numeroEntero(entradaGrados)) {
      dir = Comecocos.gradosAdireccion(entradaGrados);
      Comecocos player1 = new Comecocos(x, y, dir);

      // Escribir posición inicial
      ES.msgln("El comecocos recién creado está en: " + player1);

      // Controlar al comecocos según las órdenes recibidas por teclado
      ES.msgln("Escriba:");
      String mensaje =
          "0-> Avanzar 10 pasos.\n1-> Girar a la derecha.\n2-> Girar a la izquierda."
              + "\n3-> Emitir sonido.\n4-> Salir del programa.";
      int eleccion;
      /*Inicio bucle do-while que se repetirá mientras el usuario no pulse el número 4, preguntando cada vez
       * que jugada desea realizar el jugador. 0-> Avanzar 10 pasos. 1-> Girar a la derecha. 2-> Girar a la izquierda
       *3-> Reproducir un sonido, 4-> Salir del juego.
       * */
      do {
        eleccion = ES.leeEntero(mensaje, 0, 4);
        switch (eleccion) {
          case 0:
            player1.setAvanzar(10);
            ES.msgln(player1.toString());
            break;
          case 1:
            player1.setGiraDerecha();
            ES.msgln(player1.toString());
            break;
          case 2:
            player1.setGiraIzquierda();
            ES.msgln(player1.toString());
            break;
          case 3:
            try {
              player1.ReproducirSonido("pacmandie.wav");
              ES.msgln("Reproduciendo sonido");
            } catch (InterruptedException e) { // Captura del error InterruptedException
              ES.msgln("Error " + e.getClass().getName());
            }
            break;
        }
      } while (eleccion != 4); // Salida del bucle
      ES.msgln("El comecocos ha finalizado con las " + player1);
      ES.msgln("Hasta la vista!");
    }
    // SINO
    // Indica que el se juego se ha terminado.
    else {
      ES.msgln("Juego terminado, no introdujo los grados correctamente. ");
    }
  }
}
