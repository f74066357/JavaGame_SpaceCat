package spaceCat;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class LeaderBoard extends JPanel {
	private static final int TOP_FIVE = 5;
	private static String[][] local_board = new String[TOP_FIVE][2];
	public LeaderBoard() {
		
	}
	//計算排行榜有幾筆資料
	public static int recordNum() {
		int count = 0;
		for(int i = 0; i < TOP_FIVE; i++) {
			if(local_board[i][0] != null) {count++;}
		}
		return count;
	}
	public static void showBoard() {
		for(int i = 0; i < TOP_FIVE; i++) {
			System.out.print((i+1) + " ");
			System.out.printf("%25s %-6s", local_board[i][0], local_board[i][1] );
			System.out.println();
		}
	}
	
	//傳入暱稱及分數, 回傳是否打破紀錄
	public static boolean recordScore(String name, int score) {
		boolean break_or_not = false;
		int ranking = 0;
		int record = recordNum();
		if(record == 0) {
			break_or_not = true;
			ranking = record + 1;
		}else {
			for(int i = 0; i < recordNum(); i++) {
				if(score > Integer.parseInt( local_board[i][1] )) {
					break_or_not = true;
					ranking = i + 1;
					break;
				}
			}
		}
		if((break_or_not == false) && (record < TOP_FIVE)){
			break_or_not = true;
			ranking = record + 1;
		}
		if(break_or_not == true) {
			setRecord(name, score, ranking);
		}
		return break_or_not;
	}
	
	//清空排行榜
	public static void resetTheBoard() {
		for(int i = 0; i < TOP_FIVE; i++) {
			for(int j = 0; j < 2; j++) {
				local_board[i][j] = null;
			}
		}
	}
	
	//從record..txt讀入資料
	public static void readFile() {
		try{
			Scanner scanner = new Scanner(new FileInputStream("record.txt"));
			int position = 0;
			while(scanner.hasNextLine()){
				String aline = scanner.nextLine();
				int first_white = aline.indexOf(' ');
				local_board[position][0] = aline.substring(first_white + 1, aline.length());
				local_board[position][1] = aline.substring(0, first_white);
				position++;
			}
		}catch(Exception e){
			e.printStackTrace();
		 }
        
        
	}
	//寫入資料到record.txt
	public static void writeFile() {
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream("record.txt"));
			for(int i = 0; i < TOP_FIVE; i++) {
				//
				if(local_board[i][1]!=null) {
					writer.print(local_board[i][1] + " ");
					writer.print(local_board[i][0]);
					writer.println();
				}
				//

			}
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		 }
	}
	//若有打破紀錄, 此方法會被recordScore呼叫
	private static void setRecord(String name, int score, int ranking) {
		int record = recordNum();
		if(record == 0) {
			local_board[0][0] = name;
			local_board[0][1] = Integer.toString(score);
		}else if(ranking == (record + 1)){
			local_board[ranking - 1][0] = name;
			local_board[ranking - 1][1] = Integer.toString(score);
		 }else if(record < 5){
			 int position = recordNum() - 1;
			 local_board[position + 1][0] = local_board[position][0];
			 local_board[position + 1][1] = local_board[position][1];
			 while(position > (ranking - 1)) {
					local_board[position][0] = local_board[position - 1][0];
					local_board[position][1] = local_board[position - 1][1];
					position -= 1;
			 }
			 local_board[position][0] = name;
			 local_board[position][1] = Integer.toString(score);
		  }else {
			  int position = recordNum() - 1;
				local_board[position][0] = null;
				local_board[position][1] = null;
				while(position > (ranking - 1)) {
					local_board[position][0] = local_board[position - 1][0];
					local_board[position][1] = local_board[position - 1][1];
					position -= 1;
				}
				local_board[position][0] = name;
				local_board[position][1] = Integer.toString(score);
		   }
	}

}
