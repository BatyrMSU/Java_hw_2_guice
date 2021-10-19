package guice_homework;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {
    public int N;
    public String tag;

    MyFormatter(@NotNull int mode, @NotNull String tag) {
        N = mode;   // console: mode=0,  file: mode=1
        this.tag = tag;
    }

    @Override
    public String format(LogRecord record) {
        String str = String.valueOf(N) + ": " + "<" + this.tag + ">"
                + record.getMessage() + "</" + this.tag + ">\n";
        N++;
        return str;
    }
}
