import java.util.ArrayList;
import java.util.Collection;

/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}
		
	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				
		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyList");
			
			break;
			
		//Rule 2. MyList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");
			
			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));
			break;

		}
		
	}

	//-------------------------------------------------------------------
	// 1. recursiveDisplayElements --> Displays all elements of a MyList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public int recursiveDisplayElements(MyList<Integer> m){

		int temp = 0;
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		//Rule 1. MyList is empty
		if (m.length() == 0 )
			scenario = 1;
		//Rule 2. MyList base case where list has one element
		else if (m.length() == 1)
			scenario = 2;
		//Rule 3. List has greater than 1 elements
		else if (m.length() > 1)
			scenario = 3;


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch(scenario){

			//Rule 1. MyList is empty
			case 1:
				//1. We print the empty message
				// System.out.println("Error: Empty MyList");
				break;

			//Rule 2. MyList base case where list has one element
			case 2:

				//1. prints out the last element in list
				System.out.print(m.getElement((m.length() - 1)) + " ");


				break;
			//Rule 3. List has greater than 1 elements
			case 3:

				//1. initialize variable to hold last item in the list
               temp  = m.getElement(m.length() - 1);

				//2. remove last item in list from it
				m.removeElement(m.length() - 1);

				//3 recursively call method to break down list to single item
				recursiveDisplayElements(m);

				//4. add element back to the list
				m.addElement(m.length(), temp);

				//5. print results to screen
				System.out.print(m.getElement(m.length() - 1) + " ");

				break;

		}
		return temp;
	}

	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being smaller than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being smaller than 'e'  
	 */	
	public MyList<Integer> smallerMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> result = new MyDynamicList<Integer>();

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		int temp = 0;

		//Rule 1. if list references null
		if(m == null)
			scenario = 1;

		//Rule 2. list is empty
		else if (m.length() == 0 )
			scenario = 2;

		//Rule 2. Base case : List has 1 element
		else if (m.length() == 1 )
			scenario = 3;

		//Rule 3. List has more than 1 element
		else
			scenario = 4;


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){
			//Rule 1. list references null
			case 1:
				//1. We print  message saying reference is null
				System.out.println("Error: List reference is null");
				break;

			//Rule 2. list is empty
			case 2:
				//1. We print the empty message
				// System.out.println("Error: MyList is empty");
				break;

			//Rule 3. Base case : List has 1 element
			case 3:

				//1. checks if element passed in is greater than last element of list
				if (e > m.getElement(0)) {

					//2. if true it gets added to the new list
					result.addElement(0, m.getElement(0));
				}
				break;

			//Rule 4. List has more than 1 element
			case 4:

				//1. assign temp the first element of the list
				temp = m.getElement(0);

				//2. remove first element of list
				m.removeElement(0);

				//3. recursively run method to break down list
				result = smallerMyList(m, e);

				//4. add element back to list
				m.addElement(0, temp);

				//5. compares if the element passed in is greater than variable held by temp
				if(e > temp)
					//6. if smaller it adds smallest element to the first element of result list
					result.addElement(0, temp);

				break;
		}
		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return result;
	}

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyList bigger than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being bigger than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyList<Integer> biggerEqualMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> result = new MyDynamicList<Integer>();

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		int temp = 0;

		//Rule 1. list references null
		if(m == null)
			scenario = 1;

			 //Rule 2. list is empty
		else if (m.length() == 0 )
			scenario = 2;

			//Rule 3. Base case : List has 1 element
		else if ( m.length() == 1 )
			scenario =3;

			//Rule 4. List has more than 1 element
		else
			scenario = 4;


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//----------------------------- 
		switch(scenario){
                //Rule 1.  list references null
			case 1:
				//1. We print  message saying reference is null
				System.out.println("Error: List reference is null");
				break;
			//Rule 2.  list is empty
			case 2:
				//1. We print the empty message
				// System.out.println("Error: MyList is empty");
				break;

			//Rule 3. Base case : List has 1 element
			case 3:

				//1. checks if element passed in is smaller than last element of list
				if (e <= m.getElement(0)) {

					//2. if true it gets added to the new list
					result.addElement(0, m.getElement(0));

				}

				//Rule 4. List has more than 1 element
			case 4:

				//1. assign temp the first element of the list
				temp = m.getElement(0);

				//2. remove first element of list
				m.removeElement(0);

				//3. recursively run method to break down list
				result = biggerEqualMyList(m, e);

				//4. add element back to list
				m.addElement(0, temp);

				//5. compares if the element passed in is smaller than variable held by temp
				if(e <= temp)
					//6. if bigger it adds smallest element to the first element of result list
					result.addElement(0, temp);

				break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return result;
	}
		
	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyList.   
	 * @param m1: The first MyList.
	 * @param m2: The second MyList.
	 * @return: The new MyList resulting of concatenate the other 2 MyList
	 */
	public MyList<Integer> concatenate(MyList<Integer> m1, MyList<Integer> m2){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

		res = new MyDynamicList();


		//-----------------------------
		//Aux Variable
		//-----------------------------
		int e0 = 0;


		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		//Rule 1: If both lists are empty
		if (m1.length() == 0 && m2.length() == 0) {
			scenario = 1;

		//Rule 2: If list m1 is empty
		} else if ( m1.length() == 0 && m2.length() > 0) {
			scenario = 2;

		//Rule 3 : if list m2 is empty
		} else if ( m2.length() == 0 && m1.length() > 0) {
			scenario = 3;


			//Rule 4: if neither lists are empty
		} else if ( m2.length() > 0 && m1.length() > 0) {
				scenario = 4;
			}


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------

		switch(scenario){

			//Rule 1: If both lists are empty
			case 1:
				// if both lists are empty return a message advising both lists are empty

				// currently prints this on all scenario in main unless commented out
				// System.out.print("Error: Nothing to add as both lists are empty");

				break;

			//Rule 2: If list m1 is empty, return m2
			case 2:

				// takes first element of m2 lists and stores in aux variable
				e0 = m2.getElement(0);

				// remove from m2.
				m2.removeElement(0);

				// recursively repeat
				res = concatenate(m1,m2);

				// add element to new result list
				res.addElement(0, e0);

				// add element back to original list
				m2.addElement(0, e0);
				break;

			//Rule 3 : if list m2 is empty, return m1
			case 3:
				// takes first element of m1 lists and stores in aux variable
				e0 = m1.getElement(0);

				// remove from m1.
				m1.removeElement(0);

				// recursively repeat
				res = concatenate(m2,m1);

				// add element to new result list
				res.addElement(0, e0);

				// add element back to original list
				m1.addElement(0, e0);

				break;


			//Rule 4: if neither lists are empty
			case 4:
				// break down m2 to 0 elements and add each element being removed to m1
				// when m2 = 0 it will use case 3 to return m1 with the newly added items.

					e0 = m1.getElement(0);
					m1.removeElement(0);
					res = concatenate(m1,m2);
					res.addElement(0, e0);

					m1.addElement(0, e0);
				
				break ;
		}
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}



	//-------------------------------------------------------------------
	// 4. quickSort --> Sort a MyList using the method quick sort
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyList, it computes a new sorted list using the method Quick Sort.
	 * @param m: The MyList we want to sort.
	 * @return: The new MyList being sorted.
	 */
	public MyList<Integer> quickSort(MyList<Integer> m){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

		//-----------------------------
		//Aux Variables
		//-----------------------------

		MyList<Integer> resOne = null;
		MyList<Integer> resTwo = null;

		res = new MyDynamicList();

		resOne = new MyDynamicList();
		resTwo = new MyDynamicList();

		int e0 = 0;
		//-----------------------------
		//SET OF OPS
		//-----------------------------


		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		//Rule 1: If the lists is empty
		if(m.length() == 0) {
			scenario = 1;
		}
		//Rule 2: If the list has only one item
		else if(m.length() == 1) {
			scenario = 2;
		}
		//Rule 3: If the list has more than one item
		else {
			scenario = 3;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------

		switch(scenario){
			//Rule 1: If the lists is empty
			case 1:
				break;

			//Rule 2: If the list has only one item
			case 2:
				// store the element as aux variable e0
				e0 = m.getElement(0);

				// add aux variable to res list
				res.addElement(0, e0);
				break;


			//Rule 3: If the list has more than one item
			case 3:
				// store the element as aux variable e0
				e0 = m.getElement(0);

				// remove first element from list
				m.removeElement(0);

				//  filter list using the smallerMyList method
				resOne = smallerMyList(m, e0);

				//  filter list using the biggerEqualMyList method
				resTwo = biggerEqualMyList(m, e0);

				// run quick sort
				resOne = quickSort(resOne);

				// run quick sort
				resTwo = quickSort(resTwo);

				// add elements to resTwo list
				resTwo.addElement(0, e0);

				// combine both lists to create result
				res = concatenate(resOne, resTwo);

				// add aux variable back to list passed in
				m.addElement(0, e0);
			}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}




}
