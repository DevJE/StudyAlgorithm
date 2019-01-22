package bankSystem.model.vo;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bank implements Serializable{
	private static final long serialVersionUID = 8593248819464369424L;
	
	private int bNo = 0;			//���������ȣ key��
	private String userName;	//�̸�
	private char gender;		//����
	private int age;			//����
	private String bNumber;		//���¹�ȣ
	private int price;			//�ݾ�
	private Date openDate;		//���尳����¥
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy'.'MM'.'dd");
	private NumberFormat comma = NumberFormat.getInstance();
	
	
	public Bank() {
		super();
		
	}
	public Bank(String userName, String bNumber, int price, Date openDate) {
		super();
		this.userName = userName;
		this.bNumber = bNumber;
		this.price = price;
		this.openDate = openDate;
	}
	public Bank(String userName, char gender, int age, String bNumber, int price, Date openDate) {
		super();
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.bNumber = bNumber;
		this.price = price;
		this.openDate = openDate;
	}
	public Bank(int bNo, String userName, char gender, int age, String bNumber, int price, Date openDate) {
		super();
		this.bNo = bNo;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.bNumber = bNumber;
		this.price = price;
		this.openDate = openDate;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getbNumber() {
		return bNumber;
	}

	public void setbNumber(String bNumber) {
		this.bNumber = bNumber;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int money) {
		this.price = money;
	}

	public String getOpenDate() {
		String s = (this.openDate == null ? "null" : dateFormat.format(this.openDate));
		
		return s;
		
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString () {
		StringBuffer buf = new StringBuffer();
		buf.append("*���¹�ȣ : ");
		buf.append(this.bNumber + "\n");
		buf.append("*������ : ");
		buf.append(this.userName + "\n");
		buf.append("*�ܾ� : ");
		buf.append(comma.format(this.price) + "\n");
		buf.append("*���尳���� : ");
		buf.append(getOpenDate());
		
		return /*"���¹�ȣ : " + this.bNumber +
				 "  \n�����ָ� : " + this.userName +
				  "\n�ܾ� : " + this.price +
			   " \n���� ������ : " + this.openDate;*/
				buf.toString();
	}
}


