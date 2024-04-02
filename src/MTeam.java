
public class MTeam extends User {

	ManagementTeam mt;
	
	public MTeam(String name, String email, String password) {
		this.email =email;
		this.name = name;
		this.name = name;
		this.password = password;
		this.ID = IDCounter++;
		}
	@Override
    public String getName() {
        return this.name;
    }
	@Override
	public String getEmail() {
		
		return email;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	@Override
	public int getID() {
		return this.ID;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
}
