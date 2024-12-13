package project.b.hexaAPI.dao;

public class MemberDAO {
	
	private Long id;
	private boolean role; // user & admin
	private String userId;
	private String userPassword;
	private String userNickname;
	private String footSize;
	private String phoneNumber;
	private boolean newsletter;
	private String favorite;
	
	public MemberDAO(Long id, boolean role, String userId, String userPassword, String userNickname, String footSize,
			String phoneNumber, boolean newsletter, String favorite) {
		super();
		this.id = id;
		this.role = role;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
		this.footSize = footSize;
		this.phoneNumber = phoneNumber;
		this.newsletter = newsletter;
		this.favorite = favorite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getFootSize() {
		return footSize;
	}

	public void setFootSize(String footSize) {
		this.footSize = footSize;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}

	public String getFavorite() {
		return favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	
}
