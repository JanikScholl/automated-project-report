import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

class OverwriteTemplates {

    //private Report report;

    static void writeTitelPage() throws IOException {                                        //selbe prozedur wir in writeIntroduction()
        Path template = Main.baseFolder.resolve("templates").resolve("titelPage.tex");
        Path target = Main.baseFolder.resolve("output").resolve("titelPage-out.tex");
        String content = new String(Files.readAllBytes(template));
        Files.write(target, content.getBytes(StandardCharsets.UTF_8));
    }

    static void writeManagementSummaryPage() throws IOException {                                        //selbe prozedur wir in writeIntroduction()
        Path template = Main.baseFolder.resolve("templates").resolve("managementSummaryPage.tex");
        Path target = Main.baseFolder.resolve("output").resolve("managementSummaryPage-out.tex");
        String content = new String(Files.readAllBytes(template));
        Files.write(target, content.getBytes(StandardCharsets.UTF_8));
    }

    //Todo: find a way to insert date. Static Overwrite class prevents the dynamic use of
    //Todo: getDateInfo(), creating an overwrite instance in main and copying the Report Value into it solves the problem
    //Todo: but seems to be not the moste elegant way. This is for copyReportData() aswell as writeQuickInfoPage().

    //public void copyReportData(Report report){ this.report=report;}

    static void writeQuickInfoPage() throws IOException {
        Path template = Main.baseFolder.resolve("templates").resolve("quickInfoPage.tex");
        Path target = Main.baseFolder.resolve("output").resolve("quickInfoPage-out.tex");
        String content = new String(Files.readAllBytes(template));
        content = content.replace("<test>","erfolg");
        Files.write(target, content.getBytes(StandardCharsets.UTF_8));
    }

    static void writeMainPage() throws IOException {
        Path template = Main.baseFolder.resolve("templates").resolve("main-page.tex");
        Path target = Main.baseFolder.resolve("output").resolve("main-page-out.tex");
        String content = new String(Files.readAllBytes(template));
        Files.write(target, content.getBytes(StandardCharsets.UTF_8));
    }


}
