package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void check_equals_true() {
        assertEquals(true, team.equals(team));
        Team otherTeam = new Team("test-team");
        assertEquals(true, team.equals(otherTeam));
        assertEquals(false, team.equals(null));
        Team anotherTeam = new Team("test-team");
        assertEquals(true, otherTeam.equals(anotherTeam));
        anotherTeam.addMember("mihir");
        otherTeam.addMember("mihir");
        assertEquals(true, otherTeam.equals(anotherTeam));
    }

    @Test
    public void check_equals_diff_names() {
        Team t1 = new Team("team1");
        Team t2 = new Team("team2");
        assertEquals(false, t1.equals(t2));
    }

    @Test
    public void check_equals_diff_members() {
        Team t1 = new Team("team");
        Team t2 = new Team("team");
        t1.addMember("a");
        t2.addMember("b");
        assertEquals(false, t1.equals(t2));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void check_hashcode_same() {
        Team t1 = new Team();
        t1.setName("test-team");
        t1.addMember("mihir");
        Team t2 = new Team();
        t2.setName("test-team");
        t2.addMember("mihir");
        assert(t1.hashCode() == t2.hashCode());
    }

    @Test
    public void check_hashcode_names_diff() {
        Team t1 = new Team();
        t1.setName("test-team1");
        t1.addMember("mihir");
        Team t2 = new Team();
        t2.setName("test-team2");
        t2.addMember("mihir");
        assert(t1.hashCode() != t2.hashCode());
    }

    @Test
    public void check_hashcode_members_diff() {
        Team t1 = new Team();
        t1.setName("test-team");
        t1.addMember("not mihir");
        Team t2 = new Team();
        t2.setName("test-team");
        t2.addMember("mihir");
        assert(t1.hashCode() != t2.hashCode());
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
