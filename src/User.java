
public class User {


ManagementTeam mt;

protected String name;
protected int ID;
protected static int IDCounter;
protected boolean isFaculty;
protected boolean isStudent, isMT,isStaff;
protected Registration registration;

protected String password;

protected String email;

public User() {
	
}


    public User(String name, String email, boolean isFaculty, boolean isStudent,boolean isStaff,boolean isMT, String password) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.isFaculty = isFaculty;
        this.isStudent = isStudent;
        this.isStaff=isStaff;
        this.isMT = isMT;
        this.registration = registration;
    }

    public String getName() {
        return name;
    }
    public int getID() {return this.ID;}

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
    public boolean isStaff() {
        return isStaff;
    }
    public boolean isMT() {
        return isMT;
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

   
    //public abstract void tryRegister(User user);

	public ManagementTeam getMt() {
		return mt;
	}

	public void setMt(ManagementTeam mt) {
		this.mt = mt;
	}

	public Object getEmail() {
		
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void tryRegister(User user) {
		// TODO Auto-generated method stub
		
	}


}