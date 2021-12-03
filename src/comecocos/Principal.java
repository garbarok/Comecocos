package comecocos;

import comecocos.Comecocos.Direccion;
import util.ES;

import java.util.Scanner;


/**
 * Clase Principal para la creación del comecocos y su control según las
 * entradas de teclado.
 * Al principio del programa se leen la posición x, la posición y del comecocos,
 * así como la dirección hacia la que se dirigirá el comecocos. Esta dirección
 * se pide como un número entero, el usuario deberá introducir 0 si quiere que
 * el comecocos mire hacia el Norte, 90 si quiere que mire al Este, 180 si desea
 * que mire al Sur y 270 si quiere que mire al Oeste.
 * Si el usuario introdujo bien los datos, se crea el objeto comecocos con el
 * constructor con parámetros, pasándole los datos leídos por teclado y a
 * continuación se invoca a un método controlarComecocos.
 *
 * @author Oscar Gallego
 */
public class Principal {

    /**
     * Pide las posiciones x e y del comecocos, así como los grados de la
     * dirección de partida, es decir, se espera que el usuario introduzca
     * 0, 90, 180 o bien 270. Si no introduce como grados uno de esos datos, el
     * programa terminará la ejecución. Si introduce un valor permitido,
     * entonces el programa creará el objeto comecocos mediante el constructor
     * con parámetros, escribirá la posición inicial y se invocará a un método
     * para controlar al comecocos, en función de las entradas por teclado.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int x;
        int y;
        Direccion dir = Direccion.NORTE;


        // Pedir los datos iniciales para crear otro comecocos

        x = ES.leeEntero("Introduce la posición x del comecocos: ", 0);
        y = ES.leeEntero("Introduce la posición y del comecocos: ", 0);

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce la dirección del comecocos (0, 90, 180, 270): ");
        int entradaGrados = entrada.nextInt();

        /* Si son válidos los datos que hemos leído por teclado, entonces
        creamos el objeto con los datos leídos */

        if (numeroEntero(entradaGrados)) {
            Comecocos player1 = new Comecocos(x, y, dir);
            player1.gradosAdireccion(entradaGrados);

            // Escribir posición inicial
            System.out.println("El comecocos recién creado está en: " + player1);
            // Controlar al comecocos según las órdenes recibidas por teclado
            System.out.println("Escriba:");

            int eleccion;
            do {
                eleccion = entradaTeclado(String.format("0-> Avanzar 10 pasos.\n1-> Girar a la derecha.\n2-> Girar a la izquierda.\n3-> Emitir sonido.\n4-> Salir del programa."));
                switch (eleccion) {
                    case 0:
                        player1.setAvanzar(10);
                        System.out.println("El comecocos está en: " + player1);
                        break;
                    case 1:
                        player1.setGiraDerecha();
                        System.out.println("El comecocos está en: " + player1);
                        break;
                    case 2:
                        player1.setGiraIzquierda();
                        System.out.println("El comecocos está en: " + player1);
                        break;
                    case 3:
                        player1.ReproducirSonido("/Users/garbarok/IdeaProjects/Comecocos/src/recursos/pacmandie.wav");
                        break;
                }
            } while (eleccion != 4);
        } else {
            System.out.println("Juego terminado, no introdujo los grados correctamente. ");
        }


        // SINO
        // Indica que el se juego se ha terminado.

    }


    /**
     * Método que está continuamente leyendo de teclado un número entero,
     * indicando al usuario las opciones:
     * 0-> Avanzar 10 pasos.
     * 1-> Girar a la derecha.
     * 2-> Girar a la izquierda.
     * 3-> Emitir sonido.
     * 4-> Salir del programa
     *
     * @param mensaje Objeto comecocos creado al principio del programa,
     *                <p>
     *                Método que comprueba si es válido el número introducido, entendiendo por válido que
     *                sea uno de los siguientes valores: 0, 90, 180 o bien 360.
     * @return Devuelve true si el parámetro recibido es 0, 90, 180 o bien 360.
     */

    private static int entradaTeclado(String mensaje) {
        int numero = 1;
        boolean leido = false;
        Scanner teclado = null;
        do {
            ES.msgln(mensaje);
            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextInt();
                if ((numero == 0) | (numero == 1) | (numero == 2) | (numero == 3) | (numero == 4)) {
                    return numero;
                } else {
                    ES.msgln("Error. Introduzca uno de los siguientes números: ");
                }
            } catch (Exception e) {
                ES.msgln("Error: No es un número entero válido. ");
            }

        } while (numero != 4);
        return numero;
    }


    /**
     * Método que comprueba si es válido el número introducido, entendiendo por válido que
     * sea uno de los siguientes valores: 0, 90, 180 o bien 360.
     *
     * @param numero Número entero.
     * @return Devuelve true si el parámetro recibido es 0, 90, 180 o bien 360.
     */
    private static boolean numeroEntero(int numero) {
        boolean esEntero = (numero == 0) | (numero == 90) | (numero == 180) | (numero == 270);

        return esEntero;
    }
}


// Mientras que no se cumpla la condición de terminación


// Informar de opciones y leer número entero correspondiente a la opción a ejecutar


// Según lo leído, invocar al método pertienente


// Informar sobre la posición del comecocos






