package ru.exe;

import java.util.stream.Stream;

public class Main {

	/*
	 * static field for multidimensional array. Created by static field by necessary
	 * to work with it, without creation object by Main class.
	 */
	static Element[][] sourceArray = new Element[9][4];

	/*
	 * Method "fillTheArray(Element[][] sourceArray)" which filling the array, by
	 * the standard "for" cycle. Returning the main array which include all values
	 * of Element class objects.
	 */
	Element[][] fillTheArray(Element[][] sourceArray) {

		for (int i = 0; i < sourceArray.length; i++) {
			for (int j = 0; j < sourceArray[i].length; j++) {
				sourceArray[i][j] = new Element();
			}
		}
		return sourceArray;
	}

	/*
	 * Method "findTheNeighbors(Element element)" which accepts object of Element
	 * class as parameter. Searches values from main multidimensional array, creates
	 * and filles new one-dimensionalthe array. Searching parameters is integer x
	 * from Element object as a column and y - as a row. As result returning new
	 * one-dimensionalthe array.
	 */
	Element[] findTheNeighbors(Element element) {

		Element[] found = { sourceArray[element.getX()][element.getY()],
				sourceArray[element.getX() - 1][element.getY() - 1], sourceArray[element.getX() - 1][element.getY()],
				sourceArray[element.getX() - 1][element.getY() + 1], sourceArray[element.getX()][element.getY() - 1],
				sourceArray[element.getX()][element.getY() + 1], sourceArray[element.getX() + 1][element.getY() - 1],
				sourceArray[element.getX() + 1][element.getY()], sourceArray[element.getX() + 1][element.getY() + 1] };
		return found;
	}

	/*
	 * Method which prints all matrix.
	 */
	void printAll() {

		for (Element[] element : sourceArray) {
			for (Element newElement : element) {
				System.out.print(newElement + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// creating new object of Main class for using methods.
		Main main = new Main();

		// fill the main multidimensional array.
		main.fillTheArray(sourceArray);

		main.printAll(); // printed all array if necessary.

		// creating new object of Element class for passing as parameter at find method.
		Element element = new Element(5, 2);

		/*
		 * creating new stream by Stream API for printing the result array which include
		 * the filtered objects.
		 */
		try {
			Stream<Element> stream = Stream.of(main.findTheNeighbors(element));
			stream.forEach(scndStrm -> System.out.println(scndStrm));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.printf("One of input parameters are bigger/smaller then bound of array."
					+ "Element which you try to finding is:"
					+ sourceArray[element.getX()][element.getY()]);
		}
	}
}