
package ohtu;

public class Player {
    private String name;
    private String team;
    private int goals;
    private int assists;
    private String nationality;

    public Player(String name, String team, int goals, int assists, String nationality) {
        this.name = name;
        this.team = team;
        this.goals = goals;
        this.assists = assists;
        this.nationality = nationality;
    }

    public String getTeam() {
        return team;
    }

    public String getNationality() {
        return nationality;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }
    public int getPoints(){
        return assists + goals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "   " + team + "   " + goals + " + " + assists + " = " + (goals+assists);
    }

}
