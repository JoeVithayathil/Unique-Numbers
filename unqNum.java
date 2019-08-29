import java.util.Scanner;
import java.util.ArrayList;


public class unqNum{
	
	static int numCount(int num){
		int d = 10,count = 0;
		while(num>0){
			num = num/10;
			count++;
		}
		//System.out.println(count);
		return count;
	}
	
	static int numAt(int num,int n){
		int d=1,i;
		for(i=1;i<n;i++){
			d=d*10;
		}
		num = num/d;
		//System.out.println(num);
		num = num%10;
		//System.out.println(num);
		return num;
	}
	
	static int digitBeforeCheck(int num,int pos){
		int digit = numAt(num,pos);
		int count =0;
		pos++;
		while(pos <= numCount(num)){
			if(digit > numAt(num,pos)){
				count++;
			}
			pos++;
		}
		return count;
	}
	
	static int digitCheck(int num,int pos){
		int digit = numAt(num,pos);
		pos++;
		while(pos<=numCount(num)){
			if(digit == numAt(num,pos)){
				return -1;
			}
			pos++;
		}
		return digit;
	}
	
	static int unqCount(int num){
	//part1
		//System.out.println(num);
		int numOfDigits = numCount(num);
		int[] temp = new int[10];
		int ten = 10;
		int numOfUniqNum = 0;
		int i,j,digit,temp1,temp2=0,fl;
		if(numOfDigits < 2){
			numOfUniqNum = (numOfDigits*num)+1;
			return numOfUniqNum;
		}
		for(i=1; i<=numOfDigits-1; i++){
			j = i-1;
			temp1 = 9;
			temp2 = 9;
			if(j==0){
				temp2 =10;
			}
			while(j>0){
				temp2 = temp1*temp2;
				temp1--;
				j--;
			}
			numOfUniqNum = numOfUniqNum+temp2;
		}
		//System.out.println("part1  " + numOfUniqNum);
		//part2
		digit = numAt(num,numOfDigits);
		if(digit>1){
			temp2 = digit-1;
			temp1 = 9;
			j = numOfDigits-1;
			while(j>0){
				temp2 = temp2*temp1;
				temp1--;
				j--;
			}
			numOfUniqNum = numOfUniqNum+temp2;
		}
		//System.out.println("part2  " + numOfUniqNum);
		//part3
		
		for(i=1;i<numOfDigits-1;i++){
			digit = numAt(num,numOfDigits-i);
			if(digit>0){
				j = numOfDigits-i-1;
				temp2 = digit-digitBeforeCheck(num,numOfDigits-i);
				temp1 = 10-i-1;
				while(j>0){
					temp2 = temp2*temp1;
					temp1--;
					j--;
				}
			numOfUniqNum = numOfUniqNum+temp2;
			}
			//System.out.println("Hello");
			if(digitCheck(num,numOfDigits-i) == -1){
				return numOfUniqNum;
			}
		}
		//System.out.println("part3  "+numOfUniqNum);
		//part4
		for(i=0;i<=numOfDigits-1;i++){
			temp[i] = numAt(num,numOfDigits-i);
		}
		
		for(i=0;i<=numAt(num,1);i++){
			fl=0;
			for(j=0;j<numOfDigits-1;j++){
				if(temp[j]==i){
					fl=1;
					break;
				}
			}
			if(fl==0){
				numOfUniqNum++;
			}
		}
		//System.out.println("part4");
		return numOfUniqNum;
	}
	
	static int checkUnique(int num){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int i,j;
		int numOfDigits = numCount(num);
		for(i=0;i<numOfDigits;i++){
			temp.add(numAt(num,numOfDigits-i));
		}
		System.out.println(temp);
		for(i=0;i<numOfDigits-1;i++){
			for(j=i+1;j<numOfDigits;j++){
				if(temp.get(i) == temp.get(j)){
					return 0;
				}
			}
		}
		return 1;
	}

	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int unqCountOfn = unqCount(n);
		int unqCountOfm = unqCount(m)-1;
		int count = unqCountOfn-unqCountOfm;
		if(checkUnique(m) == 0){
			count = count-1;
		}
		//System.out.println(unqCountOfn);
		System.out.println("No of unique numbers between " + n + " and " + m + " = " + count);
	}
}
