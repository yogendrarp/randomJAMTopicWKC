package wkc;

import javax.inject.Singleton;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Singleton
public class UserSession {

    static List<String> teams = new ArrayList<>();
    static List<String> topics = new ArrayList<>();

    private String teamsFile = "teams.txt";

    private String topicsFile = "topics.txt";


    public UserSession() throws IOException {
        getTeams();
        getTopics();
    }

    private void addTeamToText(String team) throws IOException {
        String filePath = "/Users/yogendraprabhu/team.txt";
        FileWriter writer = new FileWriter(filePath, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(String.format("%s\n", team));
        bufferedWriter.close();
    }

    private void addTopicToText(String topic) throws IOException {
        String filePath = "/Users/yogendraprabhu/Topic.txt";
        FileWriter writer = new FileWriter(filePath, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(String.format("%s\n", topic));
        bufferedWriter.close();
    }

    private void getTopics() throws IOException {
        File file = new File("/Users/yogendraprabhu/Code/teamtopicselector/build/resources/main/" + topicsFile);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            topics.add(st);
        }
    }

    private void getTeams() throws IOException {
        File file = new File("/Users/yogendraprabhu/Code/teamtopicselector/build/resources/main/" + teamsFile);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            teams.add(st);
        }
    }

    public Topic getTopic() throws IOException {
        if (teams.size() > 0) {
            Random random = new Random();
            int randomTopicNUmber = random.nextInt(topics.size());
            String topic = topics.get(randomTopicNUmber);
            topics.remove(topic);
            addTopicToText(topic);
            return new Topic(topic);
        }
        return new Topic("All teams are done");
    }

    public Team getTeam() throws IOException {
        if (teams.size() > 0) {
            Random random = new Random();
            int randomTeamNUmber = random.nextInt(teams.size());
            String team = teams.get(randomTeamNUmber);
            teams.remove(team);
            addTeamToText(team);
            return new Team(team);
        }
        return new Team("All teams are done");
    }
}
