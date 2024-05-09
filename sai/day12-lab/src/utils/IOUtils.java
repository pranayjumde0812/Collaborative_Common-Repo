package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.app.core.Student;
import com.app.core.Subject;

public interface IOUtils {
	static void writeDetails1(List<Student> list, String fileName) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
			list.stream().sorted((s1,s2)->s1.getDob().compareTo(s2.getDob())).forEach(s -> pw.println(s));
		}
	}

	static void writeDetails2(List<Student> list, String fileName,String subject) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
			list.stream().filter(s->s.getSubject()==Subject.valueOf(subject)).sorted((s1,s2)->s1.getDob().compareTo(s2.getDob())).forEach(s -> pw.println(s));
		}
	}
}
