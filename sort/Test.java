public class Test {

	public static void main(String[] args) {
		testMSD();
		testLSD();
		test3WayQuick();
	}

	private static void test3WayQuick() {
		System.out.println("Testsing 3WayQuick");
		String[] a = { "tom", "apple", "sells", "are", "seashells", "sea", "by", "seashells", "shore", "surely",
				"the" };
		StringSortAlgo s = new MSD();
		s.sort(a);
		s.print(a);
	}

	private static void testLSD() {
		System.out.println("Testsing LSD");
		String[] a = { "tom", "apple", "sells", "are", "seashells", "sea", "by", "seashells", "shore", "surely",
				"the" };
		StringSortAlgo s = new MSD();
		s.sort(a);
		s.print(a);
	}

	private static void testMSD() {
		System.out.println("Testsing MSD");
		String[] a = { "tom", "apple", "sells", "are", "seashells", "sea", "by", "seashells", "shore", "surely",
				"the" };
		StringSortAlgo s = new MSD();
		s.sort(a);
		s.print(a);
	}

}
