/**
 * La classe Timer permet de mesurer le temps écoulé entre un démarrage et un arrêt.
 */
public class Timer {
    private long startTime;
    private long endTime;

    /**
     * Démarre le timer en enregistrant le temps actuel.
     */
    public void start() {
        startTime = System.nanoTime();
    }

    /**
     * Arrête le timer en enregistrant le temps actuel.
     */
    public void stop() {
        endTime = System.nanoTime();
    }

       /**
     * Calcule et retourne le temps écoulé entre le démarrage et l'arrêt du timer.
     * @return Le temps écoulé en nanosecondes.
     */
    public long getElapsedTime() {
        return endTime - startTime;
    }
}
