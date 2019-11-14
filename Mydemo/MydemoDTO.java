package ibp.dto.mydemo;

public class MydemoDTO {
	
	private String id = "";
	
	private String username = "";
	
	private String password = "";
	
	private String phone = "";
	
	private String address = "";
	
	private String flag;
	
	private String flag_disp = "";
	
	private String username_disp = "";
	
	//=========================================================
	
	private String[] selectedQuestionKey = {};
	//=========================================================
	
	/**
	 * 构造函数
	 */
	public MydemoDTO() {
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}



	public String[] getSelectedQuestionKey() {
		// TODO Auto-generated method stub
		return selectedQuestionKey;
	}


	public void setSelectedQuestionKey(String[] selectedQuestionKey) {
		this.selectedQuestionKey = selectedQuestionKey;
	}


	public String getFlag_disp() {
		return flag_disp;
	}


	public void setFlag_disp(String flag_disp) {
		this.flag_disp = flag_disp;
	}


	public String getUsername_disp() {
		return username_disp;
	}


	public void setUsername_disp(String username_disp) {
		this.username_disp = username_disp;
	}





	
}
