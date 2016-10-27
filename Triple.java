package com.example;

public class Triple {
	
static int sides = 100;
static int count = 0;

//The main program will trap the start time, find the triples, and format the output
public static void main(String[] args) 
{
	long startTime = System.currentTimeMillis();
	StringBuilder Result = Finder(sides);
	int returnCode = OutputFormatter(Result, startTime);
}

public static StringBuilder Finder(int length)
{
	// declare method variables.  we will need integer variables to hold values of each side
	int sideA;
	int sideB;
	double sideC;
	int cSquared;
	int i=1;
	int ii=1;
	String initial="";
	StringBuilder buffer = new StringBuilder();
	int counter=0;

	while(i <= length)
	{
		sideA = i;
		while(ii <= i) // note the condition in the while loop removes duplicate combinations
		{
			sideB = ii;
			cSquared = (sideA*sideA) + (sideB*sideB);  // determine value of C squared
			sideC = java.lang.Math.sqrt(cSquared);	// find the square root
			if (sideC == Math.floor(sideC) )	//Checking if C is an integer!
			{	
				counter++;
				buffer.append(sideA);
				buffer.append(", ");
				buffer.append(sideB);
				buffer.append(", ");
				buffer.append(java.lang.Math.round(sideC));
				buffer.append("\n");
				
			}
			ii=ii+1;	// increment for the loop used for SideB
	}
	ii=1;	//reset ii for the next loop iteration of i
	i=i+1;	//increment for while loop used for SideA
}
count = counter; // update the Count variable so it can be used in the output
return buffer; // return the results
}

public static int OutputFormatter(StringBuilder output, long time)
{
	String intro ="";
	intro = intro + "There are ";
	intro = intro + count;
	intro = intro + " Pythagorean Triples with side lengths up to ";
	intro = intro + sides;
	intro = intro + " units in length" + "\n";
	String screenOutput = intro + output;
	System.out.println(screenOutput);
	System.out.println("Total Run Time in milliseconds = ");
	long finishTime = System.currentTimeMillis();
	long elapsedTime = finishTime - time;
	System.out.println(elapsedTime);
	return 1;
}
}