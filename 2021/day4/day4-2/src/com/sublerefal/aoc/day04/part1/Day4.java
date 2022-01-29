
package com.sublerefal.aoc.day04.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {
	public static int BOARD_SIZE = 5;
	
	public static void main(String[] args) {
		String input = getInput();
		String[] inputLines = input.split("\r\n");
		
		List<Integer> numbers = getNumbers(inputLines);
		
		List<Board> boards = new ArrayList<Board>();
		for(int i=2; i<inputLines.length; i+= BOARD_SIZE+1) {
			int[] boardLines = getBoardFromLineIndex(inputLines, i);
			boards.add(new Board(boardLines, BOARD_SIZE));
		}
	
		Board lastWinningBoard = null;
		for(int i=0; i<numbers.size(); i++) {
			for(int j=0; j<boards.size(); j++) {
				Board board = boards.get(j);
				if(!board.isWon()) {
					board.markNumber(numbers.get(i));
					if(board.isWon()) {
						lastWinningBoard = board;
					}
				}
			}
		}
		
		System.out.println(lastWinningBoard.calculateScore());
	}
	
	private static int[] getBoardFromLineIndex(String[] inputLines, int index) {
		List<Integer> boardNumbers = new ArrayList<Integer>();
		
		String boardLine = inputLines[index];
		while(!boardLine.trim().equals("")) {
			String[] stringNumbers = boardLine.trim().split("\s+");
			for(int i=0; i<stringNumbers.length; i++) {
				boardNumbers.add(Integer.parseInt(stringNumbers[i].trim()));
			}
			index++;
			if(index < inputLines.length) {
				boardLine = inputLines[index];
			}else {
				boardLine = "";
			}
		}
		
		return boardNumbers.stream().mapToInt(i -> i).toArray();
	}
	
	private static List<Integer> getNumbers(String[] inputLines) {
		List<String> numbersString = Arrays.asList(inputLines[0].split(","));
		List<Integer> numbers = numbersString.stream().map(str -> Integer.parseInt(str)).collect(Collectors.toList());
		return numbers;
	}
	
	public static String getInput() {
//		return "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1\r\n"
//				+ "\r\n"
//				+ "22 13 17 11  0\r\n"
//				+ " 8  2 23  4 24\r\n"
//				+ "21  9 14 16  7\r\n"
//				+ " 6 10  3 18  5\r\n"
//				+ " 1 12 20 15 19\r\n"
//				+ "\r\n"
//				+ " 3 15  0  2 22\r\n"
//				+ " 9 18 13 17  5\r\n"
//				+ "19  8  7 25 23\r\n"
//				+ "20 11 10 24  4\r\n"
//				+ "14 21 16 12  6\r\n"
//				+ "\r\n"
//				+ "14 21 17 24  4\r\n"
//				+ "10 16 15  9 19\r\n"
//				+ "18  8 23 26 20\r\n"
//				+ "22 11 13  6  5\r\n"
//				+ " 2  0 12  3  7";
		
		return "23,30,70,61,79,49,19,37,64,48,72,34,69,53,15,74,89,38,46,36,28,32,45,2,39,58,11,62,97,40,14,87,96,94,91,92,80,99,6,31,57,98,65,10,33,63,42,17,47,66,26,22,73,27,7,0,55,8,56,29,86,25,4,12,51,60,35,50,5,75,95,44,16,93,21,3,24,52,77,76,43,41,9,84,67,71,83,88,59,68,85,82,1,18,13,78,20,90,81,54\r\n"
		+ "\r\n"
		+ "50 98 65 14 47\r\n"
		+ " 0 22  3 83 46\r\n"
		+ "87 93 81 84 58\r\n"
		+ "40 35 28 74 48\r\n"
		+ "45 99 59 37 64\r\n"
		+ "\r\n"
		+ "85 66 90 32 88\r\n"
		+ "95  6  4 74 27\r\n"
		+ " 1 10 70 41 92\r\n"
		+ "54 36 42  9 39\r\n"
		+ "60 99 31 67 16\r\n"
		+ "\r\n"
		+ " 4 44 66 10 58\r\n"
		+ "33 64 93 42 46\r\n"
		+ "19 63  6 83 54\r\n"
		+ "60 51 76  8 30\r\n"
		+ "71 49 73  7 55\r\n"
		+ "\r\n"
		+ "17 67 52 61 98\r\n"
		+ "46  5  4 51 76\r\n"
		+ "73 59 74  8 33\r\n"
		+ "48 96 20 26 15\r\n"
		+ "55 19 86 29 43\r\n"
		+ "\r\n"
		+ "20 75 12 67 41\r\n"
		+ "89 36 65 66 92\r\n"
		+ "40 19  1  0 28\r\n"
		+ "99 61 85 58 50\r\n"
		+ "44 72 57 35 86\r\n"
		+ "\r\n"
		+ "69 87 27 59 33\r\n"
		+ "47 34 60 93  9\r\n"
		+ "71 84 46 24 96\r\n"
		+ "15 91  5 61 19\r\n"
		+ "57 78 55 31  8\r\n"
		+ "\r\n"
		+ "19 10  1 81 96\r\n"
		+ "27 71  2 52 56\r\n"
		+ "15 22 48 82 34\r\n"
		+ "64 47 42 49 51\r\n"
		+ "26 72 61 12 57\r\n"
		+ "\r\n"
		+ "71 94 40 34 26\r\n"
		+ "12 80 57 38 55\r\n"
		+ " 4 56 11 73 49\r\n"
		+ "75 60 61  9 50\r\n"
		+ "91 70 23  1 90\r\n"
		+ "\r\n"
		+ "39 86 30 73 38\r\n"
		+ " 6 53 58 14 36\r\n"
		+ "85 12 75 88  5\r\n"
		+ " 0 29 41 21 15\r\n"
		+ "47 66 59 54  1\r\n"
		+ "\r\n"
		+ "99 97 50 17 60\r\n"
		+ "36 13 29 80 32\r\n"
		+ "49 85 75 71 15\r\n"
		+ "10 79 41 61 66\r\n"
		+ "68 57 55 74 98\r\n"
		+ "\r\n"
		+ "68 33 87 89 59\r\n"
		+ "96 35 76 78 55\r\n"
		+ " 4 63 51 10 65\r\n"
		+ "58 38 22 54  9\r\n"
		+ "66 18 37 60  6\r\n"
		+ "\r\n"
		+ "43 86 50 23 77\r\n"
		+ "10 42 19 61  2\r\n"
		+ "40 29 20 84  0\r\n"
		+ "70 59 96 80 57\r\n"
		+ "76 12 39 36  6\r\n"
		+ "\r\n"
		+ "73 43 92 37 99\r\n"
		+ "36 42 10 77 87\r\n"
		+ " 3 57  4 20 35\r\n"
		+ "18  7 46 91 11\r\n"
		+ "17 98  8 53 61\r\n"
		+ "\r\n"
		+ "22 37 89 51  9\r\n"
		+ "71  6 72 87 32\r\n"
		+ "13 79 86 53 98\r\n"
		+ "16  2 93 48 38\r\n"
		+ "63 82 66 61 69\r\n"
		+ "\r\n"
		+ "73 90 85 54 65\r\n"
		+ " 9 66 28  5 63\r\n"
		+ "91 50 70 59 80\r\n"
		+ "95 68 92 72 67\r\n"
		+ "69 88 36 43 53\r\n"
		+ "\r\n"
		+ "36 81 66 78 90\r\n"
		+ " 2 25 94 82 55\r\n"
		+ "34 45  1 14 37\r\n"
		+ "13  4 70 48 75\r\n"
		+ "67 73 32 18 91\r\n"
		+ "\r\n"
		+ "33 93 71 48 47\r\n"
		+ " 8 79 69 53 82\r\n"
		+ " 5 31 80 45 37\r\n"
		+ "67 77 41 56 97\r\n"
		+ "65 46 62 42 81\r\n"
		+ "\r\n"
		+ "67 70 59 24 88\r\n"
		+ "84 11 29 52 78\r\n"
		+ " 4 39 12 90  2\r\n"
		+ "44  3 10 75 89\r\n"
		+ "30 93 22 14  8\r\n"
		+ "\r\n"
		+ "79 60 98 99 49\r\n"
		+ "23 26 86 91 38\r\n"
		+ "77 45 95 66 75\r\n"
		+ "81 42 85 21  3\r\n"
		+ "40 37 65 20 50\r\n"
		+ "\r\n"
		+ "12 54  0 86 52\r\n"
		+ "15 56 29 39 94\r\n"
		+ "66 79 14 65 26\r\n"
		+ " 3  4 59 60 40\r\n"
		+ "47 48 19 13 85\r\n"
		+ "\r\n"
		+ "32 44 69 90 21\r\n"
		+ "35  8  1 59 56\r\n"
		+ "72 71 84 18 11\r\n"
		+ "96 38 23 37 79\r\n"
		+ "92 20 33 94 17\r\n"
		+ "\r\n"
		+ " 1 94 42 21 82\r\n"
		+ "92 60  9 32 38\r\n"
		+ "71  3 37 77 18\r\n"
		+ "89 16 74 76  2\r\n"
		+ "83 30 28 11 70\r\n"
		+ "\r\n"
		+ "94  3  1 71 87\r\n"
		+ " 6 66 19 76 28\r\n"
		+ "10 86 22 62  2\r\n"
		+ "67  0 31 46 27\r\n"
		+ " 8 33 43 92 29\r\n"
		+ "\r\n"
		+ "35 90  8 30 27\r\n"
		+ "67 60 82 68  1\r\n"
		+ " 5 29 93 44 34\r\n"
		+ "56 65 48 37 51\r\n"
		+ "57 45 63 94 77\r\n"
		+ "\r\n"
		+ "67 80 45 57 43\r\n"
		+ "37 81 25 84 82\r\n"
		+ "50  8  9 64  7\r\n"
		+ "29 18 52 16 14\r\n"
		+ "73 28 11 76  6\r\n"
		+ "\r\n"
		+ " 5 76 67 18 16\r\n"
		+ "68 47 15 29 59\r\n"
		+ "46 32 40  9 84\r\n"
		+ "30 17 20 22  3\r\n"
		+ "35 80 38 72 88\r\n"
		+ "\r\n"
		+ "35 44 14 89 72\r\n"
		+ "75 67 56  2  3\r\n"
		+ "58 41 49 12 52\r\n"
		+ "92  9 22 34 88\r\n"
		+ "65 39 93 61 47\r\n"
		+ "\r\n"
		+ "38 67 33 18 60\r\n"
		+ "34 50 69 31 83\r\n"
		+ "29 30  9 12 95\r\n"
		+ "79  2 24 54 87\r\n"
		+ "46 68 48 58 42\r\n"
		+ "\r\n"
		+ "61 87 46 26 34\r\n"
		+ "74 85  9 54 38\r\n"
		+ "50 29 84 40  4\r\n"
		+ "49 39 33 99 53\r\n"
		+ "77 59  0 42 35\r\n"
		+ "\r\n"
		+ "86 68 23 62  5\r\n"
		+ "96 92  7  4  1\r\n"
		+ "50 70 12 83 46\r\n"
		+ "34 63 91 56 11\r\n"
		+ "76 90 71 88 95\r\n"
		+ "\r\n"
		+ "19 18 13  3 62\r\n"
		+ "42 29 57 79 85\r\n"
		+ "39 64 14 28 98\r\n"
		+ "99 36 91  9 63\r\n"
		+ "69 66  2 17 31\r\n"
		+ "\r\n"
		+ "51 43 49 98 94\r\n"
		+ "31 64 53 54 57\r\n"
		+ " 3 28 10 12  2\r\n"
		+ "24 99 95 35 17\r\n"
		+ "76 27 48  0 41\r\n"
		+ "\r\n"
		+ "80 62 13 38 98\r\n"
		+ "32 15 16  8 96\r\n"
		+ "93 43 81 99 40\r\n"
		+ "20 57 37 24  3\r\n"
		+ "94 17 70 14  7\r\n"
		+ "\r\n"
		+ "52 71 49 95 84\r\n"
		+ "76 38 45 59 89\r\n"
		+ " 1  7 27  0 98\r\n"
		+ "92 64  8 50 68\r\n"
		+ "13 91 26 51  2\r\n"
		+ "\r\n"
		+ "31 45 25  1  5\r\n"
		+ "50 68 77 61 53\r\n"
		+ "74 20 99 38 63\r\n"
		+ "76 44 15 42 51\r\n"
		+ "67 87 86 12 24\r\n"
		+ "\r\n"
		+ "49  0 70 82  9\r\n"
		+ " 2 24 96 74 60\r\n"
		+ "68 16 40 32 20\r\n"
		+ "48  6 98 11 65\r\n"
		+ "94 10 54  8 95\r\n"
		+ "\r\n"
		+ "74 41 11 33 76\r\n"
		+ " 2 10 44 89 23\r\n"
		+ "56 45 78 60 34\r\n"
		+ "15  5 26 83 71\r\n"
		+ "20 72 85 75 54\r\n"
		+ "\r\n"
		+ "15 59 93 53  8\r\n"
		+ " 4 10 84 44 36\r\n"
		+ "17 62 24 27 98\r\n"
		+ "87 54 73 13 35\r\n"
		+ " 9 48 52 33  7\r\n"
		+ "\r\n"
		+ "56 80 70 74 35\r\n"
		+ "53 69 75 25 27\r\n"
		+ "47 91 85 62 32\r\n"
		+ "93 26 89 18 52\r\n"
		+ "16 73 49 55 77\r\n"
		+ "\r\n"
		+ "42 40 54 67 73\r\n"
		+ "11 10 49 35 59\r\n"
		+ "12 93 37 15 69\r\n"
		+ "97 41 47 39  2\r\n"
		+ "75 99 21 29 26\r\n"
		+ "\r\n"
		+ "23 75 41 10 86\r\n"
		+ "71 67 66 38 99\r\n"
		+ "91 92 63 40 28\r\n"
		+ "69 97 42 77 60\r\n"
		+ "44 53 12 84 57\r\n"
		+ "\r\n"
		+ "72 51 31 90 37\r\n"
		+ "35 89 55 73 87\r\n"
		+ "46 32 45  0 58\r\n"
		+ "50 81 13 18 66\r\n"
		+ "38  4 40 62 22\r\n"
		+ "\r\n"
		+ "14 48 35 76 83\r\n"
		+ "13 70 26  4  1\r\n"
		+ "30 22 91 93 29\r\n"
		+ "69 41 74 40 63\r\n"
		+ "80 65 66 72 23\r\n"
		+ "\r\n"
		+ "23 65 33 56 38\r\n"
		+ "84 41 34 21  2\r\n"
		+ " 4 78 27 17 11\r\n"
		+ "22 53 52 32 80\r\n"
		+ "24 25 42 91 99\r\n"
		+ "\r\n"
		+ "54 51  0 23 52\r\n"
		+ "92 69 10 46  7\r\n"
		+ "20 35 12 37 73\r\n"
		+ "19 56 26 79 32\r\n"
		+ "27 74 34  5 57\r\n"
		+ "\r\n"
		+ "75 10 24 32  7\r\n"
		+ "96 54 22 78  5\r\n"
		+ "23 69 65 43 20\r\n"
		+ "29 85 44 92 71\r\n"
		+ "41 87 73  0 48\r\n"
		+ "\r\n"
		+ "54 92 16 36 37\r\n"
		+ "42 59  4  9 44\r\n"
		+ "52 14 12  6 47\r\n"
		+ "57 38 70 82  0\r\n"
		+ "53 81 32 35  3\r\n"
		+ "\r\n"
		+ "17 22 62 80 30\r\n"
		+ " 8 28 15 42 46\r\n"
		+ "79 64 32 29 75\r\n"
		+ " 5  0  9 90 69\r\n"
		+ "41 71 85  1  6\r\n"
		+ "\r\n"
		+ "68 89 40 31 39\r\n"
		+ "32 48 64 38 28\r\n"
		+ "80 98 88 14 97\r\n"
		+ " 6 60 52 11 55\r\n"
		+ "95 34 63 81  4\r\n"
		+ "\r\n"
		+ "80 33 14 83 68\r\n"
		+ "78 69 81 59 15\r\n"
		+ "72  0 74 21 75\r\n"
		+ "49  6 67 73 64\r\n"
		+ " 8 25 87  3 45\r\n"
		+ "\r\n"
		+ "34 97 86  1 79\r\n"
		+ "49 12 63 10 59\r\n"
		+ "88 30 84 74 87\r\n"
		+ "67 47 26  0 57\r\n"
		+ "71 40  2 76 98\r\n"
		+ "\r\n"
		+ "15 89 23 65 44\r\n"
		+ "27 87 54 38 12\r\n"
		+ "43 29 18 39 94\r\n"
		+ "48  0  7 57 61\r\n"
		+ "70 28 60 68 50\r\n"
		+ "\r\n"
		+ "13 34 49 67 40\r\n"
		+ "88 74 99 20 26\r\n"
		+ "63 69 62 24 32\r\n"
		+ "35 45 96 79  1\r\n"
		+ "92  7 17 76 30\r\n"
		+ "\r\n"
		+ "95 21 75 46 74\r\n"
		+ "39  7 58 23 90\r\n"
		+ "61 64 37 81 82\r\n"
		+ "92 36 54  9 53\r\n"
		+ "17 51 33 10 27\r\n"
		+ "\r\n"
		+ "67 35 44 22 23\r\n"
		+ "28 96  1 56 29\r\n"
		+ " 0 12  5 50 99\r\n"
		+ "70 42  8 24 25\r\n"
		+ "39 53 51 89 85\r\n"
		+ "\r\n"
		+ "50 15 94 84 27\r\n"
		+ "72 26 51  3 85\r\n"
		+ "63 45  1 64 44\r\n"
		+ "17 80 13 88  2\r\n"
		+ "12 97 91 25 18\r\n"
		+ "\r\n"
		+ "59 14  9 67 63\r\n"
		+ " 6 18 26 98 50\r\n"
		+ "86 74 75 56 34\r\n"
		+ "48  7 99 20 64\r\n"
		+ " 8 53 10 15 57\r\n"
		+ "\r\n"
		+ " 6 35 13 68 24\r\n"
		+ "90 19 91 71 86\r\n"
		+ "95 58 10 44 98\r\n"
		+ " 8 41 60  1 16\r\n"
		+ "29 59 43 84 48\r\n"
		+ "\r\n"
		+ "48 56  8 74  4\r\n"
		+ "66 30 77 35 90\r\n"
		+ "94  0 75 49 84\r\n"
		+ " 5 39 11 54 87\r\n"
		+ "33 58 96 22  2\r\n"
		+ "\r\n"
		+ " 5 38 57 63 65\r\n"
		+ "74 58 22  8 81\r\n"
		+ "45 96 78  3 11\r\n"
		+ "28 42 30 39 51\r\n"
		+ "87 33 34 75 14\r\n"
		+ "\r\n"
		+ "56 34 67 70 17\r\n"
		+ " 7 80 10 31 85\r\n"
		+ "68 59 63 74 40\r\n"
		+ "13 81 99 62  6\r\n"
		+ "92 84 71 37 39\r\n"
		+ "\r\n"
		+ "85 99 74 16 10\r\n"
		+ "12 21 91  2 83\r\n"
		+ " 4 94 38 51 36\r\n"
		+ "41 97 45 65 24\r\n"
		+ "50 82 92 52 35\r\n"
		+ "\r\n"
		+ "28 65  6 13 23\r\n"
		+ " 7 57 86 18 67\r\n"
		+ "26 85 29 22 89\r\n"
		+ "99 62 94 31 96\r\n"
		+ "14 17 50 56  9\r\n"
		+ "\r\n"
		+ "98 10 63  4  8\r\n"
		+ "46 21 58 89  3\r\n"
		+ "27 12 11 55 16\r\n"
		+ "61 38 43 33 54\r\n"
		+ "53 14 99 31 25\r\n"
		+ "\r\n"
		+ "25 70 24 40 14\r\n"
		+ "75 82 58 68 41\r\n"
		+ "22 71 72 93  1\r\n"
		+ "47 97  6 81 45\r\n"
		+ "92 42  2 76 12\r\n"
		+ "\r\n"
		+ "31 84 30  0 85\r\n"
		+ "55 70 72 45 57\r\n"
		+ "78 52 67 60 22\r\n"
		+ "43 32  8 44 34\r\n"
		+ "14 64 91 89 18\r\n"
		+ "\r\n"
		+ "70 19 62 16 56\r\n"
		+ "84 49 41  3 20\r\n"
		+ "85  5 76 95 22\r\n"
		+ "63 55 37 31 72\r\n"
		+ "42 17 28 65  1\r\n"
		+ "\r\n"
		+ "85 17 57 62 48\r\n"
		+ "34 29 69 52 28\r\n"
		+ "90 64 54 21 38\r\n"
		+ " 0 50 84 44 60\r\n"
		+ "93 80 75 89 83\r\n"
		+ "\r\n"
		+ "39 84 78 12  5\r\n"
		+ "29  4 35  7 85\r\n"
		+ "73 25 58 27 45\r\n"
		+ "22 90 91 47 74\r\n"
		+ "60 96 15 24 26\r\n"
		+ "\r\n"
		+ "13 30 82 31 43\r\n"
		+ "23 71  1 51 36\r\n"
		+ "40 62 25 54 86\r\n"
		+ " 8 83  2 47 34\r\n"
		+ "33 41 27 98 24\r\n"
		+ "\r\n"
		+ "13 25 53 50 56\r\n"
		+ "77  4 41 19 22\r\n"
		+ "68 70 75  9 65\r\n"
		+ "30 33 60 74 80\r\n"
		+ "31 83 34 79 11\r\n"
		+ "\r\n"
		+ "11 90 38 78 73\r\n"
		+ "17 16 14 37  4\r\n"
		+ "80 68 21 70 92\r\n"
		+ "47 26 81 67 25\r\n"
		+ "10 31 23 41 22\r\n"
		+ "\r\n"
		+ "90 62  2 50 79\r\n"
		+ "77 51  8 11 13\r\n"
		+ "32 29 43 88 33\r\n"
		+ "39 34 89 45 23\r\n"
		+ "91  9  6 68  3\r\n"
		+ "\r\n"
		+ "62 70 89 27 87\r\n"
		+ "45 65 96 80 29\r\n"
		+ " 1 54 90 68 16\r\n"
		+ "72 50 28 95 12\r\n"
		+ "21 71 81 10 60\r\n"
		+ "\r\n"
		+ "33 14 60 44 78\r\n"
		+ " 6 65 87 11  8\r\n"
		+ "79 21 59 35 19\r\n"
		+ "26 69 67 42 27\r\n"
		+ "25 36 80 10 45\r\n"
		+ "\r\n"
		+ "71 24 80 87 56\r\n"
		+ " 7 61 43 38 18\r\n"
		+ "52 46 41 28 48\r\n"
		+ " 0 74 20 34 63\r\n"
		+ " 3 84 42 85  9\r\n"
		+ "\r\n"
		+ "36 64 41  7 49\r\n"
		+ "91 92 13 94 88\r\n"
		+ "73 98 79  0 12\r\n"
		+ "76 66 86 67  9\r\n"
		+ " 2 85 74  5 34\r\n"
		+ "\r\n"
		+ " 8 81  7 56 28\r\n"
		+ "36 13 42 29 75\r\n"
		+ "12 27 85 45  9\r\n"
		+ "26 25 62 41 22\r\n"
		+ "79 11 95  0 24\r\n"
		+ "\r\n"
		+ "72 76 81 67 16\r\n"
		+ "96 41 94 58  7\r\n"
		+ " 0 79 38 27 11\r\n"
		+ "61 36 56 88 39\r\n"
		+ "89 63 31 75  8\r\n"
		+ "\r\n"
		+ "62 51  5 46 28\r\n"
		+ "77 97 89 86 13\r\n"
		+ "87 55 73 90 57\r\n"
		+ "84 44 40 49 34\r\n"
		+ "25  0 58  6 21\r\n"
		+ "\r\n"
		+ " 7 56 15 41 94\r\n"
		+ "42 89 16 18 74\r\n"
		+ "57 79 96 35  3\r\n"
		+ "14 45 20 19 80\r\n"
		+ "87 85 28 69 17\r\n"
		+ "\r\n"
		+ "27 88 54 62 65\r\n"
		+ "44 93 69 13  9\r\n"
		+ "85 63 43 11 47\r\n"
		+ "83 57 30 20 56\r\n"
		+ "71 46 49  7 77\r\n"
		+ "\r\n"
		+ "45 24 75 39 69\r\n"
		+ "48 74 44 49 64\r\n"
		+ "65 25 22 46 93\r\n"
		+ "88 52 27 37 50\r\n"
		+ "19 35 47 54 67\r\n"
		+ "\r\n"
		+ "44 32 71 13 57\r\n"
		+ " 7 38 26 98 65\r\n"
		+ "46  1 21  8 55\r\n"
		+ "30 62 92 27  3\r\n"
		+ "69 50 99 85 11\r\n"
		+ "\r\n"
		+ "86  6 64 34 97\r\n"
		+ "47 98  7 38  9\r\n"
		+ "26 68 75 92 54\r\n"
		+ "58 42 13 78 37\r\n"
		+ "85 28 81 16 51\r\n"
		+ "\r\n"
		+ "82 74 15  4 86\r\n"
		+ "55  0 70 88 24\r\n"
		+ "50 79 63 40 21\r\n"
		+ "47 39 61 49 36\r\n"
		+ "89 16 13  2 37\r\n"
		+ "\r\n"
		+ "89 19  9 82 13\r\n"
		+ "84 34 58 56 10\r\n"
		+ "27 92 46  4 94\r\n"
		+ "44 24 52 86 55\r\n"
		+ "39 23 22 99  5\r\n"
		+ "\r\n"
		+ "65 92  8 86 77\r\n"
		+ "98 79 72 28 78\r\n"
		+ "16 23  3 55 48\r\n"
		+ "68 95 66 30 43\r\n"
		+ "50 31 15 11 45\r\n"
		+ "\r\n"
		+ "32 70 25 59 31\r\n"
		+ "47 68 77 56 23\r\n"
		+ "66 78 54 88 50\r\n"
		+ "55 60 58 89 83\r\n"
		+ "84 99 86 97 95\r\n"
		+ "\r\n"
		+ "53 46  1 94 87\r\n"
		+ " 8 80 38 77 81\r\n"
		+ "17 51 47 19 69\r\n"
		+ "86 50 71  5 93\r\n"
		+ "61 66 36 58  0\r\n"
		+ "\r\n"
		+ "90 58 17 29 92\r\n"
		+ "67  1  8 64 99\r\n"
		+ "63 22 57 19 68\r\n"
		+ "78 36 93 53  2\r\n"
		+ "27 48 62 39 14\r\n"
		+ "\r\n"
		+ " 8 49 22 90 54\r\n"
		+ "26  4 99 27 34\r\n"
		+ "78 25 11 85 28\r\n"
		+ "31 42 36 53 15\r\n"
		+ "64 75 60 45 35\r\n"
		+ "\r\n"
		+ "99 84 26 53 90\r\n"
		+ "61 51 98 39 86\r\n"
		+ "47 37 52 80 63\r\n"
		+ "67 49 35 70 11\r\n"
		+ "32 45 94 73 43\r\n"
		+ "\r\n"
		+ "91 92 74 94 32\r\n"
		+ "27 56 50 33 54\r\n"
		+ "67 46 35 25 10\r\n"
		+ "93 97 30 90  4\r\n"
		+ "57 15 69 83 39\r\n"
		+ "\r\n"
		+ "71 68 74 81 11\r\n"
		+ "44 98 60 17 73\r\n"
		+ "43 40 32 38 39\r\n"
		+ "61 56 97 94 70\r\n"
		+ "23  2 86 91 54\r\n"
		+ "\r\n"
		+ "19 98 93 42 88\r\n"
		+ " 0 16 30 32 71\r\n"
		+ "89 86 81 76 68\r\n"
		+ "29  2 14 72 63\r\n"
		+ " 7 27 67 59  1\r\n"
		+ "\r\n"
		+ "24 18 28 98 95\r\n"
		+ "10 62 80 71 36\r\n"
		+ " 3 89 20 63 46\r\n"
		+ "47 65 84 22  6\r\n"
		+ "82 19 81 38 45\r\n"
		+ "\r\n"
		+ "54 85 67 34 79\r\n"
		+ "25 58 38 73 61\r\n"
		+ "72 98  4 19 40\r\n"
		+ "32 10 29 31 89\r\n"
		+ "15 33  5  7 63\r\n"
		+ "\r\n"
		+ "49 48 71 81 88\r\n"
		+ "70  5 39 41 22\r\n"
		+ "19 20  7 75 23\r\n"
		+ "69 46 63 14 54\r\n"
		+ "80 45 94  6 55\r\n"
		+ "\r\n"
		+ "88 62 76 78 95\r\n"
		+ "64 65 36 58 22\r\n"
		+ " 7 21 98 93 42\r\n"
		+ "79 99  9 89 10\r\n"
		+ " 6  5 33 92 72";
	}
}
