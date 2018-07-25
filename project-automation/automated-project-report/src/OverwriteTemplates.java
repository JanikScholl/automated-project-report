import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

class OverwriteTemplates {

    static void writeIntroduction() throws IOException {
        Path template = Main.baseFolder.resolve("templates").resolve("introduction.tex");
        Path target = Main.baseFolder.resolve("introduction.tex");
        String content = new String(Files.readAllBytes(template));
        content = content.replace("<REPLACE_ME>",
                "I still think Janik is wonderful.");
        String replacePath = "figures/daumen.png";
        content = content.replace("<REPLACE_ME_IMAGE>", replacePath);

        Files.write(target, content.getBytes(StandardCharsets.UTF_8));
    }


    static void writeMainPage() throws IOException {
        Path template = Main.baseFolder.resolve("templates").resolve("main-page.tex");
        Path target = Main.baseFolder.resolve("main-page.tex");
        String content = new String(Files.readAllBytes(template));
        Files.write(target, content.getBytes(StandardCharsets.UTF_8));
    }


    static void writePage1() throws IOException {
        Path template = Main.baseFolder.resolve("templates").resolve("page1.tex");
        Path target = Main.baseFolder.resolve("page1.tex");
        String content = new String(Files.readAllBytes(template));
        Files.write(target, content.getBytes(StandardCharsets.UTF_8));
    }
}
