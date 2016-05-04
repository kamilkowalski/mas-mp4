package subset;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private int id;

    private Set<Board> boards = new HashSet<>();
    private Set<Board> administratedBoards = new HashSet<>();

    private static int count;

    public User(String name) {
        setName(name);
        count++;
        setId(count);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Board> getBoards() {
        return boards;
    }

    public void addBoard(Board board) {
        if (!boards.contains(board)) {
            boards.add(board);
            board.addUser(this);
        }
    }

    public Set<Board> getAdministratedBoards() {
        return administratedBoards;
    }

    public void addAdministratedBoard(Board administratedBoard) throws Exception {
        if (!boards.contains(administratedBoard)) {
            throw new Exception("Użytkownik " + getName() + " musi być użytkownikiem forum " + administratedBoard.getName() + " zanim będzie adminem!");
        }

        if (!administratedBoards.contains(administratedBoard)) {
            administratedBoards.add(administratedBoard);
            administratedBoard.addAdmin(this);
        }
    }
}
