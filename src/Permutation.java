import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Permutation {

	public static void main(String[] args) {
		String s;
		StringBuilder st = new StringBuilder();
		RandomizedQueue<String> q = new RandomizedQueue<String>();
		s=StdIn.readLine();
		int i=0;
		while (i <= s.length()) {
			if ((i<s.length()) && s.charAt(i) != ' ') {
				st.append(s.charAt(i));
				i++;
			}
			else {
				if(st.length() != 0) {
					q.enqueue(st.toString());
					st.delete(0, st.length());
				}
				i++;
			}
		}
		for (String str: q) {
			StdOut.println(str);
		}

	}

}
