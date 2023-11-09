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
 *
 * @author Dr. Jody Paul
 * @version 20231107a
 */
public class Allocator {

    /**
     * Allocate units to transporters to satisfy distributor
     * demands at the lowest transportation cost.
     */
    public static Collection<Transporter> allocateForLowestTransporterCost(
                                              Collection<Supplier> suppliers,
                                              Collection<Transporter> transporters) {
        Collection<Transporter> allocation = new HashSet<Transporter>();

        allocation = transporters; // Dummy code; replace with allocation code.
        
        return allocation;
    }

    /** Hide constructor of this utility class. */
    private Allocator() { }
}


// come up with ana location that is least cost and satisfies the demands. 
//how much do we allocate to each transporter sot hat the demands are met at the lowest cost? 
//his claim is that this structure in this file, enables us to solve the problem in java once we decide on our algorithm. 

//THE SOLUTION IS A COLLECTION OF TRANSPORTERS
//THE INPUT IS SUPPLIERS AND TRANSPORTERS. 
