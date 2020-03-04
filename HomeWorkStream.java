import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
import java.util.Map;

public class HomeWorkStream {
	public static void main(String[] args) {
//		1.Получите статистические данные  коллекции. 
//      Например, количество элементов, минимальный и максимальный элемент, среднюю величину в числовой последовательности.
//		Подсказка: использовать summaryStatistics()
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
		System.out.println(Arrays.stream(a).mapToDouble(Double::parseDouble).average().getAsDouble());// Это я для себя
//-----------------------------------------------------------------------------
//		2. Напишите программу, читающую из System.in текст в кодировке UTF-8,
//		подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов. 
//		(Можно не читать, а просто определить строку в программе)
//		Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. 
//		Например, в строке " "p!" – пять слов. Подсчет слов должен выполняться без учета регистра. Выводите слова в нижнем регистре.
//		Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
//		Если в тексте некоторые слова имеют одинаковую частоту, т.е. 
//		их нельзя однозначно упорядочить только по частоте, то дополнительно
//		 упорядочите слова с одинаковой частотой в лексикографическом порядке.
//		Задачу решить через стримы без циклов и условных операторов. 

		System.out.println("\n-----------------------------------");
		String str = "Собака бежала-бежала-бежала и не прибежала, коля Коля Коля коЛя "+
		"Николай сиди-СИДИ=сиди:сиДИ!сиди дома не гуляй, а то девочки придут поцнлуют и уйдут";
		System.out.println(str);

		Stream.of(str.toLowerCase().split("[,/\\s!\\\"№;%:?*()_+=-]+"))
				.collect(Collectors.groupingBy(String::toString, Collectors.counting()))
				.entrySet()
				.stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
				.limit(10)
				.forEach(System.out::println);
		//-----------------------------------------------------------------------------

		

	}
}
