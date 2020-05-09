package com.sapient.week5;


import java.util.Scanner;
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 


class Question extends Thread {
    public Question(String que, String opt1, String opt2, String opt3, String opt4, String correctOpt) {
		super();
		this.que = que;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.correctOpt = correctOpt;
	}
	private String que; 
    private String opt1, opt2, opt3, opt4; 
    private String correctOpt;
	
	public void run() {
		try{
			System.out.println(que);
			System.out.println("OPTIONS-");
			System.out.println("a. " + opt1);
			System.out.println("b. "+ opt2);
			System.out.println("c. " + opt3);
			System.out.println("d. " + opt4);
			System.out.println("Your ans a,b,c or d- ");
			Scanner sc = new Scanner(System.in);
			String trial= sc.nextLine();
			trial= trial.toLowerCase().trim();
			if(trial.equals(correctOpt)){
				System.out.println("Correct");
			}else{
				System.out.println("Wrong Ans");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	} 
}

public class KBC {


	public static void main(String[] args) throws InterruptedException {
		Thread q1 = new Question("sample que1","option1","option2","option3","option4","b");
		Thread q2 = new Question("sample que2","option1","option2","option3","option4","a");
		Thread q3 = new Question("sample que3","option1","option2","option3","option4","c");
		Thread q4 = new Question("sample que4","option1","option2","option3","option4","a");
		Thread q5 = new Question("sample que5","option1","option2","option3","option4","b");
		Thread q6 = new Question("sample que6","option1","option2","option3","option4","d");
		Thread q7 = new Question("sample que7","option1","option2","option3","option4","d");
		Thread q8 = new Question("sample que8","option1","option2","option3","option4","a");
		Thread q9 = new Question("sample que9","option1","option2","option3","option4","c");
		Thread q10 = new Question("sample que10","option1","option2","option3","option4","c");
		q1.setDaemon(true);
		q2.setDaemon(true);
		q3.setDaemon(true);
		q4.setDaemon(true);
		q5.setDaemon(true);
		q6.setDaemon(true);
		q7.setDaemon(true);
		q8.setDaemon(true);
		q9.setDaemon(true);
		q10.setDaemon(true);
		
		
		ExecutorService pool = Executors.newFixedThreadPool(1);

		pool.execute(q1);
        pool.execute(q2); 
        pool.execute(q3); 
        pool.execute(q4); 
        pool.execute(q5);
        pool.execute(q6);
        pool.execute(q7);
        pool.execute(q8);
        pool.execute(q9);
        pool.execute(q10);
        pool.shutdown();
		
	}

}