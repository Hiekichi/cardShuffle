package com.hiekichi.cardshuffle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * DevQuiz2011用に作ったような気がする。今は昔……
 */
public class CardShuffleApp {
	
	int[] cards;
	int[] cardsTmp;
	int mMondaiSuu;       // T
	int mCardMaisuu;      // M
	int mCutKaisuu;       // C
	int mShiritaiBanme;   // W
	int mA;
	int mB;
	
	public static void main(String[] args) {
		new CardShuffleApp();
		
	}
	public CardShuffleApp() {
	//	System.out.println("★開始★");
        try{
        	// 読み込む準備
            FileReader f = new FileReader("data.txt");
            BufferedReader b = new BufferedReader(f);
            String s;
            String[] col;
            
            // 問題数の行を読む
            s = b.readLine();
            mMondaiSuu = Integer.parseInt(s);

            for (int i1 = 0; i1 < mMondaiSuu; ++i1) {
	            // 各問題のMCWの行を読む
	            s = b.readLine();
	            col = s.split(" ");
	            mCardMaisuu     = Integer.parseInt(col[0]);
	            mCutKaisuu      = Integer.parseInt(col[1]);
	            mShiritaiBanme  = Integer.parseInt(col[2]);
	            
            	cards = new int[100000000];
//            	cards = new int[mCardMaisuu];
	            initCards(mCardMaisuu);
	            for (int i2 = 0; i2 < mCutKaisuu; ++i2) {
	            	cardsTmp = new int[mCardMaisuu];
	            	// シャッフル
		            s = b.readLine();
		            col = s.split(" ");
		            mA   = Integer.parseInt(col[0]);
		            mB   = Integer.parseInt(col[1]);
	            	
		            for (int i = 0; i < mB; ++i) {
		            	cardsTmp[i] = cards[mA + i - 1];
		            }
		            for (int i = 0; i < mA - 1; ++i) {
		            	cardsTmp[mB + i] = cards[i];
		            }
		            for (int i = mA + mB - 1; i < mCardMaisuu; ++i) {
		            	cardsTmp[i] = cards[i];
		            }
		            cards = cardsTmp;
		            System.gc();
	            }
	            System.out.println("Case #" + (i1 + 1) + ": " + cards[mShiritaiBanme - 1]);
            }
            
            
        }
        catch (IOException e) {
        	System.out.println("Exception!!" + e.toString());
        }
//		System.out.println("★おしまい★");
	}
	
	public void initCards(int max) {
		//System.out.println("★初期化開始★");
		for (int i = 0; i < max; ++i) {
			cards[i] = i + 1;
		}
	}
	
	public void printCards(int max) {
		System.out.println("★印刷開始★");
		for (int i = 0; i < max; ++i) {
//			System.out.println(cards[i]);
		}
	}
}
