package ohtuesimerkki;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
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
    public void searchFindsPlayer() {
        Player player = stats.search("Semenko");
        assertEquals(readerStub.getPlayers().get(0).toString(), player.toString());
    }

    @Test
    public void searchReturnsNullIfPlayerNotFound() {
        assertEquals(null, stats.search("Null"));
    }

    @Test
    public void teamReturnsCorrectTeam() {
        List<Player> actual = stats.team("EDM");
        List<Player> expect = new ArrayList<>();
        expect.add(readerStub.getPlayers().get(0));
        expect.add(readerStub.getPlayers().get(2));
        expect.add(readerStub.getPlayers().get(4));
        assertEquals(expect.toString(), actual.toString());
    }

    @Test
    public void topScorersReturnsCorrectlySortedList() {
        List<Player> actual = stats.topScorers(2);
        List<Player> expect = new ArrayList<>();
        expect.add(readerStub.getPlayers().get(4));
        expect.add(readerStub.getPlayers().get(1));
        expect.add(readerStub.getPlayers().get(3));
        assertEquals(expect.toString(), actual.toString());
    }

}
