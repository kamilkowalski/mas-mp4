package ordered2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Dziennik {
    private String klasa;
    private Set<OrderedStudent> students;

    public Dziennik(String klasa, Set<OrderedStudent> students) {
        setKlasa(klasa);
        setStudents(students);
    }

    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public Set<OrderedStudent> getStudents() {
        return students;
    }

    public void setStudents(Set<OrderedStudent> students) {
        this.students = students;
    }

    public List<OrderedStudent> getOrderedStudents() {
        List<OrderedStudent> orderedList = new ArrayList<>();
        orderedList.addAll(getStudents());
        Collections.sort(orderedList);
        return orderedList;
    }
}
