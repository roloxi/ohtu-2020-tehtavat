
package ohtu;

public class Player implements Comparable {
    private String name;
    private String nationality;
    private int assists;
    private int goals;
    private String team;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getScore() {
        return goals + assists;
    }

    @Override
    public String toString() {
        return name + " " + team + " " + goals + " + " + assists + " = " + getScore();
    }

    @Override
    public int compareTo(Object other) {
        Player otherPlayer = (Player) other;
        return otherPlayer.getScore() - this.getScore();
    }
}
