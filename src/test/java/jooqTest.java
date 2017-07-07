import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.jooq.lambda.Seq;
import org.junit.Test;

public class jooqTest {
	
	@FunctionalInterface
    public static interface ComplexInterface{
        int apply(int value);
    }
	
	@Test
	public void TestfoldLeft()
	{
		List<ComplexInterface> b = new ArrayList<ComplexInterface>();
		b.add(a -> a + 2);
		b.add(a -> a * 5);
		
		Seq<ComplexInterface> secB = Seq.seq(b.stream());
		assertEquals(secB.foldLeft(1, (s, f) -> f.apply(s)).intValue(), 15);
	}

}
