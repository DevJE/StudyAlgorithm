package bankSystem.view;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import bankSystem.model.vo.Bank;
import bankSystem.controller.*;

public class BankManager {
	private Bank bStart = new Bank();
	private SaveAccount save = new SaveAccount();
	
	private Scanner sc = new Scanner(System.in);
	private static int bNum = 0; //���°��� �ڵ��ο�
	private static int bNum2 = 0; // ������ȣ �ڵ��ο�
	private static final String n = "KHbank-";
	
	public void mainMenu() {
		boolean start = true;
		while(start) {
			System.out.println("====== ���� ���� �ý��� ======");
			System.out.println("1. �� ���� ���� "
							 + "\n2. ��ü ���� ��ȸ"
							 + "\n3. Ư�� ���� ��ȸ"
							 + "\n4. �Ա�"
							 + "\n5. ���"
							 + "\n6. ������ü"
							 + "\n7. ���α׷� ����");
			
			System.out.print("\n�޴��� �����ϼ��� : ");
			int chooseMenu = sc.nextInt();
			
			switch(chooseMenu) {
			case 1 : bankInsert(); 		break; //���°���
			case 2 : bankAllPrint(); 	break; //��ü��ȸ
			case 3 : bankSearch(); 		break; //�κ���ȸ
			case 4 : bankDeposit(); 	break; //�Ա�
			case 5 : bankWithdrawal(); 	break; //���
			case 6 : bankAccTransfer(); break; //������ü
			case 7 : start = false; 	break;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
		System.out.println("���α׷� ����");
	}
	
	public void bankInsert() {
		//���¹�ȣ �ڵ��Ҵ�
		String account = n + String.format(new DecimalFormat("00000").format(++bNum));	
		
		
		System.out.print("���̸� : ");
		String name = sc.next();
		
		System.out.print("ù �Աݾ� : ");
		int pr = sc.nextInt();
		
		System.out.print("���� : ");
		char gd = sc.next().charAt(0);
		
		System.out.print("���� : ");
		int ag = sc.nextInt();
		
		Date d = new Date();
		
		Bank bank = new Bank(++bNum2, name, gd, ag, account, pr, d);
		
		save.saveAcc(bank);
	}
	
	public void bankSearch () {
		// ���� �˻� ��ȸ
		//SaveAccount sa = new SaveAccount();
		System.out.print("�˻��� �����ָ� : ");
		String cName = sc.next();
		//�Ʒ��� �ڵ尡 ������ ��ü ���Ͽ��� �ش� ���� ������ �����.
		System.out.print("�˻��� ���ϸ� : ");
		String conName = sc.next();
		Properties p = new SaveAccount().bankSearch(conName);
		//p.list(System.out);
		//�ڲ� �ڿ� ... ���ͼ� ¥���� �׳� �����.
		//���� ����ϴ� ����� �� ����. ��ü��Ͽ��� ��ȸ or �ش� ���� ���� �ҷ�����
		for(Map.Entry<Object, Object> o : p.entrySet()) {
			String value = (String)o.getValue();
			if(value.contains(cName)) {
				System.out.println(o.getKey() + " " + o.getValue());
			}
		}
	}
	
	public void bankAllPrint() {
		// ��ü �������� ��ȸ
		System.out.println("=== ���� ��ü ��� ===");
		//SaveAccount sa = new SaveAccount();
		Properties p = new SaveAccount().allPrint();
		//p.list(System.out);
		for(Map.Entry<Object, Object> o : p.entrySet()) {
			System.out.println(o.getKey() + " " + o.getValue() + "\n");
		}
	
	}
	
	public void bankDeposit() {
		//�Ա�
		System.out.print("�Ա� �ݾ� : ");
		int money = sc.nextInt();
		
		System.out.print("�Աݰ� ������ȣ : ");
		//String absoluteKey = n + sc.next(); ���¹�ȣ�� key�� ���
		String absoluteKey = sc.next();
		
		System.out.print("�ҷ��� ���ϸ� : ");
		String fn = sc.next();
		Properties p = new SaveAccount().bankSearch(fn);

		Map<String, String> map = new HashMap<> ();
		
		for(String key : p.stringPropertyNames()) {
			map.put(key, p.getProperty(key));	
			String []values = (String[]) map.values().toArray(new String[map.size()]);
			String []sar = values[0].split("\\s");
			//if(absoluteKey.equals(sar[2])) { ���¹�ȣ�� key�� ���
			if(absoluteKey.equals(key)) {
				for(String w : sar) {
					System.out.println(money + "�� �Ա��ϼ̽��ϴ�.");
					String str = sar[8].replaceAll(",", "");
					int x = Integer.parseInt(str) + money;
				    
					String totalCash = String.valueOf(x);
					int keyies = Integer.parseInt(absoluteKey);
					
					bStart.setPrice(x);
					bStart = new Bank(keyies, sar[5], bStart.getGender(), bStart.getGender(),sar[5], x, new Date());
					new SaveAccount().saveAcc(bStart);
					break;
				}
			
			}
		}
	}
	
	public void bankWithdrawal() {
		//���
		System.out.print("��� �ݾ� : ");
		int money = sc.nextInt();
		
		System.out.print("��ݰ� ������ȣ  : ");
		//String absoluteKey = n + sc.next(); ���¹�ȣ�� key�� ���
		String absoluteKey = sc.next();
		
		System.out.print("�ҷ��� ���ϸ� : ");
		String fn = sc.next();
		Properties p = new SaveAccount().bankSearch(fn);

		Map<String, String> map = new HashMap<> ();
		
		for(String key : p.stringPropertyNames()) {
			map.put(key, p.getProperty(key));	
			String []values = (String[]) map.values().toArray(new String[map.size()]);
			String []sar = values[0].split("\\s");
		
			//if(absoluteKey.equals(sar[2])) { ���¹�ȣ�� key�� ���
			if(absoluteKey.equals(key)) {
				for(String w : sar) {
					System.out.println(money + "�� ����ϼ̽��ϴ�.");
					String str = sar[8].replaceAll(",", "");
					int x = Integer.parseInt(str) - money;
				    
					String totalCash = String.valueOf(x);
					int keyies = Integer.parseInt(absoluteKey);
					
					bStart.setPrice(x);
					bStart = new Bank(keyies, sar[5], bStart.getGender(), bStart.getGender(),sar[5], x, new Date());
					new SaveAccount().saveAcc(bStart);
					break;
				}
			}
		}
	}
	
	public void bankAccTransfer() {
		//������ü
	}
}