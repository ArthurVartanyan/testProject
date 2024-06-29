package org.example.deepth;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private int maxN = 10;

    private int[][] matrix;

    private Vertex[] vertexList;

    private int curN;

    private Stack<Integer> stack = new Stack<>();

    private Queue<Integer> queue = new LinkedList<>();

    public Graph() {
        vertexList = new Vertex[maxN];
        matrix = new int[maxN][maxN];
        curN = 0;
    }

    public void addVertex(char name) {
        vertexList[curN++] = new Vertex(name);
    }

    public void addEdge(int start, int end, int val) {
        matrix[start][end] = 1;
        matrix[end][start] = val;
    }

    public int check(int v) {
        for (int i = 0; i < curN; i++) {
            if (matrix[v][i] == 1 && vertexList[i].isVisited() == false) {
                return i;
            }
        }
        return -1;
    }

    public void getByDeep(int index) {
        System.out.println(vertexList[index].getName());
        vertexList[index].setVisited(true);
        stack.push(index);

        while (!stack.empty()) {
            int neigh = check(stack.peek());

            if (neigh == -1) {
                neigh = stack.pop();
            } else {
                System.out.println(vertexList[neigh].getName());
                vertexList[neigh].setVisited(true);
                stack.push(neigh);
            }
        }

        for (int i = 0; i < curN; i++) {
            vertexList[i].setVisited(false);
        }
    }

    public void getByWidth(int index) {
        System.out.println(vertexList[index].getName());
        vertexList[index].setVisited(true);
        queue.add(index);

        int vertex;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            while ((vertex = check(temp)) != -1) {
                System.out.println(vertexList[vertex].getName());
                vertexList[vertex].setVisited(true);
                queue.add(vertex);
            }
        }

        for (int i = 0; i < curN; i++) {
            vertexList[i].setVisited(false);
        }
    }
}
