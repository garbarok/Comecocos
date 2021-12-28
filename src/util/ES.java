package util;

import java.util.Scanner;

/** The type Es. */
/*
 * Esta clase define algunos métodos para entrada de datos, de forma que se capturen los errores de entrada sin abortar, en caso
 * de que el usuario introduzca datos no válidos.
 * TambiĂŠn incluye un par de métodos para simpliciar la escritura de mensajes en pantalla, abreviando la escritura de las sentencias
 * System.out.println() y System.out.print(). Se hace uso tambiĂŠn de la sobrecarga de métodos, que es algo que se habĂ­a visto con
 * los constructores, pero sin entrar en detalle. AsĂ­, podemos tener tres métodos para lee enteros, que se llaman todos igual, pero
 * que se diferencian en su lista de parámetros.
 *
 * @author Profesor
 */
public class ES {

  /**
   * Lee entero int.
   *
   * @return the int
   */
  public static int leeEntero() {
    boolean leido = false;
    int numero = 0;
    Scanner teclado = null;
    do {
      try {
        teclado = new Scanner(System.in);
        numero = teclado.nextInt();
        leido = true;
      } catch (Exception e) {
        ES.msgln("Error: No es un número entero válido. ");
      }

    } while (!leido);
    return numero;
  }

  /**
   * Entrada teclado int.
   *
   * @param mensaje the mensaje
   * @return the int
   */
  public static int entradaTeclado(String mensaje) {
    int numero = 1;
    boolean leido = false;
    Scanner teclado;
    do {
      msgln(mensaje);
      try {
        teclado = new Scanner(System.in);
        numero = teclado.nextInt();
        if ((numero == 0) | (numero == 1) | (numero == 2) | (numero == 3) | (numero == 4)) {
          teclado.close();
          return numero;
        } else {
          msgln("Error. Introduzca uno de los siguientes números: ");
        }
      } catch (Exception e) {
        msgln("Error: No es un número entero válido. ");
      }
    } while (numero != 4);
    return numero;
  }

  /**
   * Lee entero int.
   *
   * @param mensaje the mensaje
   * @return the int
   */
  public static int leeEntero(String mensaje) {
    int numero = 0;
    boolean leido = false;
    Scanner teclado = null;
    do {
      ES.msgln(mensaje);
      try {
        teclado = new Scanner(System.in);
        numero = teclado.nextInt();
        leido = true;
      } catch (Exception e) {
        ES.msgln("Error: No es un número entero válido. ");
      }
    } while (!leido);
    return numero;
  }

  /**
   * Lee entero int.
   *
   * @param minimo the minimo
   * @return the int
   */
  public static int leeEntero(int minimo) {
    int numero = 0;
    boolean leido = false;
    Scanner teclado = null;
    do {
      try {
        teclado = new Scanner(System.in);
        numero = teclado.nextInt();
        if (numero >= minimo) {
          leido = true;
        } else {
          ES.msgln("Error: Debe ser un número entero mayor o igual que " + minimo + ". ");
        }
      } catch (Exception e) {
        ES.msgln("Error: No es un número entero válido. ");
      }
    } while (!leido);
    return numero;
  }

  /**
   * Lee entero int.
   *
   * @param mensaje the mensaje
   * @param minimo the minimo
   * @return the int
   */
  public static int leeEntero(String mensaje, int minimo) {
    int numero = 0;
    boolean leido = false;
    Scanner teclado = null;
    do {
      ES.msgln(mensaje);
      try {
        teclado = new Scanner(System.in);
        numero = teclado.nextInt();
        if (numero >= minimo) {
          leido = true;
        } else {
          ES.msgln("Error: Debe ser un número entero mayor o igual que " + minimo + ".");
        }
      } catch (Exception e) {
        ES.msgln("Error: No es un número entero válido. ");
      }
    } while (!leido);
    return numero;
  }

  /**
   * Entrada grado int.
   *
   * @param mensaje the mensaje
   * @param minimo the minimo
   * @return the int
   */
  public static int entradaGrado(String mensaje, int minimo) {
    int numero = 0;
    boolean leido = false;
    Scanner teclado = null;
    do {
      ES.msgln(mensaje);
      try {
        teclado = new Scanner(System.in);
        numero = teclado.nextInt();
        if (numero == 0 | numero == 90 | numero == 180 | numero == 270) {
          leido = true;
        } else {
          ES.msgln("Juego terminado, no introdujo los grados correctamente. ");
        }
      } catch (Exception e) {
        ES.msgln("Error: No es un número entero válido. ");
      }
    } while (!leido);
    return numero;
  }

  /**
   * Lee entero int.
   *
   * @param minimo the minimo
   * @param maximo the maximo
   * @return the int
   * @throws IllegalArgumentException the illegal argument exception
   */
  public static int leeEntero(int minimo, int maximo) throws IllegalArgumentException {
    int numero = 0;
    boolean leido = false;
    Scanner teclado = null;

    // Si el valor mínimo es mayor que el máximo, lanzamos una excepciĂłn
    if (minimo <= maximo) {
      do {
        try {
          teclado = new Scanner(System.in);
          numero = teclado.nextInt();
          if (numero >= minimo && numero <= maximo) {
            leido = true;
          } else {
            ES.msgln(
                "Error: Debe ser un número entero mayor o igual que "
                    + minimo
                    + " y menor o igual que "
                    + maximo
                    + ". ");
          }
        } catch (Exception e) {
          ES.msgln("Error: No es un número entero válido. ");
        }
      } while (!leido);
    } else {
      throw new IllegalArgumentException(
          "Rango imposible. El valor mínimo no puede ser mayor que el valor máximo");
    }
    return numero;
  }

  /**
   * Lee entero int.
   *
   * @param mensaje the mensaje
   * @param minimo the minimo
   * @param maximo the maximo
   * @return the int
   * @throws IllegalArgumentException the illegal argument exception
   */
  public static int leeEntero(String mensaje, int minimo, int maximo)
      throws IllegalArgumentException {
    int numero = 0;
    boolean leido = false;
    Scanner teclado = null;

    // Si el valor mínimo es mayor que el máximo, lanzamos una excepciĂłn
    if (minimo <= maximo) {
      do {
        ES.msgln(mensaje);
        try {
          teclado = new Scanner(System.in);
          numero = teclado.nextInt();
          if (numero >= minimo && numero <= maximo) {
            leido = true;
          } else {
            ES.msgln(
                "Error: Debe ser un número entero mayor o igual que "
                    + minimo
                    + " y menor o igual que "
                    + maximo
                    + ". ");
          }
        } catch (Exception e) {
          ES.msgln("Error: No es un número entero válido. ");
        }
      } while (!leido);
    } else {
      throw new IllegalArgumentException(
          "Rango imposible. El valor mínimo no puede ser mayor que el valor máximo");
    }
    return numero;
  }

  /**
   * Lee cadena string.
   *
   * @return the string
   */
  public static String leeCadena() {
    Scanner teclado = new Scanner(System.in);
    String cadena = "";
    try {
      cadena = teclado.nextLine();
    } catch (Exception e) {
      ES.msgln("Error: Ha fallado la entrada de datos.");
    }
    return cadena;
  }

  /**
   * Lee cadena string.
   *
   * @param mensaje the mensaje
   * @return the string
   */
  public static String leeCadena(String mensaje) {
    Scanner teclado = new Scanner(System.in);
    String cadena = "";
    try {
      ES.msgln(mensaje);
      cadena = teclado.nextLine();
    } catch (Exception e) {
      ES.msgln("Error: Ha fallado la entrada de datos.");
    }
    return cadena;
  }

  /**
   * Msg.
   *
   * @param entero the entero
   */
  public static void msg(int entero) {
    System.out.print(entero);
  }

  /**
   * Msg.
   *
   * @param enteroLargo the entero largo
   */
  public static void msg(long enteroLargo) {
    System.out.print(enteroLargo);
  }

  /**
   * Msg.
   *
   * @param real the real
   */
  public static void msg(float real) {
    System.out.print(real);
  }

  /**
   * Msg.
   *
   * @param realLargo the real largo
   */
  public static void msg(double realLargo) {
    System.out.print(realLargo);
  }

  /**
   * Msg.
   *
   * @param cadenaAImprimir the cadena a imprimir
   */
  public static void msg(String cadenaAImprimir) {
    System.out.print(cadenaAImprimir);
  }

  /** Msgln. */
  public static void msgln() {
    System.out.println();
  }

  /**
   * Msgln.
   *
   * @param entero the entero
   */
  public static void msgln(int entero) {
    System.out.println(entero);
  }

  /**
   * Msgln.
   *
   * @param enteroLargo the entero largo
   */
  public static void msgln(long enteroLargo) {
    System.out.println(enteroLargo);
  }

  /**
   * Msgln.
   *
   * @param real the real
   */
  public static void msgln(float real) {
    System.out.println(real);
  }

  /**
   * Msgln.
   *
   * @param realLargo the real largo
   */
  public static void msgln(double realLargo) {
    System.out.println(realLargo);
  }

  /**
   * Msgln.
   *
   * @param cadenaAImprimir the cadena a imprimir
   */
  public static void msgln(String cadenaAImprimir) {
    System.out.println(cadenaAImprimir);
  }

  /**
   * Lee una fecha de teclado, correctamente validada, mostrando un mensaje por pantalla que la
   * solicita.
   *
   * @param mensaje Es el mensaje que se envía solicitando la introducción de la fecha.
   * @return Una fecha como String en formato dd-mm-aa, ya validada y correcta.
   */
  public static String leeRespuesta(String mensaje) {
    boolean correcta = false;
    String cadena = "";
    Scanner teclado = null;
    do {
      ES.msgln(mensaje);
      try {
        teclado = new Scanner(System.in);
        cadena = teclado.nextLine();
        if (cadena != null
            && cadena.length() == 1
            && ((cadena.equalsIgnoreCase("S")) || (cadena.equalsIgnoreCase("N")))) {
          correcta = true;
        } else {
          ES.msgln(
              "Error: Solo se admite como respuesta un Ăşnico carĂĄcter, que debe ser 's', 'S', 'n' o 'N'.");
        }
      } catch (Exception e) {
        ES.msgln("Error: Ha fallado la entrada de datos.");
      }
    } while (!correcta);
    return cadena.toUpperCase();
  }
} // class ES
