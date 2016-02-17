package cola;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Character> cosas= new ArrayDeque<Character>();
		cosas.push('a');
		cosas.push('b');
		cosas.push('c');
		
		while(!cosas.isEmpty()){
			Character letra = cosas.pop();
			System.out.println(letra);
		}

	}

}
