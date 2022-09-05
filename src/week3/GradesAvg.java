package week3;


public class GradesAvg {
	public  static  void  main(String[]  args) {
	    final  int  NUM_CLASSES=3, STUDENTS_IN_CLASS=5;
		int [][] grades = new  int[NUM_CLASSES][STUDENTS_IN_CLASS];
		float[]  average = new float[grades.length];

		System.out.println("Please enter grades for students in " + grades.length + " classes:");
		for (int  i=0 ; i < grades.length ; i++)
		{
			System.out.println("Please enter grades for " + grades[i].length + " students in class #" + (i+1));
			int  sum=0;
	        for (int  j=0 ; j < grades[i].length ; j++)
	        {
	        	grades[i][j] = MyConsole.readInt("");
			    sum += grades[i][j];
			}
			average[i] = (float)sum/grades[i].length;
		}

		System.out.println("The average for each class:");
		for (int  i=0 ; i < average.length ; i++)
			System.out.println("Average for class #" + (i+1) + ": " + average[i]);
	}
}
