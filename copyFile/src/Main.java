import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void main(String[] args)
    {
        copyFolder();

    }

    private static void copyFolder() {
        String sourceFile = "C:\\Users\\lee_chen\\Desktop\\example\\Members";
        String targetFile = "C:\\Users\\lee_chen\\Desktop\\example\\Company";
        try {
            FileUtils.copyDirectory(new File(sourceFile),new File(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile() {
        String sourceFile ="C:\\Users\\lee_chen\\Desktop\\example\\source\\Account.txt";
        String targetFile ="C:\\Users\\lee_chen\\Desktop\\example\\target\\Account.txt";

        Path sourcePath = new File(sourceFile).toPath();
        Path targetPath = new File(targetFile).toPath();
        try {
            Files.copy(sourcePath,targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
