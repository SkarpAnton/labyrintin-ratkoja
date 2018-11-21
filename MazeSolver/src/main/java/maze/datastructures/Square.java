package maze.datastructures;

public class Square {

    private int left;
    private int right;
    private int up;
    private int down;
    private int bfsPrevious = -1;
    private int aStarPrevious = -1;

    public void setBfsPrevious(int leveyshakuEdellinen) {
        this.bfsPrevious = leveyshakuEdellinen;
    }

    public int getBfsPrevious() {
        return bfsPrevious;
    }

    public int getAStarPrevious() {
        return aStarPrevious;
    }

    public void setAStarPrevious(int aStarPrevious) {
        this.aStarPrevious = aStarPrevious;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setUpper(int up) {
        this.up = up;
    }

    public void setLower(int down) {
        this.down = down;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getUpper() {
        return up;
    }

    public int getLower() {
        return down;
    }
}
