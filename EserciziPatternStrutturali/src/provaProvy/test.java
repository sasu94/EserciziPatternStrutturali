package provaProvy;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("login as user or admin");
		FabbricaProxy.init(s.next());
		StrutturaDati d = FabbricaProxy.getInstance();
		d.getList().forEach(string -> {
			System.out.println(string);
		});

		System.out.println("give a name");
		d.add(s.next());

		s.close();
	}
}
