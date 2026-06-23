package interfaces;

// for defining program flow
public interface Runnable {

    // this start the program
    void run();

    // to release the resources before terminating
    void dispose();

    // before start the program always initialize necessary resources
    void init();

}
