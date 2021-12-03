package comecocos;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * The type Comecocos.
 */
public class Comecocos {

    private int x;
    private int y;

    /**
     * The enum Direccion.
     */
    public static enum Direccion {
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
        OESTE}

    /**
     * The Dir.
     */
    Direccion dir;

    /**
     * Instantiates a new Comecocos.
     *
     * @param x   the x
     * @param y   the y
     * @param dir the dir
     */
    public Comecocos(int x, int y, Direccion dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    /**
     * Instantiates a new Comecocos.
     */
    public Comecocos() {
        this.x = 0;
        this.y = 0;
        this.dir = Direccion.NORTE;
    }

    /**
     * Getter.
     *
     * @return abscisa (columna).
     */
    public int getX() {
        return x;
    }

    /**
     * Getter.
     *
     * @return ordenada (fila).
     */
    public int getY() {
        return y;
    }

    /**
     * Getter.
     *
     * @return Dirección. direccion
     */
    public Direccion getDireccion() {
        return dir;
    }

    /**
     * Setter.
     *
     * @param x the x
     * @return ordenada (fila).
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Setter.
     *
     * @param y the y
     * @return abcisa (fila).
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Setter.
     *
     * @param dir the dir
     * @return dirección
     */
    public void setDireccion(Direccion dir) {
        this.dir = dir;
    }

    public String toString() {
        String mensaje = "Coordenadas x=" + x + ", y=" + y + ", con dirección=" + dir;
        return mensaje;
    }


    /**
     * Sets gira derecha.
     */
    public void setGiraDerecha() {

        switch (dir) {
            case NORTE:
                dir = Direccion.ESTE;
                break;
            case ESTE:
                dir = Direccion.SUR;
                break;
            case SUR:
                dir = Direccion.OESTE;
                break;
            case OESTE:
                dir = Direccion.NORTE;
                break;
        }
    }

    /**
     * Sets gira izquierda.
     */
    public void setGiraIzquierda() {

        switch (dir) {
            case NORTE:
                dir = Direccion.OESTE;
                break;
            case OESTE:
                dir = Direccion.SUR;
                break;
            case SUR:
                dir = Direccion.ESTE;
                break;
            case ESTE:
                dir = Direccion.NORTE;
                break;
        }
    }

    /**
     * Sets avanzar.
     *
     * @param pasos the pasos
     */
    public void setAvanzar(int pasos) {
        if (getDireccion().equals(Direccion.NORTE)) {
            y = y - pasos;
            setY(y);
        } else if (getDireccion().equals(Direccion.ESTE)) {
            x = x + pasos;
        } else if (getDireccion().equals(Direccion.SUR)) {
            y = y + pasos;
            setY(y);
        } else if (getDireccion().equals(Direccion.OESTE)) {
            x = x - pasos;
            setX(x);
        }

    }

    /**
     * Grados adireccion string.
     *
     * @param grados the grados
     * @return the string
     */
    public String gradosAdireccion(int grados) {

        switch (grados) {
            case 0:
                setDireccion(Direccion.NORTE);
                break;
            case 90:
                setDireccion(Direccion.ESTE);

                break;
            case 180:
                setDireccion(Direccion.SUR);

                break;
            case 270:
                setDireccion(Direccion.OESTE);

                break;
        }

        return String.valueOf(getDireccion());

    }

    /**
     * Direccion agrados int.
     *
     * @param dir the dir
     * @return the int
     */
    public int direccionAgrados(Direccion dir) {

        int grados = 0;
        switch (dir) {
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
    public void ReproducirSonido(String nombreSonido){

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(2000);
        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
