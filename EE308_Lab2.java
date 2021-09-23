package firstly;
import java.io.*;
import java.util.*;
public class EE308_Lab2 {
	public static void main(String args[]) {
		Scanner ct = new Scanner (System.in);
		System.out.print("Enter the path of document:");
		String path=ct.nextLine();
		System.out.print("Enter the part: ");
		int amount=ct.nextInt();
		ct.close();
		System.out.println(keyCounter(path,amount));
	}
		public static String keyCounter(String path,int amount) {//part 1
		String inp="";
		String txt=readFile(path);
		Scanner sc = new Scanner(txt);
		String stringArr[] = {"auto","double","int","struct","break","long","enum","registe","typedef","char","extern","return","union","const","float","short","unsigned","continue","for","signed","void","default","goto","sizeof","volatile","do","static","while"};
		int numberArr[] = new int [30];
		int total=0;
		int switchCount=0,ifCount0=0,if2Count0=0,elseCount=0,ifCount=0;
		int caseArr[]= new int [256];
		boolean begin=false;
		while(sc.hasNext()) {
			String str=sc.nextLine();
			for(int a=0;a<38;a++) {
				if(str.contains(stringArr[a])) {
					if(str.contains("double")) {
						if(a!=30) {
							total++;
							numberArr[a]++;
						 	numberArr[30]--;
						}
					}else {
						total++;
						numberArr[a]++;
					}
					
				}
			}
			if(str.contains("switch")) {//part 2
				total++;
				switchCount++;
			}else if(str.contains("case")) {
				total++;
				caseArr[switchCount]++;
			}else if(str.contains("if")) {
				if(!str.contains("else if")) {//part 3
					total++;
					ifCount0++;
					ifCount++;
					begin=true;
				}else if(str.contains("else if")) {
					total+=2;
					elseCount++;
					ifCount++;
					if(begin) {
						ifCount0--;
						if2Count0++;
						begin=false;
					}
				}
			}else if(str.contains("else")) {
				total++;
				elseCount++;
			}
		}
		sc.close();
		if(amount==1) {
			inp+="total num: "+total+'\n';
		}else if(amount==2) {
			inp+="total num: "+total+'\n';
			if(switchCount!=0) {
				inp+="switch num: "+switchCount+'\n';
				inp+="case num: ";
				for(int b=1;b<=switchCount;b++) {
					inp+=caseArr[b]+" ";
				}
				inp+='\n';
			}
		}else if(amount==3) {
			inp+="total num: "+total+'\n';
			if(switchCount!=0) {
				inp+="switch num: "+switchCount+'\n'+'\n';
				inp+="case num:"+"\n";
				for(int b=1;b<=switchCount;b++) {
					inp+=caseArr[b]+"\n";
				}
				inp+='\n';
			}
			if(ifCount0!=0) {
				inp+="ifelse num: "+ifCount0+'\n';
			}
		}else if(amount==4) {//part 4
			inp+="total num: "+total+'\n';
			if(switchCount!=0) {
				inp+="switch num: "+switchCount+'\n';
				inp+="case num: ";
				for(int b=1;b<=switchCount;b++) {
					inp+=caseArr[b]+"\n";
				}
				inp+='\n';
			}
			if(ifCount0!=0) {
				inp+="ifelse num: "+ifCount0+'\n';
			}
			if(if2Count0!=0) {
				inp+="ifelseifelse num: "+if2Count0+'\n';
			}
		}
		return inp;
	}
	
	public static String readFile(String path){
	        File file = new File(path);
	        StringBuilder finder = new StringBuilder();
	        return finder.toString();
	 }
}
