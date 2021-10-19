package guice_homework;

import com.google.inject.AbstractModule;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

public class Module extends AbstractModule {

    @Override
    protected void configure() {

        bind(Handler.class).toInstance(new ConsoleHandler());

        try {
            bind(Handler.class).annotatedWith(MyFileHandler.class).toInstance(new FileHandler("java_guice_hw.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
