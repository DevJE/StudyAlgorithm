package exercise1219_3;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Inventory implements Serializable{
	private static final long serialVersionUID = -5580214314082378751L;
	
	private String productName;
	private Date putDate;
	private Date getDate;
	private int putAmount;
	private int getAmount;
	private int invenAmount;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy'��' MM'��' dd'��'");
	
	public Inventory() {}

	public Inventory(String productName, Date putDate, int putAmount) {
		super();
		this.productName = productName;
		this.putDate = putDate;
		this.putAmount = putAmount;
		
		this.invenAmount = this.putAmount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getPutDate() {
		return putDate;
	}

	public void setPutDate(Date putDate) {
		this.putDate = putDate;
	}

	public Date getGetDate() {
		return getDate;
	}

	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}

	public int getPutAmount() {
		return putAmount;
	}

	public void setPutAmount(int putAmount) {
		this.putAmount = putAmount;
	}

	public int getGetAmount() {
		return getAmount;
	}

	public void setGetAmount(int getAmount) throws AmountNotEnough{
		this.getAmount = getAmount;
		
		if(this.getAmount > this.putAmount) {
			throw new AmountNotEnough("���� ��� �����մϴ�. ������ Ȯ���Ͻñ� �ٶ��ϴ�.");
		} else {
			this.invenAmount = this.putAmount - this.getAmount;
		}
	}

	public int getInvenAmount() {
		return invenAmount;
	}

	public void setInvenAmount(int invenAmount) {
		this.invenAmount = invenAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String toString() {
		String gDate = (this.getAmount == 0? "null" : sdf.format(this.getDate));
	
		return this.productName + ", " + sdf.format(this.putDate) + " �԰�, " + this.putAmount + 
				"��, " + gDate + " ���, " + this.getAmount + "��, ��� " + this.invenAmount + "��";
	}
}
