import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {

    static final Path baseFolder = Paths.get(System.getProperty("user.dir"));

    public static void main(String[] args) throws IOException {
       // OverwriteTemplates.writePage1();
        OverwriteTemplates.writeIntroduction();
        OverwriteTemplates.writeMainPage();
        buildPdf();
    }

    private static void buildPdf() throws IOException {
        ProcessBuilder pb = new ProcessBuilder();
        // To use a bibliography the process is: latex -> bibtex -> latex -> latex
        pb.directory(baseFolder.toFile());
        pb.command("pdflatex", "main-page.tex");
        consumeOutput(pb.start());
        consumeOutput(pb.start()); // run it twice for the TOC to be built with correct links

        // clean up temporary tex-build-files
        for (File file : Objects.requireNonNull(baseFolder.toFile().listFiles())) {
            if (file.getName().endsWith(".aux") || file.getName().endsWith(".toc")
                    || file.getName().endsWith(".log") || file.getName().endsWith(".blg")) {
                file.delete();
            }
        }
    }


    private static void consumeOutput(Process proc) throws IOException { // via stackoverflow.com/a/5711150
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
        String s;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
        while ((s = stdError.readLine()) != null) {
            System.err.println(s);
        }
    }
}
