package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference."
)

public class App implements Runnable {

    @Parameters(index = "0", description = "path to first file", defaultValue = "/etc/hosts")
    private File filepath1 = new File("/etc/hosts");
    @Parameters(index = "1", description = "path to second file", defaultValue = "/etc/hosts")
    private File filepath2 = new File("/etc/hosts");

    @Option(names = {"-f", "--format"},
            description = "output format [default: stylish]")
    private String format = "stylish";

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }

    @Override
    public void run() {}

}
