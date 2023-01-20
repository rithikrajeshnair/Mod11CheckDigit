package mod11CheckDigit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckDigitGeneration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Begining number :");
		int begin = sc.nextInt();
		System.out.println("Last number: ");
		int end = sc.nextInt();
		List<Integer> CheckDigitList = new ArrayList<>();
		int num = begin;
		int temp = num / 10;
		int a;
		while (num <= end) {
			a = generator(temp);
			if (a != -1) {
				CheckDigitList.add(a);
				num = a;
			}
			temp += 1;
		}
		sc.close();
		System.out.println(CheckDigitList);
	}

	private static int generator(int temp) {
		int num = temp;
		List<Integer> arr = new ArrayList<>();
		int factor = -1;

		while (temp > 0) {
			factor++;
			arr.add(temp % 10);
			temp = temp / 10;
		}
		int sum = 0;
		for (int i : arr) {
			sum += i * factor;
		}
		int modVal = sum % 11;
		if (11 - modVal <= 9) {
			int checkDigit = 11 - modVal + 10 * num;
			return checkDigit;
		} else if (modVal == 0) {
			return num * 10;
		} else {
			return -1;
		}
	}
}
