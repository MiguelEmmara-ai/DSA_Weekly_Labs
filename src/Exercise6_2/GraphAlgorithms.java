package Exercise6_2;

import Exercise6_1.Edge;
import Exercise6_1.GraphADT;
import Exercise6_1.Path;
import Exercise6_1.Vertex;
import chapter3.LinkedQueue;
import chapter3.QueueADT;

import java.util.*;

public class GraphAlgorithms {
    // performs a breadth-first search of the specified graph starting
    // at the given vertex
    public static <E> List<Vertex<E>> breadthFirstSearch
    (GraphADT<E> graph, Vertex<E> startVertex) {
        if (!graph.containsVertex(startVertex))
            throw new IllegalArgumentException();
        // create list to hold vertices as they are encountered
        List<Vertex<E>> visitedVertices = new LinkedList<Vertex<E>>();
        //create queue to keep track of vertices not yet fully processed
        QueueADT<Vertex<E>> processingQueue
                = new LinkedQueue<Vertex<E>>();
        // handle the starting vertex
        visitedVertices.add(startVertex);
        processingQueue.enqueue(startVertex);
        // repeatedly find adjacent vertices and visit them
        while (!processingQueue.isEmpty()) {  //remove front element
            Vertex<E> frontVertex = processingQueue.dequeue();
            // find all the adjacent vertices that have not been visited
            // and enqueue them
            Iterator<Vertex<E>> iterator
                    = frontVertex.adjacentVertices().iterator();
            while (iterator.hasNext()) {
                Vertex<E> adjacentVertex = iterator.next();
                if (!visitedVertices.contains(adjacentVertex)) {
                    visitedVertices.add(adjacentVertex);
                    processingQueue.enqueue(adjacentVertex);
                }
            }
        }
        return visitedVertices;
    }

    // performs a depth-first search of the specified graph starting
    // at the given vertex
    public static <E> Set<Vertex<E>> performRecursion(GraphADT<E> graph, Vertex<E> start) {
        if (graph.containsVertex(start)) throw new IllegalArgumentException("Starting vertex is not in graph");
        Set<Vertex<E>> visitedVertices = new LinkedHashSet<Vertex<E>>();
        //
        recursiveDepthFirstSearch(visitedVertices, start);
        return visitedVertices;
    }

    //Use set of visited vertices instead of graph for recurson
    public static <E> void recursiveDepthFirstSearch(Set<Vertex<E>> visited, Vertex<E> current) {
        visited.add(current);

        Set<Vertex<E>> neighbours = current.adjacentVertices();

        for (Vertex<E> neighbour : neighbours) {
            if (visited.contains(neighbour)) {
                recursiveDepthFirstSearch(visited, neighbour);
            }
        }
    }

    // obtains all possible paths in graph that start at startVertex
    // returns a map which for any vertex in the graph gives the set of
    // paths that started at startVertex and ended at that vertex
    public static <E> Map<Vertex<E>, Set<Path<E>>> allPaths(Vertex<E> startVertex) {  // create a map from vertices in the graph to all the paths
        // found so far that start at startVertex and end at that vertex
        Map<Vertex<E>, Set<Path<E>>> paths = new HashMap<Vertex<E>, Set<Path<E>>>();
        // initially there is just one path startVertex (length 0)
        Path<E> initialPath = new LinkedPath<E>(startVertex);
        // start extending initial path adding it to paths as extended
        extendPath(paths, initialPath);
        return paths;
    }

    // recursive helper method which first adds a path to the map paths
    // and then tries to extend a copy of the path by one further edge
    // This method presumes that the paths are all distinct
    private static <E> void extendPath
    (Map<Vertex<E>, Set<Path<E>>> paths, Path<E> path) {
        Vertex<E> pathEnd = path.getEndVertex();
        // add path to the map paths using path end as the map key
        Set<Path<E>> pathsEndingHere = paths.get(pathEnd);
        if (pathsEndingHere == null) // this is the first path ending here
        {  // create a new set of paths for the vertex
            pathsEndingHere = new HashSet<Path<E>>();
            paths.put(pathEnd, pathsEndingHere);
        }
        pathsEndingHere.add(path);
        // get all the edges that are incident with the end of path
        Set<Edge<E>> incidentEdges = pathEnd.incidentEdges();
        // try to extend path along each of the incident edges
        for (Edge<E> incidentEdge : incidentEdges) {
            if (!path.containsEdge(incidentEdge)) {  // extend path along the incident edge
                Path<E> extendedPath = getCopy(path);
                extendedPath.appendEnd(incidentEdge);
                extendPath(paths, extendedPath);
            }
        }
    }

    // helper method that makes a copy of an existing path
    private static <E> Path<E> getCopy(Path<E> existingPath) {
        Path<E> newPath = new LinkedPath<E>(existingPath.getStartVertex());
        Iterator<Edge<E>> iterator = existingPath.iterator();
        while (iterator.hasNext())
            newPath.appendEnd(iterator.next());
        return newPath;
    }

    public static void main(String[] args) {
        GraphADT<String> graph = new AdjacencyListGraph<String>();
        Vertex<String> auckland = graph.addVertex("Auc");
        Vertex<String> wellington = graph.addVertex("Wel");
        Vertex<String> christchurch = graph.addVertex("Chr");
        Vertex<String> chatham = graph.addVertex("Cha");
        Vertex<String> fiji = graph.addVertex("Fij");
        Vertex<String> samoa = graph.addVertex("Sam");
        Vertex<String> tahiti = graph.addVertex("Tah");
        Vertex<String> brisbane = graph.addVertex("Bri");
        Vertex<String> sydney = graph.addVertex("Syd");
        Vertex<String> melbourne = graph.addVertex("Mel");
        graph.addEdge(auckland, wellington);
        graph.addEdge(auckland, christchurch);
        graph.addEdge(auckland, fiji);
        graph.addEdge(auckland, samoa);
        graph.addEdge(auckland, tahiti);
        graph.addEdge(auckland, brisbane);
        graph.addEdge(auckland, sydney);
        graph.addEdge(auckland, melbourne);
        graph.addEdge(wellington, christchurch);
        graph.addEdge(wellington, chatham);
        graph.addEdge(christchurch, melbourne);
        graph.addEdge(fiji, samoa);
        graph.addEdge(fiji, sydney);
        graph.addEdge(brisbane, sydney);
        graph.addEdge(sydney, melbourne);
        System.out.println("Example Graph:\n" + graph);
        System.out.println("Performing Depth-first search from Auc:");
        Set<Vertex<String>> set = performRecursion(graph, auckland);
        System.out.println(set);
        System.out.println("Performing Breadth-first search from Auc:");
        List<Vertex<String>> list = breadthFirstSearch(graph, auckland);
        list = breadthFirstSearch(graph, auckland);
        System.out.println(list);
        System.out.print("Finding paths from Cha to Sam: ");
        Map<Vertex<String>, Set<Path<String>>> paths = allPaths(chatham);
        System.out.println("there are " + paths.get(samoa).size()
                + " such paths");
    }
}
