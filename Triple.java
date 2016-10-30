package com.example;

public class Triple {
	
static int sides = 100;
static int count = 0;

// The main program will call methods that 1.) trap the start time, 2.) find the triples, 
// 3.) format the output, and 4.) calculate performance
public static void main(String[] args) 
{
	long startTime = System.currentTimeMillis();
	StringBuilder Result = Finder(sides);
	OutputFormatter(Result, startTime);
	PerfResult(startTime);
}

//The Finder method will use a nested while loop to test combinations of side A and B
//to find Pythagorean triples (where side C is an integer)
public static StringBuilder Finder(int length)
{
	// declare method variables.  we will need integer variables to hold values of each side
	int sideA;
	int sideB;
	double sideC;
	int cSquared;
	int i=1;
	int ii=1;
	StringBuilder buffer = new StringBuilder();
	int counter=0;

	while(i <= length) // the first while loop is used to test each value of side A
	{
		sideA = i;
		// The second nested while loop is used to test values of side B for each value of side A
		// note the condition in this 2nd while loop removes duplicate combinations
		// by only testing side lengths of B that are equal to or less than side A
		while(ii <= i) 
		{
			sideB = ii;
			cSquared = (sideA*sideA) + (sideB*sideB);  // determine value of C squared
			sideC = java.lang.Math.sqrt(cSquared);	// find the value of C
			if (sideC == Math.floor(sideC) )	//Checking if C is an integer!
			{	
				counter++;  // keep track of the count
				buffer = UpdateBuffer(sideA, sideB, sideC, buffer); // append the result set
			}
			ii++;	// increment for the loop used for SideB
	}
	ii=1;	// reset ii for the next loop iteration of i
	i++;	// increment for while loop used for SideA
}
count = counter; // update the Count variable so it can be used in the output
return buffer; // return the results
}

// The UpdateBuffer method adds each Pythagorean Triple to a buffer that will be output
public static StringBuilder UpdateBuffer(int a, int b, double c, StringBuilder s)
{
	s.append(a);
	s.append(", ");
	s.append(b);
	s.append(", ");
	s.append(java.lang.Math.round(c));
	s.append("\n");
	return s;
}

// The OutputFormatter outputs the results to the console
public static void OutputFormatter(StringBuilder output, long time)
{
	StringBuilder intro = new StringBuilder();
	intro.append("There are ");
	intro.append(count);
	intro.append(" Pythagorean Triples with side lengths up to ");
	intro.append(sides);
	intro.append(" units in length");
	intro.append("\n");
	StringBuilder screenOutput = intro.append(output);
	System.out.println(screenOutput);
}

// The PerfResult method calculates the total run time and outputs it to the screen
public static void PerfResult(long start)
{
	System.out.println("Total Run Time in milliseconds = ");
	long finishTime = System.currentTimeMillis();
	long elapsedTime = finishTime - start;
	System.out.println(elapsedTime);
}
}