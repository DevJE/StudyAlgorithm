package ecercise1230_4_cont;

import java.io.*;
import java.util.*;

import exercise1230_4.*;

public class BoardManager {
	private ArrayList<Board> list = new ArrayList<Board> ();
	private Scanner sc = new Scanner(System.in);
	
	public BoardManager() {
		String fn = "board_list.dat";
		try(ObjectInputStream save = new ObjectInputStream((new FileInputStream(fn))))
		{
			list = (ArrayList<Board>) save.readObject();
		} catch(Exception e) {
			System.out.println("���α׷��� �����մϴ�.");
		}
	}
	
	public void writeBoard() {
		System.out.println("�� �Խñ� �����Դϴ�.");
		System.out.print("\n������ : ");
		String title = sc.nextLine();
		
		System.out.print("�ۼ��� : ");
		String author = sc.next();
		
		Date d = new Date();
		
		System.out.println("�۳��� �Է� ������ ");
		String text = null;
		StringBuilder builder = new StringBuilder();
		while(!(text = sc.nextLine()).toLowerCase().equals("exit")) {
			builder.append(text + "\n");
		}
		Board board = new Board(list.size(), title, author, d, builder.toString(), 0);
		list.add(board);
	}
	
	public void displayAllList() {
		for(Board bl : list) {
			System.out.println(bl);
		}
	}
	
	public void displayBoard() {
		System.out.print("��ȸ�� �� ��ȣ : ");
		int bNo = sc.nextInt();

		int index = 0;
		while(index < list.size()) {
			if(list.get(index).getBoardNo() == bNo) {
				list.get(bNo).setReadCount(list.get(bNo).getReadCount() + 1);
				System.out.println(list.get(bNo));
				} 
			index ++;
		}
	}
	public void modifyTitle() {
		System.out.print("������ �� ��ȣ : ");
		int bNo = sc.nextInt();

		int index = 0;
		while(index < list.size()) {
			if(list.get(index).getBoardNo() == bNo) {
				System.out.print("�� ���� �Է� : ");
				sc.nextLine();
				String title = sc.nextLine();
				list.get(bNo).setBoardTitle(title);
				System.out.println(bNo + "�� �Խñ� ������ ����Ǿ����ϴ�!");
			}
			index ++;
		}
	}
	public void modifyContent() {
		System.out.print("������ �� ��ȣ : ");
		int bNo = sc.nextInt();
		
		StringBuilder builder = new StringBuilder();
		String change = null;
		int index = 0;
		while(index < list.size()) {
			if(list.get(index).getBoardNo() == bNo) {
				list.get(bNo);
				System.out.println("������ ���� ������ ");
				while(!(change = sc.nextLine()).equals("exit")) {
						builder.append(change + "\n");
					}
					list.get(bNo).setBoardContent(builder.toString());
					System.out.println("������ �Ϸ�Ǿ����ϴ�!");
				}
			index ++;
		}
	}
	public void deleteBoard() {
		System.out.print("������ �� ��ȣ : ");
		int bNo = sc.nextInt();
		
		int index = 0;
		while(index < list.size()) {	
			if(list.get(index).getBoardNo() == bNo) {
				list.get(bNo);
				System.out.println("������ �����Ͻðڽ��ϱ�? (y/n)");
				if( (sc.next().toLowerCase().charAt(0) == 'y')) { 
							list.remove(list.get(index));
				}
				System.out.println(index + "�� ���� �����Ͽ����ϴ�.");
			}			
			index ++;
		}
		
		System.out.println("�޴��� ���ư��ϴ�.");
	}
	public void searchBoard() {
		System.out.print("�˻��� ���� : ");
		String bTitle = sc.nextLine();
    	System.out.println();
    	
    	int index = 0;
    	while(index < list.size()) {
    		if(bTitle.equals(list.get(index).getBoardTitle())) {
    			System.out.println("< �˻� ��� >");
    			System.out.println(list.get(index));
    			}
    		index ++;
    	}
	}
	public void saveListFile() {
		String fn = "board_list.dat";
    	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fn));)
    	{  		
    		oos.writeObject(list);
    		System.out.println(fn + " �� ���������� ����Ǿ����ϴ�!");
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
	}
	public void sortList(int item, boolean isDesc) {
		if(item == 1) {
			if(!isDesc) {
				list.sort(new AscBoardNo());
			} else {
				list.sort(new DescBoardNo());
			}
		}
		
		if(item == 2) {
			if(!isDesc) {
				list.sort(new AscBoardDate());
			} else {
				list.sort(new DescBoardDate());
			}
		}
		
		if(item == 3) {
			if(!isDesc) {
				list.sort(new AscBoardTitle());
			} else {
				list.sort(new DescBoardTitle());
			}
		}
		
		displayAllList();
	}
}
