package football;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultReader {

    private File inputFile;

    public ResultReader(final File inputFile){
        this.inputFile = inputFile;
    }

    public List<ResultRow> parseResults(){
        List<ResultRow> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));) {
            String line = null;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty() && !line.trim().startsWith("-")) {
                    System.out.println("Original line: [" + line + "]");
                    line = line.replaceAll("\\s+", " ").trim();
                    String[] lineData = line.split(" ");
                    if (lineData[0].matches("[0-9.]+")) {
                        ResultRow tData = new ResultRow(lineData);
                        rows.add(tData);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
