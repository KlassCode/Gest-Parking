package com.klasscode.gestPark.bean;

public class VehiculeBean {

	private int id;
	private CategoryBean category;
	private SlotBean slot;
	private String compagnyName;
	private String proprioName;
	private String proprioMail;
	private boolean inParking;

	public VehiculeBean(CategoryBean category,SlotBean slot, String compagnyName, String proprioName, String proprioMail,
			boolean inParking) {
		super();
		this.category = category;
		this.slot = slot;
		this.compagnyName = compagnyName;
		this.proprioName = proprioName;
		this.proprioMail = proprioMail;
		this.inParking = inParking;
	}

	public VehiculeBean(int id, CategoryBean category, SlotBean slot, String compagnyName, String proprioName, String proprioMail,
			boolean inParking) {
		super();
		this.id = id;
		this.category = category;
		this.slot = slot;
		this.compagnyName = compagnyName;
		this.proprioName = proprioName;
		this.proprioMail = proprioMail;
		this.inParking = inParking;
	}

	

	public VehiculeBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CategoryBean getCategory() {
		return category;
	}

	public void setCategory(CategoryBean category) {
		this.category = category;
	}

	
	public SlotBean getSlot() {
		return slot;
	}

	public void setSlot(SlotBean slot) {
		this.slot = slot;
	}

	public String getCompagnyName() {
		return compagnyName;
	}

	public void setCompagnyName(String compagnyName) {
		this.compagnyName = compagnyName;
	}

	public String getProprioName() {
		return proprioName;
	}

	public void setProprioName(String proprioName) {
		this.proprioName = proprioName;
	}

	public String getProprioMail() {
		return proprioMail;
	}

	public void setProprioMail(String proprioMail) {
		this.proprioMail = proprioMail;
	}

	public boolean isInParking() {
		return inParking;
	}

	public void setInParking(boolean inParking) {
		this.inParking = inParking;
	}

}
