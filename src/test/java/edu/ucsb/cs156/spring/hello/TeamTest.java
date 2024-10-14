package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_bool() {
        Team other = new Team("test-team");
        team.addMember("John");
        team.addMember("Bob");
        other.addMember("John");
        other.addMember("Bob");
        assertEquals(true, team.equals(team));
        assertEquals(false, team.equals("hi"));

        assertEquals(true, team.equals(other));
        other.addMember("Tom");
        assertEquals(false, team.equals(other));
        other.setName("team");
        assertEquals(false, team.equals(other));

    }

    @Test
    public void hashCode_returns_correct_number() {
        Team other = new Team("test-team");
        team.addMember("John");
        team.addMember("Bob");
        other.addMember("John");
        other.addMember("Bob");
        assertEquals(team.hashCode(), other.hashCode());
        int result = team.hashCode();
        int expectedResult = -1225785413;
        assertEquals(expectedResult, result);
    }
}
