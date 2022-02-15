package football;

import java.util.Arrays;

public class ResultRow {

    private String[] originalLine;
    private String teamName;
    private int scoredGoals;
    private int gotGoals;

    public ResultRow(String[] line) {
        this.originalLine = line;
        init();
    }

    private void init(){
        this.teamName = originalLine[1];
        this.scoredGoals = parseResult(originalLine[6]);
        this.gotGoals = parseResult(originalLine[8]);
    }

    public int getGoalDifference(){
        return Math.abs(this.getGotGoals() - this.getScoredGoals());
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public int getGotGoals() {
        return gotGoals;
    }

    public void setGotGoals(int gotGoals) {
        this.gotGoals = gotGoals;
    }

    public int parseResult(String data){
        return Integer.parseInt(data);
    }

    @Override
    public String toString() {
        return "ResultRow{" +
                "originalLine=" + Arrays.toString(originalLine) +
                ", teamName='" + teamName + '\'' +
                ", scoredGoals=" + scoredGoals +
                ", gotGoals=" + gotGoals +
                ", diff=" + getGoalDifference() +'}';
    }
}
