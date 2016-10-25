package com.example;

public class Triple {
	
static int Sides = 100;
static int Count = 0;

public static void main(String[] args) {
	long startTime = System.currentTimeMillis();
	String Result = Finder(Sides);
	int returnCode = OutputFormatter(Result, startTime);
}

public static String Finder(int length)
{
int SideA;
int SideB;
double SideC;
int Csquared;
int i=1;
int ii=1;
String Buffer = "";
int Counter=0;

while(i < length)
{
	SideA = i;
	while(ii < length)
	{
			SideB = ii;
			Csquared = (SideA*SideA) + (SideB*SideB);
			SideC = java.lang.Math.sqrt(Csquared);
			if (SideC == Math.floor(SideC) )
			{	
				Counter = Counter++;
				Buffer = Buffer + SideA;
				Buffer = Buffer + ", ";
				Buffer = Buffer + SideB;
				Buffer = Buffer + ", ";
				Buffer = Buffer + java.lang.Math.round(SideC);
				Buffer = Buffer + " \n";
				
			}
			ii=ii+1;
	}
	ii=1;  //reset i for the next loop iteration of i
	i=i+1;   //increment for Side A
	
}
Count = Counter;
return Buffer;
}


public static int OutputFormatter(String Output, long time){
	
	String Intro ="";
	Intro = Intro + "There are ";
	Intro = Intro + Count;
	Intro = Intro + " Pythagorean Triples with side lengths up to ";
	Intro = Intro + Sides;
	Intro = Intro + " units in length" + "\n";
	String Screenoutput = Intro + Output;
	System.out.println(Screenoutput);
	long finishTime = System.currentTimeMillis();
	long elapsedTime = finishTime - time;
	System.out.println(elapsedTime);
	return 1;
}
}