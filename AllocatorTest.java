import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;//concrete version of collector
import java.util.List;//at some point i'm gonna need a list lol 
/**
 * Test scaffolding for class Allocator.
 * @author  Dr. Jody Paul
 * @version 20231112
 */
public class AllocatorTest {
    // Data for tests.
    public Supplier s0, s1, s2; //s0 is denmark
    public Transporter tM, tA, tB, tC; 
    public Collection<Supplier> sColl;//should still have generic 
    public Collection<Supplier> tColl;//this is all what i want to be available for any test that i write. thats why its up here. 
    //they didnt need to be public but sometimes during debugging you wanna be able to see stuff. 

    /**
     * Constructor generates and saves serialized test data.
     */
    //constructor envoked  when running unit tests. 
    public AllocatorTest() {
        // Generate test data.
       //this is all just dummy stuff, i think.  0- = storage cost.  
        Supplier manufacturer = new Supplier("Manufacturer", 0, 0, 400, 999);
        Supplier dist1 = new Supplier("Distributor 1", 3, 55, 0, 147);
        Supplier dist2 = new Supplier("Distributor 2", 5, 40, 0, 157);
        //no allocations on these yet because we havent run our program. 
        Transporter manuShip = new Transporter("Shipping",
                                              manufacturer,
                                              dist1,
                                              0,
                                              Transporter.MAX_UNITS,
                                              0);
        Transporter transpA = new Transporter("Transporter A",
                                              dist1,
                                              dist2,
                                              35,
                                              30,
                                              0);
        Transporter transpB = new Transporter("Transporter B",
                                              dist1,
                                              dist2,
                                              40,
                                              90,
                                              0);
        Transporter transpC = new Transporter("Transporter C",
                                              dist2,
                                              dist1,
                                              25,
                                              20,
                                              0);
        //envoke serialization. 
        //i want to know what data is being used and i may want to restore it in some other places. and its alwso a way of 
        //reinitalizing things if i need it.
        try {
            manufacturer.save("sup0.ser");
            dist1.save("sup1.ser");
            dist2.save("sup2.ser");
            manuShip.save("trnM.ser");
            transpA.save("trnA.ser");
            transpB.save("trnB.ser");
            transpC.save("trnC.ser");
        } catch (Exception e) {
            System.err.println("Exception when saving serialized data. " + e);
        }
        
    }

    /**
     * Sets up the test fixture by restoring
     * serialized suppliers and transporters.
     * Called before every test case method.
     */
    //since the tests can mess with the data, i want fresh data at the start of every test. 
    @BeforeEach
    public void setUp() {
        s0 = new Supplier(); // Manufacturer
        s1 = new Supplier(); // Distributor 1
        s2 = new Supplier(); // Distributor 2
        tM = new Transporter(); // Shipping from manufacturer
        tA = new Transporter();
        tB = new Transporter();
        tC = new Transporter();
        try {
            s0.restore("sup0.ser");
            s1.restore("sup1.ser");
            s2.restore("sup2.ser");
            tM.restore("trnM.ser");
            tA.restore("trnA.ser");
            tB.restore("trnB.ser");
            tC.restore("trnC.ser");
        } catch (Exception e) {
            System.err.println("Exception when restoring test data. " + e);
        }
        // Validate at least one field of one restored object.
        if (!tB.name().equals("Transporter B")) {
            System.err.println("Restored test data corrupted.");
            System.exit(1);
        }
        sColl = new HashSet();
        sColl.add(s0);
        sColl.add(s1);
        sColl.add(s2);
        tColl = new HashSet();
        tColl.add(tM);
        tColl.add(tA);
        tColl.add(tB);
        tColl.add(tC);
    }

    /**
     * Tears down the test fixture, enabling garbage collection.
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
        s0 = s1 = s2 = null;
        tM = tA = tB = tC = null;
    }
}
