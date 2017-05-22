import lt.itakademija.exam.Issue;
import lt.itakademija.exam.Project;
import lt.itakademija.exam.ProjectManager;

import java.util.ArrayList;

import java.util.Collection;

public class ProjectTracker implements ProjectManager {

    private Project pro;
    private Issue issue;
    private ArrayList<Project> projectList = new ArrayList<Project>();

    @Override
    public Project createProject(String s, String s1) {
        if (s.isEmpty() || s1.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (s.equals(null) || s.equals(null)) {
            throw new NullPointerException();
        }
        pro = new Project(s, s1);
        projectList.add(pro);
        return pro;
    }

    @Override
    public Collection<Project> getProjects() {
        return projectList;
    }

    @Override
    public Project getProjectById(String s) {
        for (Project project : projectList) {
            if (project.getId().equals(s)) {
                return project;
            }
        }
        return null;
    }

    @Override
    public Issue createIssue(Project project, String s) {
        if (s.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (project.equals(null) || s.equals(null)) {
            throw new NullPointerException();
        }
        issue = new Issue(project, s);
        project.addIssue(issue);
        return issue;
    }

    @Override
    public Issue createIssue(String s, String s1) {
        if (s.isEmpty() || s1.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (s.equals(null) || s1.equals(null)) {
            throw new NullPointerException();
        }
        issue = new Issue(getProjectById(s), s);
        getProjectById(s).addIssue(createIssue(getProjectById(s), s1));
        return issue;
    }

    @Override
    public Collection<Issue> getIssues(Project project) {
        return project.getIssues();
    }

    @Override
    public Collection<Issue> getIssues(String s) {
        return getProjectById(s).getIssues();
    }
}
