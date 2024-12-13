package project.b.hexaAPI.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BoardInfoDAO {
	
	private Long id;
	private String title;
	private String description;
	private LocalDateTime createDate;
	
	public BoardInfoDAO(Long id, String title, String description, LocalDateTime localDateTime) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createDate = localDateTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = LocalDateTime.now();
	}
	
}
