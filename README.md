# graphShortestPath

#Getting Started

Prerequisites:

Java (version>=1.8)

Maven (version>=3.6.3)

#Build

(If you don't want build from source code , can have a try the jar file in directory graphShortestPath/target/graphShortestPath-0.0.1-SNAPSHOT.jar, command:  java -jar target/graphShortestPath-0.0.1-SNAPSHOT.jar)


1. Open a command console and cd into the graphShortestPath folder.(to make sure you are in the correct folder, please use command "ls" to double check whether you can see these in your current directory: a "src" folder, a "pom.xml" file)

2. Run the below command:

mvn clean install

Or

mvn package


It will run all the test cases compile class files and build a jar file in target/ directory (jar name: graphShortestPath-0.0.1-SNAPSHOT.jar)



3. Running the application

java -jar target/graphShortestPath-0.0.1-SNAPSHOT.jar


Then you will see the results below(It calculated all the shortest paths from node A including A->F):

From A to A, the shortest path is: A-->A

From A to B, the shortest path is: A-->B

From A to C, the shortest path is: A-->C

From A to D, the shortest path is: A-->E-->G-->F-->D

From A to E, the shortest path is: A-->E

From A to F, the shortest path is: A-->E-->G-->F

From A to G, the shortest path is: A-->E-->G

*****************************************************************************

From A to A, the shortest path value is：0

From A to B, the shortest path value is：3

From A to C, the shortest path value is：1

From A to D, the shortest path value is：7

From A to E, the shortest path value is：2

From A to F, the shortest path value is：5

From A to G, the shortest path value is：4



If need to calculate on another graph, just need to open the src file App.java, and fill in the new array of the new graph, e.g:



// A  B  C  D  E  F  G

{ 0, 3, 1, M, 2, M, M }, // A

{ 3, 0, M, 6, 4, 3, M }, // B

{ 1, M, 0, M, 5, M, M }, // C

{ M, 6, M, 0, M, 2, M }, // D

{ 2, 4, 5, M, 0, M, 2 }, // E

{ M, 3, M, 2, M, 0, 1 }, // F

{ M, M, M, M, 2, 1, 0 }  // G

