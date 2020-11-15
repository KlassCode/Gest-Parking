package com.klasscode.gestPark.bean;

public class SlotBean {
	private int id;
	private int noSlot;
	private boolean dispo;

	public SlotBean() {
	}

	public SlotBean(int id, int noSlot, boolean dispo) {
		super();
		this.id = id;
		this.noSlot = noSlot;
		this.dispo = dispo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoSlot() {
		return noSlot;
	}

	public void setNoSlot(int noSlot) {
		this.noSlot = noSlot;
	}

	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

}
