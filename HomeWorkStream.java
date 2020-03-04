import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
import java.util.Map;

public class HomeWorkStream {
	public static void main(String[] args) {
//		1.�������� �������������� ������  ���������. 
//      ��������, ���������� ���������, ����������� � ������������ �������, ������� �������� � �������� ������������������.
//		���������: ������������ summaryStatistics()
		ArrayList<Integer> mas = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			mas.add((new Random().nextInt((200 - 100) + 1)) + 100);
		}
		mas.stream().forEach(s -> System.out.println(s));
		System.out.println();

		System.out.println("Min: " + mas.stream().min(Integer::compare).get());
		System.out.println("Max: " + mas.parallelStream().max(Integer::compare).get());
		System.out.println("Count: " + mas.parallelStream().count());
		System.out.println("Average: " + mas.parallelStream().mapToInt(Integer::intValue).average().getAsDouble());
		System.out.println(mas.parallelStream().mapToInt(Integer::intValue).summaryStatistics());

		String a[] = { "1", "2", "10", "15.15" };
		System.out.println(Arrays.stream(a).mapToDouble(Double::parseDouble).average().getAsDouble());// ��� � ��� ����
//-----------------------------------------------------------------------------
//		2. �������� ���������, �������� �� System.in ����� � ��������� UTF-8,
//		�������������� � ��� ������� ��������� ����, � � ����� ��������� 10 �������� ����� ������������� ����. 
//		(����� �� ������, � ������ ���������� ������ � ���������)
//		������ ����� ������� ����� ����������� ������������������ ��������, ��������� ������ �� ���� � ����. 
//		��������, � ������ " "p!" � ���� ����. ������� ���� ������ ����������� ��� ����� ��������. �������� ����� � ������ ��������.
//		���� � ������ ������ 10 ���������� ����, �� �������� ������� ����.
//		���� � ������ ��������� ����� ����� ���������� �������, �.�. 
//		�� ������ ���������� ����������� ������ �� �������, �� �������������
//		 ����������� ����� � ���������� �������� � ������������������ �������.
//		������ ������ ����� ������ ��� ������ � �������� ����������. 

		System.out.println("\n-----------------------------------");
		String str = "������ ������-������-������ � �� ���������, ���� ���� ���� ���� "+
		"������� ����-����=����:����!���� ���� �� �����, � �� ������� ������ �������� � �����";
		System.out.println(str);

		Stream.of(str.toLowerCase().split("[,/\\s!\\\"�;%:?*()_+=-]+"))
				.collect(Collectors.groupingBy(String::toString, Collectors.counting()))
				.entrySet()
				.stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
				.limit(10)
				.forEach(System.out::println);
		//-----------------------------------------------------------------------------

		

	}
}
