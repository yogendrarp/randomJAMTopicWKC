package wkc;

public class TeamTopic {

    private String team;
    private String topic;

    public TeamTopic(String team, String topic) {
        this.team = team;
        this.topic = topic;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "TeamTopic{" +
                "team='" + team + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
