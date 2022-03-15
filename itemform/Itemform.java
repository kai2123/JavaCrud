package com.example.demo.itemform;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;




import lombok.Data;


@Data
public class Itemform implements Serializable{
	private static final long serialVersionUID = -6647247658748349084L;
	
	private Long id;
	
	@NotBlank
	@Size(max = 10)
	private String name;

	@NotBlank
	private String price;

	@NotBlank
	@Size(max = 400)
	private String content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void clear() {
		name = null;
		price = null;
		content = null;	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	
}
