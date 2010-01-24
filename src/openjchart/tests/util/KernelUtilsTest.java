/* OpenJChart : a free plotting library for the Java(tm) platform
 *
 * (C) Copyright 2009-2010, by Erich Seifert and Michael Seifert.
 *
 * This file is part of OpenJChart.
 *
 * OpenJChart is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * OpenJChart is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OpenJChart.  If not, see <http://www.gnu.org/licenses/>.
 */

package openjchart.tests.util;

import static org.junit.Assert.assertEquals;
import openjchart.data.filters.Kernel;
import openjchart.util.KernelUtils;

import org.junit.Test;

public class KernelUtilsTest {
	public static final double DELTA = 1e-15;

	@Test
	public void testBinomial() {
		Kernel kernel;

		// Small kernel
		kernel = KernelUtils.getBinomial(2);
		assertEquals(2, kernel.size());
		assertEquals(1, kernel.getOffset());
		assertEquals(0.00, kernel.get(-2), DELTA);
		assertEquals(0.50, kernel.get(-1), DELTA);
		assertEquals(0.50, kernel.get( 0), DELTA);
		assertEquals(0.00, kernel.get( 1), DELTA);
		assertEquals(0.00, kernel.get( 2), DELTA);

		// Large kernel
		kernel = KernelUtils.getBinomial(13);
		assertEquals(13, kernel.size());
		assertEquals(6, kernel.getOffset());
		assertEquals(0.1933593750, kernel.get(-1), DELTA);
		assertEquals(0.2255859375, kernel.get( 0), DELTA);
		assertEquals(0.1933593750, kernel.get( 1), DELTA);

		// Kernel with specified variance
		kernel = KernelUtils.getBinomial(1.0);
		assertEquals(5, kernel.size());
		assertEquals(2, kernel.getOffset());
	}

	@Test
	public void testUniform() {
		Kernel kernel = KernelUtils.getUniform(13, 0, 1.0);
		assertEquals(13, kernel.size());
		assertEquals(0, kernel.getOffset());
		assertEquals(0.0, kernel.get(-1), DELTA);
		assertEquals(1.0, kernel.get( 0), DELTA);
		assertEquals(1.0, kernel.get(12), DELTA);
		assertEquals(0.0, kernel.get(13), DELTA);
	}

}
