package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
        name = "gendiff",
        description = "Compares two configuration files and shows a difference."
)

public class App implements Runnable {

    /*@Option(names = {"-h", "--help"}, description = "Show this help message and exit.")
    private Boolean optionHelp = false;

    @Option(names = {"-v", "--version"}, description = "Print version information and exit.")
    private Boolean optionVersion = false;*/

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }

    @Override
    public void run() {

        //todo нужно вывести описание команд, как это сделать - наверное, написано в примере
    }

}
