package com.test01;

public class DeArrayTest {
	public void testInit() {
		// 2차원 배열
		int[][] iarr1;
		int iarr2[][];

		// 할당
		iarr1 = new int[3][5];

		iarr2 = new int[3][];
		iarr2[0] = new int[5];
		iarr2[1] = new int[5];
		iarr2[2] = new int[5];

		// 2중 for문을 이용하여 배열의 값 출력
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(iarr2[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void testInit2() {
		int[][] iarr = new int[3][5];
/*
		iarr[0][0] = 1;
		iarr[0][1] = 2;
		iarr[0][2] = 3;
		iarr[0][3] = 4;
		iarr[0][4] = 5;

		iarr[1][0] = 6;
		iarr[1][1] = 7;
		iarr[1][2] = 8;
		iarr[1][3] = 9;
		iarr[1][4] = 10;

		iarr[2][0] = 11;
		iarr[2][1] = 12;
		iarr[2][2] = 13;
		iarr[2][3] = 14;
		iarr[2][4] = 15;
		*/
		// 2중 for문을 이용한 값 기록
		int val = 100;
		for (int i = 0; i < iarr.length; i++) {
			for (int j = 0; j < iarr[i].length; j++) {
				iarr[i][j] = val++;
			}
		}

		// 메서드 호출하는 코드
		printArr(iarr);
	}

	public void testInit3() {
		// 가변배열
		int[][] iarr = new int[3][];

		iarr[0] = new int[5];
		iarr[1] = new int[3];
		iarr[2] = new int[10];

		int val = 100;
		for (int i = 0; i < iarr.length; i++) {
			for (int j = 0; j < iarr[i].length; j++) {
				iarr[i][j] = ++val;
			}
		}
		printArr(iarr);

		//
		int[][] iarr2 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };
		int[][] iarr3 = { { 1 }, { 2, 3, 4 }, { 5, 6, 7, 8, 9 }, { 10, 11 } };

		printArr(iarr2);
		printArr(iarr3);
	}

	public void test01() {
		// 구구단을 2차원 배열에 넣어보자
		int[][] arr = new int[8][9];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (i + 2) * (j + 1);
				System.out.println((i + 2) + " * " + (j + 1) + " = " + arr[i][j]);
			}
			System.out.println();
		}
	}

	public void test02() {
		// 5x5 2차원 배열에 아래와 같이 1부터 25까지의 수를 입력하시오.
		// 1 2 3 4 5
		// 10 9 8 7 6
		// 11 12 13 14 15
		// 20 19 18 17 16
		// 21 22 23 24 25

		int[][] arr = new int[5][5];

		int num = 1;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = num;
					num++;
				}
			} else {
				for(int j=arr[i].length-1; j>=0; j--) {
					arr[i][j] = num;
					num++;
				}
			}
		}
		printArr(arr);
	}

	public void printArr(int[][] iarr) {
		for (int i = 0; i < iarr.length; i++) {
			for (int j = 0; j < iarr[i].length; j++) {
				System.out.print(iarr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
