//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Obtain the same instance twice
        LoggerSingleton logger1 = LoggerSingleton.getInstance();
        LoggerSingleton logger2 = LoggerSingleton.getInstance();

        // Use the logger
        logger1.log("Hello, Singleton!");

        // Verify both references point to the same object
        System.out.println("logger1 == logger2 ? " + (logger1 == logger2));
    }
}