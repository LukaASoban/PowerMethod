POWER METHOD
-------------------------------------------------------------------------------------------

There are 4 main files, all you have to worry about is PowerMethodTester and ScatterPlotInverse

These are Command Line programs so you will first have to open up Terminal or Command Prompt if you're using Windows. Once you have this opened up, using the 'cd' statement, move to the current directory of where you extracted the zip file. For example:

	cd home/user/Desktop/Calc3Project/PowerMethod

		or if using Windows:

	cd user\Desktop\Calc3Project\PowerMethod


Now that you are in this current directory type:

	java -cp .:Jama-1.0.3.jar:jcommon-1.0.23.jar:jfreechart-1.0.19.jar ScatterPlotInverse

		or if you are using Windows type:

	java -cp .;Jama-1.0.3.jar;jcommon-1.0.23.jar;jfreechart-1.0.19.jar ScatterPlotInverse

This should run the program.

IMPORTANT:

		Now you can call the same line but change the ending to ScatterPlotInverse or
		PowerMethodTester depending on which program you want to run.



FOR PART A of this project it says to run power_method but we called this PowerMethodTester to take use of the Power.java file we have which is technically what our "power_method" is. THIS MEANS THAT YOU SHOULD ONLY RUN THE PowerMethodTester Program for Part A.

FOR PART B of this project, you should only run the Program called ScatterPlotInverse. It takes both the normal matrix A and the inverse of A and plots it onto two scatterplots for the user to view.
THE TWO SCATTERPLOTS WILL BE ON TOP OF EACH OTHER. THEY WILL ALSO BOTH CLOSE IF YOU PRESS THE X BUTTON
ON EITHER OF THE TWO.
----------------------------------------------------------------------------------------------


