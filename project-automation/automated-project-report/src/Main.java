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

        Report report= new Report();

        //Creates the desired Pages
        //Todo: create functions for every page
        if(report.getTitelPage()){OverwriteTemplates.writeTitelPage();};
        if(report.getQuickInfoPage()){OverwriteTemplates.writeQuickInfoPage();};
        if(report.getManagementSummaryPage()){OverwriteTemplates.writeManagementSummaryPage();};

        //Joins all Pages and Prints the Document
        OverwriteTemplates.writeMainPage();
        buildPdf();

    }

    private static void buildPdf() throws IOException {
        ProcessBuilder pb = new ProcessBuilder();
        // To use a bibliography the process is: latex -> bibtex -> latex -> latex
        pb.directory(baseFolder.resolve("output").toFile());
        pb.command("pdflatex", "main-page-out.tex");
        consumeOutput(pb.start());
        consumeOutput(pb.start()); // run it twice for the TOC to be built with correct links

        // clean up temporary tex-build-files
        for (File file : Objects.requireNonNull(baseFolder.resolve("output").toFile().listFiles())) {
            if (file.getName().endsWith(".aux") || file.getName().endsWith(".toc")
                    || file.getName().endsWith(".log") || file.getName().endsWith(".blg") || file.getName().endsWith("-out.tex")) {
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
