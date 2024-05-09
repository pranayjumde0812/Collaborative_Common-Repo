package utils;

import static java.lang.Thread.currentThread;
import java.util.List;
import com.app.core.Student;

public class SortByGpaForSubject implements Runnable {
	private List<Student> list;
	private String filename;
	private String subject;

	public SortByGpaForSubject(List<Student> list,String filename,String subject) {
		this.list=list;
		this.filename=filename;
		this.subject = subject;
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
			IOUtils.writeDetails2(list, filename,subject);
			}catch (Exception e) {
				System.out.println(currentThread().getName() + " got exc " + e);
			}
			System.out.println(currentThread().getName() + " - over ");
		}

}
