
public class Register implements Registration {

	// I think is should interface but may I can use Abstract
	

	private int id;
	private String email;
	private String password;
	public int getID() {
		return this.id;}
	
	String getEmail() {return null;}
	String getPassword() {return null;}

	@Override
	public String register(User user) {
		// TODO Auto-generated method stub
		user.email = email;
		user.ID = id;
		user.email = email;


		return user.toString();

	}
	
	
}
