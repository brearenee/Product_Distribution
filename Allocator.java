import java.util.Collection;
import java.util.HashSet;
/**
 * Utility class to determine allocations of units to transporters
 * based on characteristics of suppliers.
 * 
 * Different allocators (methods in this utility class)
 * may address different goal functions.
 * For example, one goal may be achieving the least expensive allocation;
 * whereas another goal may be achieving the most robust allocation
 * by accounting for potential underestimates of demand.
 * if either or both aparmeters ar enull, return a collection of size 0.
 *
 * @author Dr. Jody Paul
 * @version 20231107a
 */
public class Allocator extends Object  {

    /**
     * Allocate units to transporters to satisfy distributor
     * demands at the lowest transportation cost.
     */
    public static Collection<Transporter> allocateForLowestTransporterCost( Collection<Supplier> suppliers,
                                                                     Collection<Transporter> transporters) {
                                                                        //if either of the parameters are null, we return 
        Collection<Transporter> allocation = new HashSet<Transporter>();

        allocation = transporters; // Dummy code; replace with allocation code.
        
        return allocation;
    }

    /** Hide constructor of this utility class. */
    private Allocator() { }



    public static int totalDemand(Collection<Supplier> suppliers){
        int sum = 0;
        for (Supplier s : suppliers){
            //how do we get elements from a collection? can we index them?  theres an iterator method in a collection.   Steam method might 
            //also work - but theres nothing thats an indexed get because not all collections are indexed. 
            //so how to create an iterator?  for each loop :-) ]
            sum += s.demand();
        }
        return sum;
    }

    public static int totalAmountShipped (Collection<Transporter> transporters) {
        int sum = 0;
        for( Transporter t : transporters){
            sum += t.allocation();
        }
            return sum;
        }
    }

    public static int totalTransporterCost(Collection<Transporter> transporters) {
        //what is total transportation cost?  whats the transprotation cost of each transporteR?
        //cost per unit * number of units transporting. 
        //

        int sum = 0; 
        for (Transporter t: transporters){
            sum += t.allocation() * t.costPerUnit();
        }
        return sum;
    }


// come up with ana location that is least cost and satisfies the demands. 
//how much do we allocate to each transporter sot hat the demands are met at the lowest cost? 
//his claim is that this structure in this file, enables us to solve the problem in java once we decide on our algorithm. 

//THE SOLUTION IS A COLLECTION OF TRANSPORTERS
//THE INPUT IS SUPPLIERS AND TRANSPORTERS. 


//Collectionsin Java. The collections heirarchy is an interface. Some of the implementing class inclue arraylist, hashset, etc e
//so weve been using a class that implements a collection. 
//so to make our product work with anbodys collection, wanna yse a hashset, arraylist, stack, whatever - our code will work for
//whatever collection someone decides to put in. because all we are guaranteeing is that add, addall, clear, contains containsall methods 
//etc exist. 
//how are we going to take this data and represent in a way that helps us solve the problem? adjacency list, etc etc? and then our algorithm 
//will operate on that representation. 
//and if we decide this is a flow, well its still a directional graph with cycles in it.  



