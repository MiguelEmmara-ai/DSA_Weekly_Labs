/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exercise6_1;

/**
 * An interface that defines the abstract data type for an undirected
 * graph whose vertices hold elements of type E
 */

import java.util.Set;

public interface GraphADT<E> {

    // removes all vertices and edges from the graph
    void clear();

    // returns true if the graph has no vertices nor edges
    boolean isEmpty();

    // returns a view of the vertices as a Set
    Set<Vertex<E>> vertexSet();

    // returns a view of the edges as a Set
    Set<Edge<E>> edgeSet();

    // method which adds the graph as a subgraph into this graph
    <F extends E> void addGraph(GraphADT<F> graph);

    // adds and returns a new isolated vertex to the graph
    Vertex<E> addVertex(E element);

    // adds and returns a new undirected edge between two vertices
    Edge<E> addEdge(Vertex<E> vertex0, Vertex<E> vertex1);

    // removes the specified vertex from the graph
    <F> boolean removeVertex(Vertex<F> vertex);

    // removes the specified undirected edge from the graph
    <F> boolean removeEdge(Edge<F> edge);

    // returns whether the specified vertex is in the graph
    boolean containsVertex(Vertex<?> vertex);

    // returns whether the specified edge is in the graph
    boolean containsEdge(Edge<?> edge);
}
