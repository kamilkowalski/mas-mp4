package xor;

import java.util.HashSet;
import java.util.Set;

public class Team {
    private String name;

    private Set<Budget> budgets = new HashSet<>();

    public Team(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBudget(Budget budget) throws Exception {
        if (!budgets.contains(budget)) {
            budgets.add(budget);
            budget.setTeam(this);
        }
    }

    public void removeBudget(Budget budget) {
        if (budgets.contains(budget)) {
            budgets.remove(budget);
        }
    }
}
