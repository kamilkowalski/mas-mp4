package xor;

import java.util.Date;

public class Budget {
    private double value;
    private Project project;
    private Team team;

    public Budget(double value) {
        setValue(value);
    }
    public Budget(double value, Project project) throws Exception {
        this(value);
        setProject(project);
    }

    public Budget(double value, Team team) throws Exception {
        this(value);
        setTeam(team);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) throws Exception {
        if (this.team != null) {
            throw new Exception("A team is already set!");
        }

        if (this.project == project) return;

        if (this.project != null) {
            this.project.removeBudget(this);
        }

        this.project = project;
        this.project.addBudget(this);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) throws Exception {
        if (this.project != null) {
            throw new Exception("A project is already set!");
        }

        if (this.team == team) return;

        if (this.team != null) {
            this.team.removeBudget(this);
        }

        this.team = team;
        this.team.addBudget(this);
    }
}
