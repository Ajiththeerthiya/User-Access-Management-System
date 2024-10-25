package usermanagement;

public class Software {
	private int id;
	private String softwareName;
	private String description;
	private String access_level;
	
	public Software() {
		super();
	}
	
	
	public Software(int id, String softwareName, String description, String access_level) {
		super();
		this.id = id;
		this.softwareName = softwareName;
		this.description = description;
		this.access_level = access_level;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSoftwareName() {
		return softwareName;
	}
	
	public void setSoftwareName(String softwarename) {
		this.softwareName = softwarename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAccess_level() {
		return access_level;
	}
	public void setAccess_level(String access_level) {
		this.access_level = access_level;
	}

	@Override
	public String toString() {
		return "Software [id=" + id + ", softwareName=" + softwareName + ", description=" + description
				+ ", access_level=" + access_level + "]";
	}
	
	
}
