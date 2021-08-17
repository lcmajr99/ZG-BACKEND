package com.sysambientes.sysambientes.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "links")
@Data
public class Link {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "data_create")
	private Date createDate;
	@Column(name = "data_update")
	private Date updateDate;
//___________________________________________________________
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		this.createDate = atual;
		this.updateDate = atual;
	}
//___________________________________________________________
	@PreUpdate
	public void preUpdate() {
		this.updateDate = new Date();
	}
//___________________________________________________________

	@Column(name = "linkOriginal")
	private String linkOriginal;

	@Column(name = "linkReduzido")
	private String linkReduzido;

	@Column(name = "qtdDeAcesso")
	private Integer qtdDeAcesso;

}