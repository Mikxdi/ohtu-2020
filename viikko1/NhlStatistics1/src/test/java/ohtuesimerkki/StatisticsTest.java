package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class StatisticsTest {

    double vertailuTarkkuus = 0.0001
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void playerSearchFound(){
        assertEquals(stats.search("Kurri").getPoints(), 90);
    }

    @Test
    public void playerSearchIsNotFound(){
        assertEquals(stats.search("Pekka"), null);
    }

    @Test
    public void foundPlayersWithTeamName(){
        assertEquals(stats.team("EDN").size(), 3);
    }

    @Test
    public void topScorer(){
        assertEquals(stats.topScorers(1).get(0).getName(), "Gretzky");
    }
}

