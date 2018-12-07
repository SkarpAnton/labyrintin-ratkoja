package tests.performance;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import maze.algorithms.RandomKruskal;
import maze.algorithms.SearchAlgorithms;
import maze.datastructures.RandomStartAndDestination;
import maze.datastructures.Room;

public class TestAlgorithms {

    private static Room[] maze;
    private static int mazeWidth;
    private static int start;
    private static int destination;
    private static AlgorithmTimes times;
    private static AlgorithmTimes[] arrayofTimes;
    private static Writer writer;

    public static void runAndEvaluateAlgorithms() throws FileNotFoundException, IOException {
        writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("times.txt"), StandardCharsets.UTF_8));

        try {
            for (mazeWidth = 100; mazeWidth < 4000; mazeWidth += 100) {

                arrayofTimes = new AlgorithmTimes[10];
                System.out.println(mazeWidth);
                for (int j = 0; j < 10; j++) {
                    times = new AlgorithmTimes();
                    RandomStartAndDestination randomStartAndDestination
                            = new RandomStartAndDestination(mazeWidth);
                    start = randomStartAndDestination.getStart();
                    destination = randomStartAndDestination.getDestination();
                    timeRandomKruskal();
                    timeAStar();
                    timeBfs();
                    arrayofTimes[j] = times;
                }

                writeTimesToFile();
            }
        } catch (IOException e) {
        }
        writer.close();
    }

    private static void writeTimesToFile() throws IOException {

        int[] visited = visited();

        AlgorithmTimes averages = averageTimes();
        writer.write(averages.getBfsTime() + "");
        writer.write(",");
        writer.write(averages.getaStarTime() + "");
        writer.write(",");
        writer.write(averages.getKruskalTime() + "");
        writer.write(",");
        writer.write(visited[0] + "");
        writer.write(",");
        writer.write(visited[1] + "");
        writer.write(",");
        writer.write("" + mazeWidth * mazeWidth);
        writer.write(",");
        writer.write(getBigOnlogn() + "");
        writer.write(",");
        writer.write("" + getBigOn());
        writer.write(System.lineSeparator());
    }

    private static double getBigOnlogn() {
        int n = mazeWidth * mazeWidth;
        Random rand = new Random();
        int k = 0;
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            for (int j = n; j > 0; j /= 2) {
                k += rand.nextInt(2);
                //used to avoid java loop optimization
            }
        }
        long endTime = System.nanoTime();
        System.out.println(k);
        return (endTime - startTime) / 1000000000.0;
    }

    private static double getBigOn() {
        int n = mazeWidth * mazeWidth;
        Random rand = new Random();
        int k = 0;
        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            k += rand.nextInt(2);
            //used to avoid java loop optimization
        }

        long endTime = System.nanoTime();
        System.out.println(k);
        return (endTime - startTime) / 1000000000.0;

    }

    private static double getBigOnSquared() {
        int n = mazeWidth * mazeWidth;
        Random rand = new Random();
        int k = 0;
        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                k += rand.nextInt(2);
                //used to avoid java loop optimization
            }
        }

        long endTime = System.nanoTime();
        System.out.println(k);
        return (endTime - startTime) / 1000000000.0;

    }

    private static AlgorithmTimes averageTimes() {
        AlgorithmTimes averages = new AlgorithmTimes();
        double kruskal = 0;
        double bfs = 0;
        double aStar = 0;
        for (int i = 0; i < 10; i++) {
            kruskal += arrayofTimes[i].getKruskalTime();
            bfs += arrayofTimes[i].getBfsTime();
            aStar += arrayofTimes[i].getaStarTime();
        }
        averages.setBfsTime(bfs / 10);
        averages.setKruskalTime(kruskal / 10);
        averages.setaStarTime(aStar / 10);
        return averages;
    }

    private static void timeRandomKruskal() {
        long startTime = System.nanoTime();
        maze = RandomKruskal.createMaze(mazeWidth);
        long endTime = System.nanoTime();
        times.setKruskalTime((endTime - startTime) / 1000000000.0);
    }

    private static void timeAStar() {
        long startTime = System.nanoTime();
        SearchAlgorithms.aStar(start, destination, maze, mazeWidth);
        long endTime = System.nanoTime();
        times.setaStarTime((endTime - startTime) / 1000000000.0);

    }

    private static void timeBfs() {
        long startTime = System.nanoTime();
        SearchAlgorithms.breadthFirstSearch(start, destination, maze, mazeWidth);
        long endTime = System.nanoTime();
        times.setBfsTime((endTime - startTime) / 1000000000.0);
    }

    private static int[] visited() {
        int aStarVisited = 0;
        int bfsVisited = 0;
        for (int i = 0; i < maze.length; i++) {
            if (maze[i].getAStarPrevious() != -1) {
                aStarVisited++;
            }
            if (maze[i].getBfsPrevious() != -1) {
                bfsVisited++;
            }
        }
        return new int[]{bfsVisited, aStarVisited};
    }
}
