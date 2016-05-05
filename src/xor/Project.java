package xor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Project {
    private String name;
    private Date estimatedCompletion;

    private Set<Budget> budgets = new HashSet<>();

    public Project(String name, Date estimatedCompletion) {
        setName(name);
        setEstimatedCompletion(estimatedCompletion);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEstimatedCompletion() {
        return estimatedCompletion;
    }

    public void setEstimatedCompletion(Date estimatedCompletion) {
        this.estimatedCompletion = estimatedCompletion;
    }

    public Set<Budget> getBudgets() {
        return budgets;
    }

    public void addBudget(Budget budget) throws Exception {
        if (!budgets.contains(budget)) {
            budgets.add(budget);
            budget.setProject(this);
        }
    }

    public void removeBudget(Budget budget) {
        if (budgets.contains(budget)) {
            budgets.remove(budget);
        }
    }
}
