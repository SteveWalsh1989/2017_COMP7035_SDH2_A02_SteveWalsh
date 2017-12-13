
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
	// 1. maxInt --> Computes the maximum item of MyList 
	//-------------------------------------------------------------------	
	/**
	 * The function computes the maximum item of m (-1 if m is empty). 
	 * @param m: The MyList we want to compute its maximum item.
	 * @return: The maximum item of MyList	  
	 */	
	public int maxInt(MyList<Integer> m){


        //1. We assign res to -1
		int res = -1;

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


		//Rule 2. MyList has more than one element
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
        switch(scenario){	
				
		//Rule 1. MyList is empty
		case 1:

			res = -1;

			break;

		//Rule 2. MyList has more than one element
		case 2:
			
			// breaks problem down to simplest form of having one element
			// assumes this element is the highest and recursively compares 
			// it with each removed item from the list as it build it back up, 
			// keeping a running total of the highest number


			//1. We get the first element of MyList
			int e0 = m.getElement(0);

			//2. We remove the first element from MyList we just checked
			m.removeElement(0);

			//3. We recursively solve the smaller problem
			res = maxInt(m);

			//4. compares the result returned with the res value stored,
			//   if the res is higher it makes that the new res
			if (res > e0)
				//5. add element removed back to list
				m.addElement(0, e0);
			else {
				//5 assigns re to be the largest int
				res = e0;
				//6. add element removed back to list
				m.addElement(0, e0);
			}

		}
		// 7. return result of highest number
		return res;
	} // close maxInt

	//-------------------------------------------------------------------
	// 2. isReverse --> Computes if MyList is sorted in decreasing order 
	//-------------------------------------------------------------------	
	/**
	 * The function computes whether m is sorted in decreasing order or not.
	 * @param m: The MyList we want to check.
	 * @return:  Whether m is sorted in decreasing order or not.
	 */
	public boolean isReverse(MyList<Integer> m){

		// initialise result to be false
		boolean result = false;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		//Rule 1. MyList is empty or MyList has one element
		if (m.length() == 0 || m.length() == 1) {
			scenario = 1;

		}//Rule 2. MyList has more than one element
		else {
			scenario = 2;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch(scenario){


			//Rule 1. MyList is empty
			case 1:
				//1. Assign value of result to be true
				result = true;

				break;

			//Rule 2. MyList has one element
			case 2:

				// breaks problem down to simplest form of having one element
				// assumes this element is the highest and recursively compares
				// it with each removed item from the list as it build it back up,


				//2. We get the first element of MyList
				int e0 = m.getElement(0);

				//3. We remove the first element from MyList we just checked
				m.removeElement(0);

				//4. We recursively solve the smaller problem
				result = isReverse(m);

				//5. We compare each item of the new list with e0 to check if lower
				//   to confirm if list is in reverse
				if (result== false || m.getElement(0) > e0 ) {

					//7. add element removed back to list
					m.addElement(0, e0);

					//8. set result to false to be returned
					result = false;
				}

				else {
					//7. add element removed back to list
					m.addElement(0, e0);

					//8. set result to true to be returned
					result = true;
				}

				break;

		}
		// return boolean result advising if the list is sorted in descending order
		return result;
	}

	//-------------------------------------------------------------------
	// 3. getNumAppearances --> Computes the amount of times that integer appears in MyList  
	//-------------------------------------------------------------------	
	/**
	 * The function computes the amount of times that the integer n appears in m.   
	 * @param m: The MyList we want to use.
	 * @param n: The number we want to compute its appearances for.
	 * @return: The amount of appearances of n into m  
	 */	
	public int getNumAppearances(MyList<Integer> m, int n){

		// initialise result to hold the number of appearances
		int result=0;

        // -----------------------------
		// SET OF OPS
		// -----------------------------

		int scenario = 0;


		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------

		// Rule 1: list is empty
		if (m.length() == 0) {
			scenario = 1;
		}
		// Rule 2: list is not empty
		else {
			scenario = 2;
		}

		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		switch (scenario) {
			// Rule 1. MyList is empty
			case 1:
				// set result to zero as nothing in the list to count
				result = 0;

				break;

			// Rule 2. MyList is not empty
			case 2:

				//1. We get the first element of MyList
				int e0 = m.getElement(0);

				//2. We remove the first element of MyList
				m.removeElement(0);

				//3. We recursively run the getNumAppearance method assigning result to value returned
				result = getNumAppearances(m, n);

				//4. add element back to the lists
				m.addElement(0, e0);

				//5. checks if the number entered by the user is the same as element removed from list
				// if it is then it increments the number of appearances value result
				if( n == e0) {
					result++;
				}

		}
		return result;
	}
	
	//-------------------------------------------------------------------
	// 4. power --> Computes the m-est power of n
	//-------------------------------------------------------------------	
	/**
	 * The function computes n to the power of m.
	 * @param n: The base number.
	 * @param m: The power of n we want to compute
	 * @return: n to the power of m.  
	 */	

	public int power(int n, int m){
		// initialize variable to hold the result
		int result=0;



		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		int scenario = 0;

		// Rule 1. if the power is 0 set scenario to 1
		if (m == 0)
			scenario = 1;
			// Rule 2. if power is greater than 0 use scenario 2
		else
			scenario = 2;

		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		switch (scenario) {

			// Rule 1. if the power is 0
			case 1:
				// 1.  set value to 1 as all numbers to power of 0 equals 1
				result = 1;
				break;

			// Rule 2. if power number is greater than zero, calculate the power value
			case 2:

				//1. decreases value of the power
				m--;

				//2. runs power recursively,each time lowering m and returning result
				result = power(n, m);

				//3. multiple result by m to be powered
				result *= n;

				break;

		}
		//4. return the result
		return result;
	}
	
	//-------------------------------------------------------------------
	// 5. lucas --> Computes the n-est term of the Lucas series
	//-------------------------------------------------------------------	
	/**
	 * The function computes the n-est term of the Lucas series
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed 
	 */	
	public int lucas(int n){

        // initialize variable to hold the result
		int result=0;

		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		int scenario = 0;

		// Rule 1. if looking for the first value
		if (n == 0)
			scenario = 1;

		// Rule 2. if looking for the second value
		else if (n == 1)
			scenario = 2;

		// Rule 3. any other n-th value other than 0
		else
			scenario = 3;

		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		switch (scenario) {

			// Rule 1 - if looking for the first term
			case 1:
				// 1. since asking for first 2 numbers, value is 2 ( 1+1 being first 2 numbers in lucas series)
				result = 2;
				break;

			// Rule 2. the second value
			case 2:
				result = 1;
				break;

			// Rule 2. - nth value is greater than 0
			case 3:

				result = (lucas(n - 1) + lucas(n - 2));

				break;

		}
		//4. return the result
		return result;
	}

	//-------------------------------------------------------------------
	// 6. drawImage --> Prints a pattern of a given length
	//-------------------------------------------------------------------	
	/**
	 * The function prints prints a pattern of a given length.
	 * *
	 * **
	 * ***
	 * ... 
	 * @param n: The length of the desired pattern
	 */	
	public String drawImage(int n){

		int scenario = 0;

		String result = null;
		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		// Rule 1. if length is 0 uses scenario 1
		if (n == 0)
			scenario = 1;

		// Rule 2. if length is greater than 0 uses scenario 2
		else
			scenario = 2;


		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		switch (scenario) {

			// Rule 1. if length is 0 uses scenario 1
			case 1:
				// make result empty string as nothing in it so prints blank
				result = "";
				System.out.println();
				break;

			// Rule 2. if length is greater than 0 uses scenario 2
			case 2:
				//1 recursively run method, decreasing the number of items each time
				result = drawImage(n - 1);

				//2 add value of * to num items
				result += "*";

				//3 prints the result
				System.out.println(result);
		}

		// returns result for the recursion in rule 2 above
		return result;

	}
		
}
