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

package openjchart.tests.plots.colors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.awt.Color;

import openjchart.plots.colors.RandomColors;

import org.junit.Test;

public class RandomColorsTest {
	@Test
	public void testGet() {
		RandomColors c = new RandomColors();
		Color prv = null;
		for (double i = 0.0; i <= 1.0; i += 0.1) {
			Color cur = c.get(i);
			assertNotNull(cur);
			assertFalse(cur.equals(prv));
			prv = cur;
		}
	}

}
