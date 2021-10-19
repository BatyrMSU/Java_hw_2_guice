package guice_homework;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Application {

    private Logger logger = Logger.getLogger(Application.class.getName());
    Handler handler1;
    Handler handler2;

    public int mode;
    public String tag;

    @Inject
    public Application(@NotNull Handler handler1,
                       @MyFileHandler @NotNull Handler handler2) {

        logger.setUseParentHandlers(false);
        this.handler1 = handler1;
        this.handler2 = handler2;
    }


    private void validateArgs(@NotNull String[] args) {
        mode = Integer.parseInt(args[0]);
        tag = args[1];
    }

    private void logSetUp() {
        if (mode == 0) {
            this.handler1.setFormatter(new MyFormatter(0, tag));
            logger.addHandler(handler1);
        } else if (mode == 1) {
            this.handler2.setFormatter(new MyFormatter(1, tag));
            logger.addHandler(handler2);
        } else {
            this.handler1.setFormatter(new MyFormatter(0, tag));
            logger.addHandler(handler1);
            this.handler2.setFormatter(new MyFormatter(1, tag));
            logger.addHandler(handler2);
        }
    }


    public void waitForInput(@NotNull String[] args) {
        validateArgs(args);
        logSetUp();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                String s = scanner.nextLine();
                logger.info(s);
            }
        } catch (IllegalStateException | NoSuchElementException e) {

        }
    }

}
