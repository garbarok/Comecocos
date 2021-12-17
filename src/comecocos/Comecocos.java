package comecocos;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Clase Comecocos
 */
public class Comecocos {

    private int x;
    private int y;
    private Direccion direccion;

    /**
     * Instancias de comecocos que recibe x,y,direccion
     *
     * @param x         the x
     * @param y         the y
     * @param direccion the direccion
     */
    public Comecocos(int x, int y, Direccion direccion) {
        this.x = x;
        this.y = y;
        this.direccion = direccion;
    }


    /**
     * Instancia de Comecocos cuando no recibe parámetros.
     */
    public Comecocos() {
        x = 0;
        y = 0;
        direccion = Direccion.NORTE;
    }

    /**
     * Grados adireccion string.
     * Metodo estatico que transforma los grados que recibe
     * por parametro a tipo direccion.
     * @param grados the grados
     * @return the string
     */
    public static Direccion gradosAdireccion(int grados) {
        Direccion convertida = null;
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
     * ToString.
     * Metodo que devuelve un mensaje con la información que queremos.
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
     * Gets direccion.
     *
     * @return the direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Sets direccion.
     *
     * @param direccion the direccion
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Sets gira derecha.
     * Metodo set que gira el comecocos a la derecha cambiando el atributo direccion.
     */
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

    /**
     * Sets gira izquierda.
     */
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
     * Sets avanzar.
     *Metodo que hace avanzar 10 pasos adelante en el eje en el que se encuentre
     * mirando al comecocos. Obitiene que direccion tiene el comecocos y segun esta añade
     * el valor de los pasos o los resta al eje de abcisas u ordenadas segun
     * corresponda.
     * @param pasos the pasos
     */
    public void setAvanzar(int pasos) {
        if (getDireccion().equals(Direccion.NORTE)) {
            y = y + pasos;
            setY(y);
        } else if (getDireccion().equals(Direccion.ESTE)) {
            x = x + pasos;
        } else if (getDireccion().equals(Direccion.SUR)) {
            y = y - pasos;
            setY(y);
        } else if (getDireccion().equals(Direccion.OESTE)) {
            x = x - pasos;
            setX(x);
        }

    }

    /**
     * Direccion agrados int.
     * Metodo que pasa la direccion del tipo direccion a grados numericos.
     * @param direccion the direccion
     * @return the int
     */
    public int direccionAgrados(Direccion direccion) {

        int grados = 1;
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
        return grados;
    }

    /**
     * Reproducir sonido.
     *
     * @param nombreSonido the nombre sonido
     */
    public void reproducirSonido(String nombreSonido) {

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(2000);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * The enum Direccion.
     */
    enum Direccion {
        /**
         * Norte direccion.
         */
        NORTE,
        /**
         * Sur direccion.
         */
        SUR,
        /**
         * Este direccion.
         */
        ESTE,
        /**
         * Oeste direccion.
         */
        OESTE
    }


}
