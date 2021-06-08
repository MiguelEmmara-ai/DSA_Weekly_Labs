/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise6_1;

import java.util.Iterator;

public interface Path<E> {

    <E> Vertex<E> getEndVertex();
    // returns 

    <E> boolean containsEdge(Edge<E> incidentEdge);

    <E> void appendEnd(Edge<E> incidentEdge);

    <E> Vertex<E> getStartVertex();

    <E> Iterator<Edge<E>> iterator();
}