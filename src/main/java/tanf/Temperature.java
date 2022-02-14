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
            File file = new File("c:\\work\\cleancodeown\\src\\main\\resources\\datamunging\\weather.dat");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = null;
            List<TemperatureData> temperatureDataList = new ArrayList<TemperatureData>();
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    //System.out.println("Original line: [" + line + "]");
                    line = line.replaceAll("\\s+", " ").trim();
                    //System.out.println("Modified line: [" + line + "]");
                    String[] lineData = line.split(" ");    //de csak mert az elso 3 oszlop kell es ott jo igy
                    System.out.println("Nap/max/min = [" + lineData[0] + "][" + lineData[1] + "][" + lineData[2] + "]");
                    if (lineData[0].matches("[0-9]+")) {
                        TemperatureData tData = new TemperatureData(lineData);
                        temperatureDataList.add(tData);
                    }
                }
            }

            int resultDay = findMinDiff(temperatureDataList);

            System.out.println("Melyik napon a lekisebb a homerseklet kulonbseg: " + resultDay);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findMinDiff(List<TemperatureData> temperatureDataList) {
        int day = -1;
        int minDiff = 1000;
        for(TemperatureData td: temperatureDataList){
            if (minDiff > td.getDifference()) {
                minDiff = td.getDifference();
                day = td.getDay();
            }
        }
        return day;
    }

    public static int parseTemperature(String adat){
        adat = adat.replaceAll("[^0-9.-]", "");
        return Integer.parseInt(adat);
    }
}
