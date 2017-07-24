import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;

import org.jooq.lambda.Seq;
import org.junit.Test;

public class jooqTest {
	
	@Test
	public void TestFoldLeft()
	{
		List<IntUnaryOperator> b = new ArrayList<IntUnaryOperator>();
		b.add(a -> a + 2);
		b.add(a -> a * 5);
		
		Seq<IntUnaryOperator> secB = Seq.seq(b.stream());
		assertEquals(secB.foldLeft(1, (s, f) -> f.applyAsInt(s)).intValue(), 15);
	}

}
