
//CS344 Ramit Sharma rks142 and Brian Angioletti bta14
//Section 3 Assignment 1
import java.text.*;
public class AIDriver
{
    public static void main(String[] args)
    {
        int[][] puzzleBoard = generatePuzzle(5);
        System.out.println("Puzzle");
        print2DArray(puzzleBoard);
        System.out.println();

        print2DArray(calculateComplexityArray(puzzleBoard));
        System.out.println();

        int[][] complexityPuzzle = calculateComplexityArray(puzzleBoard);
        System.out.println("Value Function: " + calculateValueFromComplexityArray(complexityPuzzle));
        System.out.println();

        String shortestPath = shortestPathFirst(puzzleBoard);
        System.out.println(shortestPath);
        System.out.println();

        System.out.println("Heuristic Table");
        print2DArray(getHeuristicTable(puzzleBoard));
        System.out.println();

        System.out.println("A* Search");
        String path = aStarSearch(puzzleBoard);
        System.out.println(path);
        System.out.println();

        System.out.println("Population Based Approach");
        puzzleBoard = populationBasedApproach(puzzleBoard, 100, 25);
        print2DArray(puzzleBoard);
        System.out.println();

        //CODE FOR TASK 4 USED TO GET TEST DATA
		/*double total = 0;

		for(int x = 0; x < 100; x++)
		{
		puzzleBoard = generatePuzzle(11);
		long start = System.nanoTime();
		puzzleBoard = hillClimbing(puzzleBoard, 1000);
		long end = System.nanoTime();
		total = total + (end - start);
		}
		total = total/100;
		DecimalFormat df = new DecimalFormat("#.###");
		System.out.println("Average runtime: " + df.format(total/1000000) + " milliseconds");
		System.out.println();
		print2DArray(calculateComplexityArray(puzzleBoard));
		*/


        //	String shortestPath = shortestPathFirst(puzzleBoard);
        //	System.out.println(shortestPath);
        //	System.out.println();

        //	print2DArray(getHeuristicTable(puzzleBoard));
        //	System.out.println();

        //	String path = aStarSearch(puzzleBoard);
        //	System.out.println(path);
        //	System.out.println();

        //puzzleBoard = populationBasedSearch(puzzleBoard);
        //print2DArray(puzzleBoard);
        //System.out.println();


		/*TEST Between Search Methods
		long startTime, endTime;
		double averageTime;

		int size = 11;
		int[][][] boardsToSearch = new int[50][size][size];
		String[] searchResults = new String[50];
		for(int i = 0; i < 50; i ++)
		{
			boardsToSearch[i] = generatePuzzle(size);
			boardsToSearch[i] = hillClimbing(boardsToSearch[i], 1000);
		}

		startTime = System.nanoTime();
		for(int i = 0; i < 50; i ++)
		{
			searchResults[i] = shortestPathFirst(boardsToSearch[i]);
		}
		endTime = System.nanoTime();

		averageTime = (((double)(endTime - startTime))/50);
		System.out.println("Average time for shortest path of a " + size + " x " + size + ": " + (averageTime/1000000) + " milliseconds");

		size = 9;
		boardsToSearch = new int[50][size][size];
		searchResults = new String[50];
		for(int i = 0; i < 50; i ++)
		{
			boardsToSearch[i] = generatePuzzle(size);
			boardsToSearch[i] = hillClimbing(boardsToSearch[i], 1000);
		}

		startTime = System.nanoTime();
		for(int i = 0; i < 50; i ++)
		{
			searchResults[i] = shortestPathFirst(boardsToSearch[i]);
		}
		endTime = System.nanoTime();
		averageTime = (((double)(endTime - startTime))/50);
		System.out.println("Average time for shortest path of a " + size + " x " + size + ": " + (averageTime/1000000) + " milliseconds");

		size = 7;
		boardsToSearch = new int[50][size][size];
		searchResults = new String[50];
		for(int i = 0; i < 50; i ++)
		{
			boardsToSearch[i] = generatePuzzle(size);
			boardsToSearch[i] = hillClimbing(boardsToSearch[i], 1000);
		}

		startTime = System.nanoTime();
		for(int i = 0; i < 50; i ++)
		{
			searchResults[i] = shortestPathFirst(boardsToSearch[i]);
		}
		endTime = System.nanoTime();
		averageTime = (((double)(endTime - startTime))/50);
		System.out.println("Average time for shortest path of a " + size + " x " + size + ": " + (averageTime/1000000) + " milliseconds");

		size = 5;
		boardsToSearch = new int[50][size][size];
		searchResults = new String[50];
		for(int i = 0; i < 50; i ++)
		{
			boardsToSearch[i] = generatePuzzle(size);
			boardsToSearch[i] = hillClimbing(boardsToSearch[i], 1000);
		}

		startTime = System.nanoTime();
		for(int i = 0; i < 50; i ++)
		{
			searchResults[i] = shortestPathFirst(boardsToSearch[i]);
		}
		endTime = System.nanoTime();
		averageTime = (((double)(endTime - startTime))/50);
		System.out.println("Average time for shortest path of a " + size + " x " + size + ": " + (averageTime/1000000) + " milliseconds");
		*/


		/* Test between Puzzle modifiers(hill and population)
		long startTime, endTime;
		double averageTime;

		int size = 11;
		int[][][] boardsToSearch = new int[50][size][size];
		String[] searchResults = new String[50];
		for(int i = 0; i < 50; i ++)
		{
			boardsToSearch[i] = generatePuzzle(size);
			boardsToSearch[i] = hillClimbing(boardsToSearch[i], 1000);
		}

		startTime = System.nanoTime();
		for(int i = 0; i < 50; i ++)
		{
			searchResults[i] = aStarSearch(boardsToSearch[i]);
		}
		endTime = System.nanoTime();

		averageTime = (((double)(endTime - startTime))/50);
		System.out.println("Average time for shortest path of a " + size + " x " + size + ": " + (averageTime/1000000) + " milliseconds");

		size = 9;
		boardsToSearch = new int[50][size][size];
		searchResults = new String[50];
		for(int i = 0; i < 50; i ++)
		{
			boardsToSearch[i] = generatePuzzle(size);
			boardsToSearch[i] = hillClimbing(boardsToSearch[i], 1000);
		}

		startTime = System.nanoTime();
		for(int i = 0; i < 50; i ++)
		{
			searchResults[i] = aStarSearch(boardsToSearch[i]);
		}
		endTime = System.nanoTime();
		averageTime = (((double)(endTime - startTime))/50);
		System.out.println("Average time for shortest path of a " + size + " x " + size + ": " + (averageTime/1000000) + " milliseconds");

		size = 7;
		boardsToSearch = new int[50][size][size];
		searchResults = new String[50];
		for(int i = 0; i < 50; i ++)
		{
			boardsToSearch[i] = generatePuzzle(size);
			boardsToSearch[i] = hillClimbing(boardsToSearch[i], 1000);
		}

		startTime = System.nanoTime();
		for(int i = 0; i < 50; i ++)
		{
			searchResults[i] = aStarSearch(boardsToSearch[i]);
		}
		endTime = System.nanoTime();
		averageTime = (((double)(endTime - startTime))/50);
		System.out.println("Average time for shortest path of a " + size + " x " + size + ": " + (averageTime/1000000) + " milliseconds");

		size = 5;
		boardsToSearch = new int[50][size][size];
		searchResults = new String[50];
		for(int i = 0; i < 50; i ++)
		{
			boardsToSearch[i] = generatePuzzle(size);
			boardsToSearch[i] = hillClimbing(boardsToSearch[i], 1000);
		}

		startTime = System.nanoTime();
		for(int i = 0; i < 50; i ++)
		{
			searchResults[i] = aStarSearch(boardsToSearch[i]);
		}
		endTime = System.nanoTime();
		averageTime = (((double)(endTime - startTime))/50);
		System.out.println("Average time for shortest path of a " + size + " x " + size + ": " + (averageTime/1000000) + " milliseconds");
		*/

        int size = 5;
        double complexity = 0;
        int[][][] boardsToBuild = new int[50][size][size];
        int[][][] buildResults = new int[50][size][size];
        for(int i = 0; i < 50; i ++)
        {
            boardsToBuild[i] = generatePuzzle(size);
        }

        long startTime = System.nanoTime();
        for(int i = 0; i < 50; i ++)
        {
            buildResults[i] = hillClimbing(boardsToBuild[i], 4500);
        }
        long endTime = System.nanoTime();
        double averageTime = (((double)(endTime - startTime))/50);
        for(int i = 0; i < 50; i++)
        {
            complexity += calculateValueFromComplexityArray(calculateComplexityArray(buildResults[i]));
        }
        complexity = complexity / 50;
        System.out.println("Time to hill climb a " + size + " x " + size + ": " + (averageTime/1000000) + " milliseconds, average complexity: " + complexity);

        size = 5;
        boardsToBuild = new int[50][size][size];
        buildResults = new int[50][size][size];
        for(int i = 0; i < 50; i ++)
        {
            boardsToBuild[i] = generatePuzzle(size);
        }

        startTime = System.nanoTime();
        for(int i = 0; i < 50; i ++)
        {
            buildResults[i] = populationBasedApproach(boardsToBuild[i], 35, 30);
        }
        endTime = System.nanoTime();
        averageTime = (((double)(endTime - startTime))/50);
        for(int i = 0; i < 50; i++)
        {
            complexity += calculateValueFromComplexityArray(calculateComplexityArray(buildResults[i]));
        }
        complexity = complexity / 50;
        System.out.println("Time to population approach a " + size + " x " + size + ": " + (averageTime/1000000) + " milliseconds, average complexity: " + complexity);
    }




    //start of functions

    //generatePuzzle returns a 2D, nxn array filled with values that represent valid moves from that square
    //a valid move is one that does not extend off of the board
    public static int[][] generatePuzzle(int n)
    {
        int puzzle[][] = new int[n][n];
        int maxVal;							//max value that can exist in a square

        for (int row = 0; row < n; row ++)
        {
            for (int col = 0; col < n; col ++)
            {
                maxVal = Math.max(Math.max((n - 1) - row, row), Math.max((n - 1) - col, col));		//biggest distance from any of the sides of the puzzle board

                puzzle[row][col] = (int)((Math.random() * maxVal) + 1);
            }
        }

        puzzle[n - 1][n - 1] = 0;		//Goal of the puzzle
        return puzzle;
    }

    //takes a 2D array as input and returns an array that shows how many moves it takes to get to each square
    //the value at arr[n-1][n-1] represents the difficulty of the puzzle
    public static int[][] calculateComplexityArray(int[][] arr)
    {
        //Example:
        //Input
        //1 2 2 2
        //3 2 1 1
        //3 2 2 1
        //1 1 3 0
        //
        //   |
        //   V
        //
        //Output
        //0 1 4 2
        //1 4 3 2
        //5 2 4 3
        //6 5 6 4


        //cArray represents complexity at any square
        //starts filled with -1's until a path to the square can be found
        //-1 represents no possible paths
        int numRows = arr.length;
        int numCols = arr[0].length;
        int[][] cArray = new int[numRows][numCols];
        for(int row = 0; row < numRows; row ++)
            for(int col = 0; col < numCols; col++)
                cArray[row][col] = -1;
        cArray[0][0] = 0;


        boolean moreMoves = true;
        int complexity = 1;
        int squareValue;


        //while loop goes through whole complexity array,
        //if a value of (complexity - 1) is found in the complexity array,
        //moves are calculated from that index
        //     -(comlpexity - 1) represents a square found the previous iteration.
        //if a square that has not been traversed to before is found,
        //that square has to be expanded to find more possible action sequences.
        //Otherwise, the loop ends as no more squares can be expanded upon
        while(moreMoves)
        {
            moreMoves = false;
            for(int row = 0; row < numRows; row ++)
                for(int col = 0; col < numCols; col++)
                {
                    if(cArray[row][col] == (complexity - 1))
                    {
                        squareValue = arr[row][col];
                        if(row + squareValue < numRows)//check for in bounds after going down
                        {
                            if(cArray[row + squareValue][col] == -1)//check if square has been traversed before
                            {
                                cArray[row + squareValue][col] = complexity;
                                moreMoves = true;
                            }
                        }
                        if(row - squareValue >= 0)//check for in bounds after going up
                        {
                            if(cArray[row - squareValue][col] == -1)//check if square has been traversed before
                            {
                                cArray[row - squareValue][col] = complexity;
                                moreMoves = true;
                            }
                        }
                        if(col + squareValue < numCols)//check for in bounds after going right
                        {
                            if(cArray[row][col + squareValue] == -1)//check if square has been traversed before
                            {
                                cArray[row][col + squareValue] = complexity;
                                moreMoves = true;
                            }
                        }
                        if(col - squareValue >= 0)//check for in bounds after going left
                        {
                            if(cArray[row][col - squareValue] == -1)//check if square has been traversed before
                            {
                                cArray[row][col - squareValue] = complexity;
                                moreMoves = true;
                            }
                        }
                    }
                }
            complexity ++;
        }


        return cArray;
    }

    //calculates the Value of the puzzle.
    //If puzzle is solvable, returns the distance of the shortest path to the goal.
    //Otherwise, returns -K, where K is the number of unreachable tiles
    public static int calculateValueFromComplexityArray(int[][] cArr)
    {
        int numRows = cArr.length;
        int numCols = cArr[0].length;
        if(cArr[numRows - 1][numCols -1] != -1)//puzzle is solveable
            return cArr[numRows - 1][numCols - 1];
        else
        {
            int value = 0;
            for(int row = 0; row < numRows; row ++)
                for(int col = 0; col < numCols; col ++)
                    if(cArr[row][col] == -1)
                        value --;
            return value;
        }
    }

    //With each iteration, changes a square to be another legal value and sees if the complexity has increased.
    //if complexity decreases, the change is reverted
    public static int[][] hillClimbing(int[][] arr, int numIterations)
    {
        int[][] climbedArray = arr; //starts with the original array
        int numRows = arr.length;
        int numCols = arr[0].length;

        //index of square to be changed
        int rowIndex;
        int colIndex;

        int maxVal;			//highest possible value a specific square can have
        int oldVal;			//value in square before change
        int newVal;			//value in square after change
        int oldComplexity;	//complexity before change
        int newComplexity;	//complexity after change

        while(numIterations > 0)
        {
            rowIndex = (int) (Math.random() * numRows);
            colIndex = (int) (Math.random() * numCols);

            if(rowIndex == (numRows - 1) && colIndex == (numCols -1))//checks to see if trying to change the value of the goal square
                continue;

            maxVal = Math.max(Math.max((numRows - 1) - rowIndex, rowIndex), Math.max((numCols - 1) - colIndex, colIndex));		//biggest distance from any of the sides of the puzzle board
            oldVal = climbedArray[rowIndex][colIndex];
            newVal = (int)((Math.random() * maxVal) + 1);

            oldComplexity = calculateValueFromComplexityArray(calculateComplexityArray(climbedArray));
            climbedArray[rowIndex][colIndex] = newVal; //sets the square to another random possible value (can be the same value)
            newComplexity = calculateValueFromComplexityArray(calculateComplexityArray(climbedArray));


            //check if the change made the puzzle worse, if so, revert the change
            if(newComplexity < oldComplexity)
            {
                climbedArray[rowIndex][colIndex] = oldVal;
            }

            numIterations --;
        }

        return climbedArray;
    }


    //returns a String array that represents the shortest path to the goad
    //'u' = up
    //'d' = down
    //'l' = left
    //'r' = right
    //since the board can be viewed as an unweighted graph, all actions(moves) have the weight of one
    //this means that SPF acts the same as BFS
    public static String shortestPathFirst(int[][] arr)
    {
        int numRows = arr.length;
        int numCols = arr[0].length;
        String path = "";

        boolean[][] visitedSpaces = new boolean[numRows][numCols];	//each row represents a visited square of the puzzle
        //first column is the row of the visited square
        //second column is the column of the visited square
        for(int r = 0; r < numRows; r++)
        {
            for(int c = 0; c < numCols; c++)
            {
                visitedSpaces[r][c] = false;
            }
        }

        Queue queue = new Queue();
        Node square;
        int row, col;
        queue.enqueue(0, 0, ""); //path is empty at start
        while(!queue.isEmpty())
        {
            square = queue.dequeue();
            row = square.row;
            col = square.col;
            path = square.path;

            if((row == numRows - 1) && (col == numCols - 1))
            {
                return path;//path to goal is found
            }
            if(!visitedSpaces[row][col])
            {
                visitedSpaces[row][col] = true;//sets the square to visited

                //queues up possible moves
                if(row + arr[row][col] <= numRows - 1)//down
                    queue.enqueue(row + arr[row][col], col, (path + 'd'));
                if(row - arr[row][col] >= 0)//up
                    queue.enqueue(row - arr[row][col], col, (path + 'u'));
                if(col + arr[row][col] <= numCols - 1)//right
                    queue.enqueue(row, col + arr[row][col], (path + 'r'));
                if(col - arr[row][col] >= 0)//left
                    queue.enqueue(row, col - arr[row][col], (path + 'l'));
            }
        }

        return "Unsolvable";
    }

    //A* search
    public static String aStarSearch(int[][] arr)
    {
        int numRows = arr.length;
        int numCols = arr[0].length;
        int currentRow = 0;
        int currentCol = 0;
        int minH = 0;
        String path = "";
        int[] hCompare = new int[4];
        int[][] heuristicTable = getHeuristicTable(arr);
        boolean valNotFound = true;

        while(valNotFound)
        {
            int currentSquare = arr[currentRow][currentCol];
            if(currentRow + currentSquare <= numRows - 1)//check for in bounds after going down
            {
                hCompare[0] = heuristicTable[currentRow + currentSquare][currentCol];
            }
            else
                hCompare[0] = 100000;
            if(currentRow - currentSquare >= 0)//check for in bounds after going up
            {
                hCompare[1] = heuristicTable[currentRow - currentSquare][currentCol];
            }
            else
                hCompare[1] = 100000;
            if(currentCol + currentSquare <= numCols - 1)//check for in bounds after going right
            {
                hCompare[2] = heuristicTable[currentRow][currentCol + currentSquare];
            }
            else
                hCompare[2] = 100000;
            if(currentCol - currentSquare >= 0)//check for in bounds after going left
            {
                hCompare[3] = heuristicTable[currentRow][currentCol - currentSquare];
            }
            else
                hCompare[3] = 100000;

            minH = hCompare[0];

            for(int x = 1; x < 4; x++)		//finds which direction gives max heuristic
            {
                if(hCompare[x] < minH)
                {
                    minH = hCompare[x];
                }
            }

            if(minH == 100000)	//if unsolvable will break out of loop
            {
                return "Unsolvable";
            }

            if(minH == hCompare[0] && (currentRow + currentSquare <= (numRows - 1)))
            {
                currentRow = currentRow + currentSquare;
                path = path + "d";
            }
            else if(minH == hCompare[1] && (currentRow - currentSquare) >= 0)
            {
                currentRow = currentRow - currentSquare;
                path = path + "u";
            }
            else if(minH == hCompare[2] && (currentCol + currentSquare <= (numCols - 1)))
            {
                currentCol = currentCol + currentSquare;
                path = path + "r";
            }
            else if(minH == hCompare[3] && (currentCol - currentSquare) >= 0)
            {
                currentCol = currentCol - currentSquare;
                path = path + "l";
            }
            else
            {
                return "No Legal Move";
            }

            if(minH == 0)
            {
                valNotFound = false;
                return path;
            }

        }

        return "";
    }

    public static int[][] getHeuristicTable(int[][] arr)
    {
        int numRows = arr.length;
        int numCols = arr[0].length;
        int[][] heuristicArray = new int[numRows][numCols];
        int r, c;
        int depth = 1;
        boolean pathNotFound = true;

        for(r = 0; r < numRows; r++)	// sets default values of each spot in the heuristic table to 100000
        {
            for(c = 0; c < numCols; c++)
            {
                heuristicArray[r][c] = 100000;
            }
        }

        heuristicArray[numRows - 1][numCols - 1] = 0;		//set goal to 0

        while(pathNotFound)
        {
            for(r = 0; r < numRows; r++)
            {
                for(c = 0; c < numCols; c++)
                {
                    if(heuristicArray[r][c] == (depth - 1))
                    {
                        for(int x = 0; x < numRows; x++)
                        {
                            if(arr[x][c] == (Math.abs(x - r)) && heuristicArray[x][c] > depth)
                            {
                                heuristicArray[x][c] = depth;
                            }
                        }

                        for(int y = 0; y < numCols; y++)
                        {
                            if(arr[r][y] == (Math.abs(y - c)) && heuristicArray[r][y] > depth)
                            {
                                heuristicArray[r][y] = depth;
                            }
                        }
                    }
                }
            }

            if(heuristicArray[0][0] != 100000)
            {
                pathNotFound = false;
            }
            depth++;
            if(depth == numRows * numCols)
                break;
        }


        return heuristicArray;
    }

    //population based approach
    public static int[][] populationBasedApproach(int[][] arr, int numGenerations, int populationSize)
    {
        int numRows = arr.length;
        int numCols = arr[0].length;
        int[][][] population = new int[populationSize][numRows][numCols];
        int[][][] offspring;

        population[0] = arr;
        for(int i = 1; i < populationSize; i++)//initially fills the population with random boards
        {
            population[i] = generatePuzzle(numRows);
        }

        while(numGenerations > 0)
        {
            //gets the results from the crossovers
            offspring = crossoverWithMutations(population);
            offspring = sortPopulation(offspring);

            population = cull(offspring);//takes the first third
            numGenerations --;
            //print2DArray(population[0]);
            //System.out.println();
        }


        return population[0];
    }

    //returns the first third of a 3d array
    public static int[][][] cull(int[][][] popArr)
    {
        int popSize = popArr.length;
        int numRows = popArr[0].length;
        int numCols = popArr[0][0].length;
        int [][][] resultArray = new int[popSize / 3][numRows][numCols];

        for(int i = 0; i < popSize / 3; i++)
        {
            resultArray[i] = popArr[i];
        }

        return resultArray;
    }

    //returns the offspring from a generation
    //there are 3 times as many offspring as the origional population
    public static int[][][] crossoverWithMutations(int[][][] popArr)
    {
        int popSize = popArr.length;
        int numRows = popArr[0].length;
        int numCols = popArr[0][0].length;
        int [][][] offspring = new int[popSize * 3][numRows][numCols];

        offspring[0] = popArr[0];//keeps the best one from the last generation so value doesnt ever get worse
        for(int i = 1; i < popSize * 3; i++)
        {
            //randomly selects 2 puzzle boards to cross
            int[][][] inputPuzzles = new int[2][numRows][numCols];
            inputPuzzles[0] = popArr[((int)Math.random()*popSize)];
            inputPuzzles[1] = popArr[((int)Math.random()*popSize)];

            for(int row = 0; row < numRows; row++)
            {
                for(int col = 0; col < numCols; col++)
                {
                    if(((int) (Math.random() * 10)) == 0)//10% chance for a mutation
                    {
                        offspring[i][row][col] = ((int) (Math.random() * Math.max(Math.max(row, col), Math.max(numRows - (row + 1), numCols - (col + 1))))) + 1;
                        continue;
                    }
                    //takes a value from a random board
                    offspring[i][row][col] = inputPuzzles[((int)Math.random()*2)][row][col];
                }
            }
        }

        return offspring;
    }

    //returns a 3d array with the first 1/3 elements sorted (the last 2/3 should be culled)
    public static int[][][] sortPopulation(int[][][] popArr)
    {
        int popSize = popArr.length;
        int numRows = popArr[0].length;
        int numCols = popArr[0][0].length;

        int[][][] resultArray = new int[popSize][numRows][numCols];
        int[] arrValues = new int[popSize];

        for(int i = 0; i < (popSize / 3); i++)//only has to be the first 1/3 as the rest is culled
        {
            arrValues[i] = calculateValueFromComplexityArray(calculateComplexityArray(popArr[i]));
        }

        arrValues = sortDescByIndex(arrValues);
        for(int i = 0; i < popSize; i ++)
        {
            resultArray[i] = popArr[arrValues[i]];
        }

        return resultArray;
    }

    public static int[] sortDescByIndex(int[] arr)
    {
        int max;
        int maxIndex;
        int[] sortedArray = new int[arr.length];
        for(int i = 0; i < arr.length; i ++)
        {
            max = -99999;
            maxIndex = 0;
            for(int j = 0; j < arr.length; j ++)//finds largest value of remaining array
                if(arr[j] >= max)
                {
                    max = arr[j];
                    maxIndex = j;
                }
            //System.out.println(maxIndex);

            sortedArray[i] = maxIndex;
            arr[maxIndex] = -99999;//makes it so will not be max for next iteration
        }

        return sortedArray;
    }

    //prints a 2D array to the console
    public static void print2DArray(int[][] arr)
    {
        int numRows = arr.length;
        int numCols = arr[0].length;
        for(int row = 0; row < numRows; row ++)
        {
            for(int col = 0; col < numCols; col ++)
            {
                if(arr[row][col] < 0)
                    System.out.print("X\t");
                else
                    System.out.print(arr[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
