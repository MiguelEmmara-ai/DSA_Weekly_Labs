/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise6_1;

/**
 * An interface that represents an undirected and unweighted edge
 * in a graph which holds elements of type E in its vertices
 *
 * @see GraphADT.java
 */

public interface Edge<E> {
    // returns the two end vertices (poss same) for this edge as array
    Vertex<E>[] endVertices();

    // returns the end vertex opposite the specified vertex
    Vertex<E> oppositeVertex(Vertex<E> vertex);
}
