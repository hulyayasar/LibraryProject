import java.util.*;

public class Faculty extends User{

	List <String> textbooksList;
	

	 
	public Faculty(String name, String email, String password) {
	this.email =email;
	this.name = name;
	this.name = name;
	this.password = password;
	this.ID = IDCounter++;
	}

	@Override
public int getID() {return this.ID;}

	List viewCourses() {return null;}
	List facultyCourses() {return null;}
	void newEditionTextbook(){}
//	@Override
//	public String getName() {
//		// TODO Auto-generated method stub
//		return super.getName();
//	}
	@Override
	public void tryRegister(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
    public String getName() {
        return this.name;
    }
	@Override
	public String getEmail() {
		
		return this.email;
	}
	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}
}
