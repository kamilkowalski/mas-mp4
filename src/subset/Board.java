package subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {
    private String name;

    private List<Topic> topics = new ArrayList<>();
    private Set<User> users = new HashSet<>();
    private Set<User> admins = new HashSet<>();

    public Board(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void addTopic(Topic topic) {
        if (!topics.contains(topic)) {
            this.topics.add(topic);
            topic.setBoard(this);
        }
    }

    public void removeTopic(Topic topic) {
        if (topics.contains(topic)) {
            topics.remove(topic);
        }
    }

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
            user.addBoard(this);
        }
    }

    public Set<User> getAdmins() {
        return admins;
    }

    public void addAdmin(User admin) throws Exception {
        if (!users.contains(admin)) {
            throw new Exception("Użytkownik " + admin.getName() + " musi być użytkownikiem forum " + getName() + " zanim będzie adminem!");
        }

        if (!admins.contains(admin)) {
            admins.add(admin);
            admin.addAdministratedBoard(this);
        }
    }
}
