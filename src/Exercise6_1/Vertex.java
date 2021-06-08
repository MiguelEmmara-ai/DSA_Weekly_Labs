/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise6_1;

/**
 * An interface that represents a vertex in a graph which holds
 * elements of type E in its vertices
 *
 * @see GraphADT.java
 */

import java.util.Set;

public interface Vertex<E> {
    // returns the element held in the vertex
    E getUserObject();

    // sets the element held in the vertex
    void setUserObject(E element);

    // returns the edges connecting with this vertex as a Set
    Set<Edge<E>> incidentEdges();

    // returns the vertices that are adjacent to this vertex as a Set
    Set<Vertex<E>> adjacentVertices();

    // returns whether specified vertex is adjacent to this vertex
    boolean isAdjacent(Vertex<?> vertex);
}

    