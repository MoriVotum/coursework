import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
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
            for (double j = 0.1; j < 1; j += 0.1) {
                double x = i + j;
                File file = new File("calculate/" + x);
                if (file.exists()) {
                    file.delete();
                }
            }
        }

        try {
            // Укажите путь к вашему bash-скрипту
            String scriptPath = "/calculate/Run.sh";

            // Создайте объект ProcessBuilder с командой для выполнения скрипта
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", scriptPath);

            // Запустите процесс
            Process process = processBuilder.start();

            // Получите вывод (stdout) скрипта
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Получите код завершения
            int exitCode = process.waitFor();
            System.out.println("Exit Code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}