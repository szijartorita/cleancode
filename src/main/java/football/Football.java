package football;

import java.io.File;
import java.util.List;

public class Football {

    public static void main(String[] args) {
        File file = new File("c:\\work\\cleancodeown\\src\\main\\resources\\datamunging\\football.dat");
        ResultReader reader = new ResultReader(file);
        List<ResultRow> resultRows = reader.parseResults();
        String minDiffTeam = findMinDiffTeam(resultRows);
        System.out.println("Winner team is: " + minDiffTeam);
    }

    private static String findMinDiffTeam(List<ResultRow> resultRows) {
        String team = null;
        int minDiff = 1000;
        for(ResultRow result: resultRows){
            System.out.println("actual row: " + result);
            if (minDiff > result.getGoalDifference()) {
                minDiff = result.getGoalDifference();
                team = result.getTeamName();
            }
        }
        return team;
    }
}
