package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        String url = "https://nhl27112019.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        QueryBuilder query = new QueryBuilder();

        Matcher m1 = query.playsIn("PHI")
                .hasAtLeast(12, "assists")
                .hasFewerThan(10, "goals").build();

        Matcher m2 = query.playsIn("CAL")
                .hasAtLeast(12, "points").build();

        Matcher m = query.oneOf(m1, m2).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
