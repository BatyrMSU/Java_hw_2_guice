package guice_homework;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class Main {

    public static void main(@NotNull String[] args) {
        final Injector injector = Guice.createInjector(new Module());
        injector.getInstance(Application.class).waitForInput(args);
    }

}
