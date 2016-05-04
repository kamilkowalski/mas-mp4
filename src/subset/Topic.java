package subset;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private String name;
    private Board board;

    private List<Message> messages = new ArrayList<>();

    public Topic(String name, Board board) {
        setName(name);
        setBoard(board);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        if (this.board == board) return;

        if (this.board != null) {
            this.board.removeTopic(this);
        }

        this.board = board;
        this.board.addTopic(this);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }
}
