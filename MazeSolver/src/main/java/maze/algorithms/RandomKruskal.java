package maze.algorithms;

import maze.datastructures.TypesOfSquares;
import maze.datastructures.Direction;
import maze.datastructures.Square;
import maze.datastructures.UnionFind;
import java.util.Random;

public class RandomKruskal {

    private static Square[] maze;
    private static int amountOfSquares;

    private RandomKruskal() {
    }

    ;
    
    public static Square[] createMaze(int widthOfMaze) {
        initialization(widthOfMaze);
        createSpanningTree();
        return maze;
    }

    private static void initialization(int widthOfMaze) {
        amountOfSquares = widthOfMaze * widthOfMaze;

        maze = new Square[amountOfSquares];
        for (int i = 0; i < amountOfSquares; i++) {
            maze[i] = new Square();

        }

        //sivut osoittaa viereisiin ruutuihin
        for (int i = 0; i < amountOfSquares; i++) {
            maze[i].setUpper(i - widthOfMaze);
            maze[i].setLower(i + widthOfMaze);
            maze[i].setRight(i + 1);
            maze[i].setLeft(i - 1);
        }
        //Seinien lisäys reunoille
        for (int i = 0; i < widthOfMaze; i++) {
            maze[i].setUpper(TypesOfSquares.getBORDER());
            maze[amountOfSquares - i - 1].setLower(TypesOfSquares.getBORDER());
            maze[i * widthOfMaze].setLeft(TypesOfSquares.getBORDER());
            maze[amountOfSquares - i * widthOfMaze - 1].setRight(TypesOfSquares.getBORDER());
        }

    }

    /*
    Kaikkien labyrintien siirtymien paino on sama, joten kaaria ei taritse järjestää 
    ja voidaan vain valita ruutuja satunnaisestti. Metodi näyttäisi olevan 
    tarpeeksi nopea käyttötarkoitukseen vaikka se valitsee ruudut satunnaisesti,
    sillä labyrintin, jonka sivun pituus on suurempi kuin 1000 alkaa olla hankala 
    kuvata. 
     */
    private static void createSpanningTree() {

        UnionFind tree = new UnionFind(amountOfSquares);
        Random rand = new Random();
        while (!tree.connectedTree()) {
            int randomSquare = rand.nextInt(amountOfSquares);
            int side = rand.nextInt(4);
            int nextSquare = Direction.getDirection(side, maze[randomSquare]);
            if (nextSquare != TypesOfSquares.getBORDER() &&
                    nextSquare != TypesOfSquares.getHALLWAY()) {
                if (tree.find(randomSquare) != tree.find(nextSquare)) {
                    Direction.setAsHallway(side, maze[randomSquare], maze[nextSquare]);
                    tree.union(tree.find(randomSquare), tree.find(nextSquare));
                }
            }
        }
    }
}
