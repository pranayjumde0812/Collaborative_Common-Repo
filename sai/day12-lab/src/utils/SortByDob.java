package utils;

import static java.lang.Thread.currentThread;
import java.util.List;
import com.app.core.Student;

public class SortByDob implements Runnable {
	private List<Student> list;
	private String filename;

	public SortByDob(List<Student> list,String filename) {
		this.list=list;
		this.filename=filename;
	}
	
		
//	while (true) {
//		synchronized (jointAccount) {
//
//			double balance = jointAccount.checkBalance();
//			if (balance != 20000) {
//				System.out.println("ERROR!!!!!!!!!!!!!");
//				System.exit(-1);
//			}
//		}
//		Thread.sleep(random.nextInt(101) + 100);// 100-200
//	}
	@Override
	public void run() /* throws InterruptedException */ {
		System.out.println(Thread.currentThread().getName() + " strted");
		try {
			IOUtils.writeDetails1(list, filename);
			}catch (Exception e) {
				System.out.println(currentThread().getName() + " got exc " + e);
			}
			System.out.println(currentThread().getName() + " - over ");
		}

}
