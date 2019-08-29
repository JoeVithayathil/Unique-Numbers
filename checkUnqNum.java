import java.util.Scanner;

class prog{
	static int numCount(int num){
		int d = 10,count = 0;
		while(num>0){
			num = num/10;
			count++;
		}
		return count;
	}

	static int uniqueCheck(int[] a){
		int i,j;
		for(i=0;i<a.length;i++){
			for(j=i+1;j<a.length;j++){
				if(a[j] == a[i]){
					return 0;
				}
			}
		}
		return 1;
	}


	public static void main(String args[]){
		int m,n,size=0,i,j,k,count = 0;
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		n = scan.nextInt();
		for(i = m; i<=n ; i++){
			k=i;
			size =0;
			int[] arr = new int[numCount(i)];
			while(k>0){
				arr[size++] = k%10;
				k = k/10;
			}
			count = count+uniqueCheck(arr);
		}
		System.out.println(count);
	}
}
