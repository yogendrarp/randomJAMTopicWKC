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


    public UserSession() throws IOException {
        getTeams();
        getTopics();
    }

    public TeamTopic getTeamTopic() throws IOException {
        Random random = new Random();
        if (teams.size() > 0) {
            int randomTeamNUmber = random.nextInt(teams.size());
            int randomTopicNumber = random.nextInt(topics.size());
            String team = teams.get(randomTeamNUmber);
            teams.remove(team);
            String topic = topics.get(randomTopicNumber);
            topics.remove(topic);
            addToText(team, topic);
            return new TeamTopic(team, topic);
        }
        return new TeamTopic("All teams are now done!", "Thank You!");
    }

    private void addToText(String team, String topic) throws IOException {
        String filePath = "/Users/yogendraprabhu/teamTopic.txt";
        FileWriter writer = new FileWriter(filePath, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(String.format("%s,%s\n", team, topic));
        bufferedWriter.close();
    }

    private void getTopics() throws IOException {
        File file = new File("/Users/yogendraprabhu/Code/teamtopicselector/build/resources/main/teams.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            teams.add(st);
        }
    }

    private void getTeams() throws IOException {
        File file = new File("/Users/yogendraprabhu/Code/teamtopicselector/build/resources/main/topics.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            topics.add(st);
        }
    }

}
