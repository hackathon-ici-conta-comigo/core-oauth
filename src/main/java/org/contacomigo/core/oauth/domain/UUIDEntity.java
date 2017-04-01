package org.contacomigo.core.oauth.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.contacomigo.core.oauth.service.util.RandomUtil;

@MappedSuperclass
public abstract class UUIDEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id = generateId();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String generateId() {
		return RandomUtil.generateUUID();
	}
}
