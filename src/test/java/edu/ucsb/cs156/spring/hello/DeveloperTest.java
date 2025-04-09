package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Mihir K", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_id() {
        assertEquals("mihir-r-kondapalli", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_members() {
        Team correct_team = new Team("s25-10");
        correct_team.addMember("Andrew C");
        correct_team.addMember("Benjamin S");
        correct_team.addMember("Junjie L");
        correct_team.addMember("Linghe Z");
        correct_team.addMember("Mihir K");
        correct_team.addMember("Milad H");
        Team dteam = Developer.getTeam();
        assert(dteam.getName() == "s25-10");
        assert(dteam.getMembers().contains("Andrew C"));
        assert(dteam.getMembers().contains("Benjamin S"));
        assert(dteam.getMembers().contains("Junjie L"));
        assert(dteam.getMembers().contains("Linghe Z"));
        assert(dteam.getMembers().contains("Mihir K"));
        assert(dteam.getMembers().contains("Milad H"));
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
