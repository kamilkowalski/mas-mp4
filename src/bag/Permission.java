package bag;

import java.util.Set;

public class Permission {
    private FilesystemUser user;
    private Folder folder;
    private Set<PermissionLevel> levels;

    public Permission(FilesystemUser user, Folder folder, Set<PermissionLevel> levels) {
        setUser(user);
        setFolder(folder);
        setLevels(levels);
    }

    public FilesystemUser getUser() {
        return user;
    }

    public void setUser(FilesystemUser user) {
        if (this.user == user) return;

        if (this.user != null) {
            this.user.removePermission(this);
        }

        this.user = user;
        this.user.addPermission(this);
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        if (this.folder == folder) return;

        if (this.folder != null) {
            this.folder.removePermission(this);
        }

        this.folder = folder;
        this.folder.addPermission(this);
    }

    public Set<PermissionLevel> getLevels() {
        return levels;
    }

    public void setLevels(Set<PermissionLevel> levels) {
        this.levels = levels;
    }
}
