/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

// YOU MIGHT NEED TO CHANGE THE package AND import ARGUMENTS
package week11;

/**
*
* @author Antonio Cerone
*/
public class Test {

public static void main(String[] args) {

System.out.println();

System.out.println("Example 1.");

Queue<StringTree> args1 = new LinkedListQueue();
args1.enqueue(new StringTree("p"));
args1.enqueue(new StringTree("h"));
StringTree tree1 = new StringTree("I",args1);

Queue<StringTree> args2 = new LinkedListQueue();
args2.enqueue(new StringTree("a"));
args2.enqueue(new StringTree("s"));
args2.enqueue(new StringTree("e"));
StringTree tree2 = new StringTree("E",args2);

Queue<StringTree> args3 = new LinkedListQueue();
args3.enqueue(tree1);
args3.enqueue(new StringTree("r"));
args3.enqueue(tree2);
StringTree tree3 = new StringTree("W",args3);

System.out.println();
try {
System.out.println("The string of leaves is: "
+ tree3.leafString());
} catch (Exception ex) {
System.out.println(ex);
}
System.out.println();
try {
System.out.println("The tree has been preserved. "
+ "The string of leaves is still: "
+ tree3.leafString()); 
} catch (Exception ex) {
System.out.println(ex);
}
System.out.println();
try {
System.out.println("Prefix: " + tree1.leafString() + "\n"
+ "Postfix: " + tree2.leafString());
} catch (Exception ex) {
System.out.println(ex);
}

System.out.println();
System.out.println();

System.out.println("Example 2.");

args1 = new LinkedListQueue();
args1.enqueue(new StringTree("The"));
tree1 = new StringTree("Article",args1);

args2 = new LinkedListQueue();
args2.enqueue(new StringTree("person"));
tree2 = new StringTree("Noun",args2);

args3 = new LinkedListQueue();
args3.enqueue(new StringTree("in"));
tree3 = new StringTree("Preposition",args3);

Queue<StringTree> args4 = new LinkedListQueue();
args4 = new LinkedListQueue();
args4.enqueue(new StringTree("the"));
StringTree tree4 = new StringTree("Article",args4);

Queue<StringTree> args5 = new LinkedListQueue();
args5 = new LinkedListQueue();
args5.enqueue(new StringTree("queue"));
StringTree tree5 = new StringTree("Noun",args5);

Queue<StringTree> args6 = new LinkedListQueue();
args6.enqueue(tree4);
args6.enqueue(tree5);
StringTree tree6 = new StringTree("Noun Phrase",args6);

Queue<StringTree> args7 = new LinkedListQueue();
args7.enqueue(tree3);
args7.enqueue(tree6);
StringTree tree7 = new StringTree("Prepositional Phrase",args7);

Queue<StringTree> args8 = new LinkedListQueue();
args8.enqueue(tree1);
args8.enqueue(tree2);
args8.enqueue(tree7);
StringTree tree8 = new StringTree("Noun Phrase",args8);

Queue<StringTree> args9 = new LinkedListQueue();
args9 = new LinkedListQueue();
args9.enqueue(new StringTree("the"));
StringTree tree9 = new StringTree("Article",args9);

Queue<StringTree> args10 = new LinkedListQueue();
args10 = new LinkedListQueue();
args10.enqueue(new StringTree("back"));
StringTree tree10 = new StringTree("Noun",args10);

Queue<StringTree> args11 = new LinkedListQueue();
args11 = new LinkedListQueue();
args11.enqueue(new StringTree("the"));
StringTree tree11 = new StringTree("Article",args11);

Queue<StringTree> args12 = new LinkedListQueue();
args12 = new LinkedListQueue();
args12.enqueue(new StringTree("bus"));
StringTree tree12 = new StringTree("Noun",args12);

Queue<StringTree> args13 = new LinkedListQueue();
args13.enqueue(tree9);
args13.enqueue(tree10);
StringTree tree13 = new StringTree("Noun Phrase",args13);

Queue<StringTree> args14 = new LinkedListQueue();
args14.enqueue(tree11);
args14.enqueue(tree12);
StringTree tree14 = new StringTree("Noun Phrase",args14);

Queue<StringTree> args15 = new LinkedListQueue();
args15.enqueue(new StringTree("from"));
StringTree tree15 = new
StringTree("Preposition",args15);

Queue<StringTree> args16 = new LinkedListQueue();
args16.enqueue(tree15);
args16.enqueue(tree13);
StringTree tree16 = new StringTree("Prepositional Phrase",args16);

Queue<StringTree> args17 = new LinkedListQueue();
args17.enqueue(new StringTree("board"));
StringTree tree17 = new StringTree("Verb",args17);

Queue<StringTree> args18 = new LinkedListQueue();
args18.enqueue(tree17);
args18.enqueue(tree14);
args18.enqueue(tree16);
StringTree tree18 = new StringTree("Verb Phrase",args18);

Queue<StringTree> args19 = new LinkedListQueue();
args19.enqueue(new StringTree("will"));
StringTree tree19 = new StringTree("Auxiliary Verb",args19);

Queue<StringTree> args20 = new LinkedListQueue();
args20.enqueue(tree8);
args20.enqueue(tree19);
args20.enqueue(tree18);
StringTree tree20 = new StringTree("Sentence",args20);

System.out.println();

System.out.println("Print the sentence:");
try {
System.out.println("" + tree20.leafString());
} catch (Exception ex) {
System.out.println(ex);
}
System.out.println();
System.out.println("Print again the same sentence:");
try {
System.out.println("" + tree20.leafString());
} catch (Exception ex) {
System.out.println(ex);
}
System.out.println();

}

}