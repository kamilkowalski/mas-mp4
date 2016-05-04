package subset;

public class Message {
    private String text;
    private User user;

    public Message(String text, User user) {
        setText(text);
        setUser(user);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
