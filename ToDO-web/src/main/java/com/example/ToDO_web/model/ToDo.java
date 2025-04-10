package com.example.ToDO_web.model;





import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="todo")
public class ToDo {
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	 @Column
	 @NonNull
	private String title;
	@Column
	@NonNull
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date date;
	
	@Column
	@Nonnull
	private String Status;
	
	public ToDo() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
