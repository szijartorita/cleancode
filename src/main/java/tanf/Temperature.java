package tanf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Temperature {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
            String line = null;
            int i = 0;
            List<TemperatureData> homersekletAdatList = new ArrayList<>();
            List<Integer> avarages = new ArrayList<>();
            while ((line = br.readLine())!= null){
                if (i > 0){
                    String[] lineData = line.split(" ");
                    TemperatureData adat = new TemperatureData();
                    adat.setMnt(Integer.parseInt(lineData[2]));
                    adat.setMxt(Integer.parseInt(lineData[1]));
                }
                i++;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int parseTemperature(String adat){
        if(adat.contains("*")){
            adat = adat.substring(0, adat.indexOf("*"));
        }
        return Integer.parseInt(adat);
    }
}
