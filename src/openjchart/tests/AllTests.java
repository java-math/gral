package openjchart.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	UtilTests.class,
	AxisTest.class,
	LinearRenderer2DTest.class,
	LogarithmicRenderer2DTest.class,
	DataTableTest.class
})
public class AllTests {
}