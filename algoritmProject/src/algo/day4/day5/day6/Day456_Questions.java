package algo.day4.day5.day6;

public class Day456_Questions { 
	public int[] deArray() {
		int []a = {5, 10, 73, 2, -5, 42};
		int x = 0;
		int y = a.length -1;
		
		while(x < y) {
			for(int i : a) {
				System.out.print(i + " ");
			}
			System.out.println("\na[" + x + "]��(��) " + "a[" + y + "]��(��) ��ȯ�մϴ�. ");
			
				int temp = a[x];
				a[x] = a[y];
				a[y] = temp;
				
				x ++;
				y --;
				
		}
		for(int ii : a) {
			System.out.print(ii + " ");
		}
		System.out.println("\n���� ������ ���ƽ��ϴ�.");
		
		return a;
		
	}
	public static int sumOf(int[] a) {
		
		int tot = 0;
		int x = 0;
		while(x < a.length) {
			tot += a[x];
			
			x ++;
		}		
		return tot;
	}

}
