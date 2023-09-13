/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return constructQuadTree(grid,0,0,grid.length);
    }

    private Node constructQuadTree(int [][]grid, int startRow,int startCol, int length){
        if(length == 1) return new Node(grid[startRow][startCol]==1,true);

        Node topLeft = constructQuadTree(grid,startRow,startCol,length/2);
        Node topRight = constructQuadTree(grid,startRow,startCol+length/2,length/2);
        Node bottomRight =constructQuadTree(grid,startRow+length/2,startCol+length/2,length/2);
        Node bottomLeft =constructQuadTree(grid,startRow+length/2,startCol,length/2);

        if(topLeft.isLeaf && topRight.isLeaf && bottomRight.isLeaf && bottomLeft.isLeaf && 
            topLeft.val == topRight.val && topRight.val == bottomRight.val && bottomRight.val == bottomLeft.val){
                return new Node(topLeft.val,true);
            }

        return new Node(true,false,topLeft,topRight,bottomLeft,bottomRight);

    }

}