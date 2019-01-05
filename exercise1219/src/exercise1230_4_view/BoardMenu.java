package exercise1230_4_view;

import java.util.*;

import ecercise1230_4_cont.BoardManager;

import java.io.*;

public class BoardMenu {
	private Scanner sc = new Scanner(System.in);
	private BoardManager b = new BoardManager();
	
	public BoardMenu() {}
	
	public void mainMenu() {
		int menu = 0;
		
		do {
		System.out.println("******** �Խñ� ���� ���α׷� ********");
		System.out.println("\n1. �Խñ� ����" + "\n2. �Խñ� ��ü ����");
		System.out.println("3. �Խñ� �� �� ����" + "\n4. �Խñ� ���� ����");
		System.out.println("5. �Խñ� ���� ����" + "\n6. �Խñ� ����");
		System.out.println("7. �Խñ� �˻�" + "\n8. ���Ͽ� �����ϱ�");
		System.out.println("9. �����ϱ�" + "\n10. ������");
		
		System.out.print("\n�޴� ��ȣ ���� : ");
		menu = sc.nextInt();
		
		switch(menu) {
		case 1 : b.writeBoard(); 		break;
		case 2 : b.displayAllList(); 	break;
		case 3 : b.displayBoard(); 		break;
		case 4 : b.modifyTitle(); 		break;
		case 5 : b.modifyContent(); 	break;
		case 6 : b.deleteBoard(); 		break;
		case 7 : b.searchBoard(); 		break;
		case 8 : b.saveListFile(); 		break;
		case 9 : sortSubMenu(); 		break;
		case 10 : System.out.println("�����մϴ�.");
				return;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴� ��ȣ�� �ٽ� �������ּ���.");
			}
		} while(true);
	}
	public void sortSubMenu() {
		int menu = 0;
		do {
			System.out.println("****** �Խñ� ���� �޴� ******");
			System.out.println("1. �۹�ȣ�� �������� ����");
			System.out.println("2. �۹�ȣ�� �������� ����");
			System.out.println("3. �ۼ���¥�� ������������");
			System.out.println("4. �ۼ���¥�� �������� ����");
			System.out.println("5. ������� �������� ����");
			System.out.println("6. ������� �������� ����");
			System.out.println("7. ���� �޴��� �̵�");
			System.out.print("\n�޴� ��ȣ ���� : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1 : b.sortList(1, false);		break;
			case 2 : b.sortList(1, true);		break;
			case 3 : b.sortList(2, false);		break;
			case 4 : b.sortList(2, true);		break;
			case 5 : b.sortList(3, false);		break;
			case 6 : b.sortList(3, true);		break;
			case 7 : System.out.println("���� �޴��� ���ư��ϴ�.");
					return;
				default : System.out.println("�޴� ��ȣ�� �ٽ� �������ּ���.");
			}
		} while(true);
	}

}
