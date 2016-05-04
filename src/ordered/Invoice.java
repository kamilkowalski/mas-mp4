package ordered;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String number;

    private List<InvoiceEntry> entries = new ArrayList<>();

    public Invoice(String number) {
        setNumber(number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<InvoiceEntry> getEntries() {
        return entries;
    }

    public void addEntry(InvoiceEntry entry) {
        if (!entries.contains(entry)) {
            entries.add(entry);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Faktura nr " + getNumber() + "\n");

        sb.append("Lp. | Nazwa | Ilość | Cena jedn. | Cena całkowita\n");

        for(int i=0; i < entries.size(); i++) {
            sb.append("" + (i+1) + ". | " + entries.get(i).toString() + "\n");
        }

        return sb.toString();
    }
}
