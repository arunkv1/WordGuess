import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class Game {
	private static ArrayList<String> words = new ArrayList<String>();
	private static int points = 0; 
	public static void setWords() throws FileNotFoundException {
		int i = 0; 
		Scanner sc = new Scanner(new File("/Users/arunkrishnavajjala/eclipse-workspace/WordGame/Words.txt"));
		while(sc.hasNext()) {
			String word = sc.next();
			if(!(word.length()<3)) {
				words.add(word);
				i++;
			}
		}
	}
	static boolean remaining = true;
	public static void main(String[] args) throws FileNotFoundException {
		setWords();
		
        final Timer timer = new Timer();
      	while(remaining == true) {
      		boolean t = true;
      		 timer.scheduleAtFixedRate(new TimerTask() {
                 int i = 45;
                 public void run() {
                     i--;
                     if(i==45) {
                     	System.out.println("Start!");
                     }
                     if(i == 30) {
                     	System.out.println("30 Seconds Left!");
                     }
                     if(i == 15) {
                     	System.out.println("15 Seconds Left!");
                     }
                     if(i == 5) {
                     	System.out.println("5 Seconds Left!");
                     }
                     if(i == 1) {
                    	 remaining = false;
                     }
                     if (i<0) {
                     	
                     	System.out.println("Finished!");
                     	System.out.println("Points Scored: " + points);
                        timer.cancel();
                     }
                 }
             }, 0, 1000);
      		 if(t == false) {
      			 break;
      		}
      		Scanner sc = new Scanner(System.in);
      		String answer = "";
      		Random rand = new Random();
      		int n = rand.nextInt(words.size());
      		String word = words.get(n);
      		int point = word.length()*5;
      		String display = "";
      		for(int i = 0; i<word.length(); i++) {
      			if(i == 0) {
      				display+=word.charAt(0);
      			}
      			else if(i == word.length()-1) {
      				display+=word.charAt(word.length()-1);
      			}else {
      				display += "_";
      			}
      		}
      		System.out.println(display + " Worth " + point +" points!");
      		answer = sc.nextLine();
      		while(!answer.equals(word)) {
      			System.out.println(word);
      			System.out.println(display + " Worth " + point +" points!");
      			System.out.println("Try again!");
      			answer = sc.nextLine();
      			if(answer.equals(word)) {
      				points += point;
      			}
      		}
      	}
	}
	
}
















