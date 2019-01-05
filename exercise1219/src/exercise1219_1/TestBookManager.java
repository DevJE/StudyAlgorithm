package exercise1219_1;

import java.util.*;
import java.io.*;

public class TestBookManager {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menu();

	}
	
	public static void menu() {
		BookManager b = new BookManager();
		int n = 0;
		
		do {
			System.out.println("*** ���� ���� ���α׷� ***");
			System.out.println("\n1. �� ���� �߰� "
							   + "\n2. �������� ���� �� ���"
							   + "\n3. ���� ����"
							   + "\n4. ���� �˻� ���"
							   + "\n5. ��ü ���"
							   + "\n6. ������");
			System.out.print("\n�޴���ȣ �Է� : ");
			n = sc.nextInt();
			switch(n) {
			case 1 : b.addBook(inputBook());							break;
			case 2 : b.printBookList(b.sortedBookList());				break;
			case 3 : b.deleteBook(b.searchBook(inputBookTitle()));		break;
			case 4 : b.printBook(b.searchBook(inputBookTitle()));		break;
			case 5 : b.displayAll();									break;
			case 6 : System.out.println("����");
					return;
				default : System.out.println("�߸��� �޴���ȣ �Է�");
			}

		}while(true);
	}
	
	public static Book inputBook() {
		
		System.out.print("���� ��ȣ �Է� : ");
		String bNum = sc.next();
		System.out.print("���� �з� �ڵ� : ");
		int cNum = sc.nextInt();
		System.out.print("������ �Է� : "); 
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("���� �Է� : ");
		String name = sc.next();
		
		Book bb = new Book(bNum, cNum, title, name);
		
		return bb;
		
	}
	public static String inputBookTitle() {
		System.out.print("ã�� å�̸� �Է� : ");
		String name = sc.next();
		
		return name;
	} 

}
