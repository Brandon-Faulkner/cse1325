import java.util.HashSet;
import java.util.Scanner;
import java.io.File;

public class ThreadsOfSudoku {
    public static void main(String[] args) {
        
        try {
            if(args.length < 2) {
                System.err.println("usage: java ThreadsOfSudoku threads puzzleFilename [puzzleName]");
                System.exit(-1);
            }
            
            Scanner in = new Scanner(new File(args[1]));
            String name = (args.length > 1) ? args[2] : null;
            Sudoku sud = new Sudoku(in, name);
            System.out.println(sud + "\n\n");
            
            int numThreads = Integer.parseInt(args[0]);
            
            // Split the search field into 81 different sub-puzzles
            int index = 0;
            for(int y=1; y<=9; ++y) {
                for(int x=1; x<=9; ++x) {
                    suds[index++] = new Sudoku(sud, new int[]{x, y});
                }
            }
            
            // WORK HERE
            // solveSuds accepts a range of the 81 Sudoku candidate solutions
            //   (in this case from 0 to suds.length-1 - that is, ALL of them!)
            //   with a "thread ID" hard-coded as 1.
            // Your job is to rewrite this to create numThreads threads, with
            //   the set of Sudoku candidate solutions split between them
            //   (for example, 0 to 40 for the first thread and 41-81 for the second).   
            Thread[] threads = new Thread[numThreads];
            int groupSize = suds.length / numThreads;
            int remainder = suds.length % numThreads;

            int startIndex = 0;
            for (int i = 0; i < numThreads; i++) {
                int endIndex = startIndex + groupSize - 1;

                if(remainder > 0) {
                    endIndex += 1;
                    remainder -= 1;
                }

                final int threadID = i;
                final int startFinal = startIndex, endFinal = endIndex;

                threads[i] = new Thread(() -> solveSuds(startFinal, endFinal, threadID));
                threads[i].start();
                startIndex = endIndex + 1;
            }

            for (int i = 0; i < numThreads; i++) {
                threads[i].join();                
            }

            // END WORK HERE
                        
            // Show the solution(s), if any
            System.out.println("Found " + solutions.size() + " solutions");
            for(var s : solutions) System.out.println(s);
        } catch(Exception e) {
            //System.err.println("ABORT: " + e);
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }
    
    // WORK HERE
    // Be sure to protect the solutions ArrayList from Thread Interference!
    private static void solveSuds(int first, int last, int id) {
        System.out.println("Thread " + id + " will solve " + first + " to " + last);
        for(int i=first; i<=last; ++i) {
            System.out.println("Thread " + id + " solving " + i);// + "\n\n" + suds[i]);
            synchronized(lock){
                if(suds[i].solve()) solutions.add(suds[i]);
            }       
        }
    }
    // END WORK HERE
    
    private static Object lock = new Object();
    private static Sudoku[] suds = new Sudoku[81];
    private static HashSet<Sudoku> solutions = new HashSet<>();
}
