
public abstract class User {


ManagementTeam mt;

private String name;
private boolean isFaculty;
private boolean isStudent;
private Registration registration;


    public User(String name, boolean isFaculty, boolean isStudent, Registration registration) {
        this.name = name;
        this.isFaculty = isFaculty;
        this.isStudent = isStudent;
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFaculty() {
        return isFaculty;
    }

    public void setFaculty(boolean faculty) {
        isFaculty = faculty;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

   
    public abstract void tryRegister(User user);

	public ManagementTeam getMt() {
		return mt;
	}

	public void setMt(ManagementTeam mt) {
		this.mt = mt;
	}


}