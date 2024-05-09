package com.tester;
//import static com.app.core.Student.*;

import static utils.StudentCollectionUtils.populateList;

import java.util.List;
import java.util.Scanner;

import com.app.core.Student;

import utils.SortByDob;
import utils.SortByGpaForSubject;

//import runnable_tasks.UpdateBalanceTask;

public class Test {

	public static void main(String[] args) throws InterruptedException {
//		Map<String, Student> map = populateMap(populateList());
//		try (Scanner sc = new Scanner(System.in)) {
//			writeDetails(map, sc.next());
////			System.out.println(readStudent(map, sc.next(), sc)+"\n");
//			readStudent(map, sc.next(), sc).values().forEach(s->System.out.println(s));
//		}		
		List<Student> students = populateList();
		
		System.out.println(Thread.currentThread());//toString -- Thread[main,5,main]

		String filename = "hello.ser";
		String filename2 = "hello2.ser";

		String subject = "java";
		SortByDob runnableTask=new SortByDob(students,filename );
		SortByGpaForSubject runnableTask2=new SortByGpaForSubject(students,filename2,subject.toUpperCase());

		try(Scanner sc = new Scanner(System.in);){
			
		}
		Thread t1=new Thread(runnableTask,"one");
		Thread t2=new Thread(runnableTask2,"two");

		t1.start();
		t2.start();
		System.out.println("main waiting for child thrds to complete exec");
		t1.join();
		t2.join();
		System.out.println("main over....");
//		Thread t2 = new Thread(new StudentCollectionUtils(acct), "c1");

	}

}
