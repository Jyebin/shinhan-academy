package chapter06.excer;

public class CalculatorImpl implements Calculator {

	@Override
	public long factorial(int num) {
		// 시간 측정
		long start = System.nanoTime();

		long result = 1;
		for (int i = 1; i <= num; i++) {
			result *= i;
		}

		// 시간 측정
		long end = System.nanoTime();
		System.out.println("소요시간 : " + (end - start));

		return result;
	}

}
