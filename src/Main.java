import interfaces.Runnable;
import program.Program;

void main() {
    // initial entry point of the program
    runApp(new Program());
}


// this is for organizing the program
// which follow a consistence flow of the program lifetime
<T extends Runnable> void runApp(Program app) {
    app.init();
    app.run();
    app.dispose();
}

