import java.util.LinkedList;
import java.util.Queue;

class Person{
	static int index = 0;
	int lineCount = 1;
	int pNum = 0;

	Person() {
		super();
		// TODO Auto-generated constructor stub
		index++;
		pNum = index;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [pNum=");
		builder.append(pNum);
		builder.append(", lineCount=");
		builder.append(lineCount);
		builder.append("]");
		return builder.toString();
	}
}

public class MyChew {
	static int myChew = 20;
	static Queue<Person> que = new LinkedList<Person>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person();
		que.offer(p);
		while(myChew >= 0) {
			p = que.poll();
			myChew -= p.lineCount;
			// System.out.println(p);
			// System.out.println(myChu);
			System.out.println("큐에 있는 사람 수 : " + (que.size() + 1));
			System.out.println("현재 사탕을 받는 사람 : " + p.pNum + "번");
			System.out.println("현재 일인당 나눠주는 사탕의 수 : " + (p.lineCount));
			System.out.println("현재 까지 나눠 준 사탕의 수 : " + (20 - myChew));
			System.out.println("남은 사탕의 수는 : " + (myChew <= 0? 0:myChew));
			System.out.println();
			if(myChew <= 0) {
				break;
			}
			p.lineCount++;
			que.offer(p);

			p = new Person();
			que.offer(p);
		}
		// System.out.println(que.toString());
		System.out.println("20개의 마이쮸가 있을 때 마지막 것을 가져간 사람은 ? " + p.pNum);
	}

}
