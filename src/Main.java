import interfaces.Runnable;
import program.Program;

void main() {
    runApp(new Program());
}


<T extends Runnable> void runApp(Program app) {
    app.run();
}

