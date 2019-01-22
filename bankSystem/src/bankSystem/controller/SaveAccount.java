package bankSystem.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import bankSystem.model.vo.Bank;

public class SaveAccount {
	private Properties pr = new Properties();
	private Properties pR = new Properties();
	private static final String fName = "customer.xml";
	Scanner sc = new Scanner(System.in);
	//private Bank b = new Bank();
	public SaveAccount() {
		System.out.println("<< �� ������ �ҷ��ɴϴ�. >>\n");
		
		try {
			pr.loadFromXML(new FileInputStream(fName));
			
		} catch (FileNotFoundException e) {
			System.out.println("���¸� ���� ������ֽñ� �ٶ��ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveAcc(Bank b) {
		//Properties pR = new Properties();
		pr.setProperty(String.valueOf(b.getbNo()), b.toString());
		pR.setProperty(String.valueOf(b.getbNo()), b.toString());
		//pr.list(System.out);
		try {
			pr.storeToXML(new FileOutputStream(fName), "������");
			
			System.out.print("�� ������ ������ ���� �̸� : ");
			String fName2 = sc.next();
			pR.storeToXML(new FileOutputStream(fName2 + ".xml"), "��������");
			
		} catch (FileNotFoundException e) {
			System.out.println("���¸� �������ֽñ� �ٶ��ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		pR = new Properties();
	}
	
	public Properties allPrint() {
		return pr;
	}
	
	public Properties bankSearch(String fn) {
		try {
			pR.loadFromXML(new FileInputStream(fn+".xml"));
			
		} catch (FileNotFoundException e) {
			System.out.println("���¸� ���� ������ֽñ� �ٶ��ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pr;
	}
	
	public void bankDeposit(Properties p) {
		System.out.println("=== KH Bank ===");
		try {
			System.out.print("������� ������ ���� ���� : ");
			String fn = sc.next();
			if(fn.equals(fn)) {
				//p.loadFromXML(new FileInputStream(fName + ".xml"));
				p.storeToXML(new FileOutputStream(fn + ".xml"), "��������");
				p.storeToXML(new FileOutputStream(fName), "������");
			}
			System.out.println("�Ա��� ���������� ó���Ǿ����ϴ�.");
			
		} catch (FileNotFoundException e) {
			System.out.println("�� ������ �����ϴ�.");
		} catch (IOException e) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		
		/*for(Map.Entry<Object, Object> o : p.entrySet()) {
			System.out.println(o.getKey() + " " + o.getValue() + "\n");
		}
		
		try {
				p.storeToXML(new FileOutputStream(fName + ".xml"), "��������");
			}
			System.out.println("�Ա��� ���������� ó���Ǿ����ϴ�.");
			
		} catch (FileNotFoundException e) {
			System.out.println("�� ������ �����ϴ�.");
		} catch (IOException e) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}*/
	}

}
