import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void recursiveDelete(File file) {
        if (!file.exists())
            return;

        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                recursiveDelete(f);
            }
        }

        file.delete();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);

        GeneratorBMD generatorBMD = new GeneratorBMD();
        GeneratorVert generatorVert = new GeneratorVert(180, 23, 12, 30, 8);
        generatorVert.generatorVertices();
        generatorVert.generatorEdges();
        generatorBMD.exportBlockMeshDict(generatorVert.pointsToString(), generatorVert.edgesToString());
        GeneratorU generatorU = new GeneratorU();
        generatorU.exportU("0.41246");

        // delete all number folders except 0 in calculate folder
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 10; j ++) {
                String x = i + "." + j;
                File file = new File("calculate/" + x);
                if (file.exists()) {
                    recursiveDelete(file);
                }
            }
        }

        System.out.println("Complete rm");

        try {
            //ProcessBuilder builder = new ProcessBuilder();
            //builder.command("sh", "-c", System.getProperty("user.dir") + "/calculate/Run.sh");
            ProcessBuilder builder = new ProcessBuilder("bash", System.getProperty("user.dir") + "/calculate/Run.sh");

            Process process = builder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader readerErr = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            while ((line = readerErr.readLine()) != null) {
                System.err.println(line);
            }

            // Получите код завершения
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}