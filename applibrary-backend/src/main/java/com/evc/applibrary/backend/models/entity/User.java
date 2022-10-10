package com.evc.applibrary.backend.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional = false)
	private Integer userId;
	
	@Basic(optional = false)
	@Email
    @NotNull
    @Column(unique=true)
	private String email; //El email tambien sera el username

	@Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 32, message = "first name must be between 3 and 32 characters")
	private String firstName;

	@Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 32, message = "last name must be between 3 and 32 characters")
	private String lastName;
	
	@Basic(optional = false)
    @NotNull
    @Column(columnDefinition = "boolean default true")
    private Boolean isEnabled;

	@Basic(optional = false)
	@NotNull
    @Size(min = 6, message = "password must be between 6 and 12 characters")
	private String password;
	
	@Transient
	private String password2;

	//bi-directional many-to-one association to BookRequest
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	//@JsonManagedReference
	private List<BookRequest> bookrequests;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="user_roles", joinColumns= @JoinColumn (name="userId"),
	inverseJoinColumns=@JoinColumn(name="roleid"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"userId", "roleId"})})
	//@JsonManagedReference
	private List<Role> roles;
		
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public List<BookRequest> getBookrequests() {
		return bookrequests;
	}

	public void setBookrequests(List<BookRequest> bookrequests) {
		this.bookrequests = bookrequests;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public BookRequest addBookrequest(BookRequest bookrequest) {
		getBookrequests().add(bookrequest);
		bookrequest.setUser(this);

		return bookrequest;
	}

	public BookRequest removeBookrequest(BookRequest bookrequest) {
		getBookrequests().remove(bookrequest);
		bookrequest.setUser(null);

		return bookrequest;
	}
 

}