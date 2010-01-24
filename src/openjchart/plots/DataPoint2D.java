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

package openjchart.plots;

import java.awt.Shape;
import java.awt.geom.Point2D;

import openjchart.Drawable;

/**
 * Class for storing points of a plot.
 */
public class DataPoint2D {
	private final Point2D position;
	private final Drawable drawable;
	private final Shape shape;

	/**
	 * Creates a new <code>DataPoint2D</code> object with the specified position,
	 * <code>Drawable</code>, and shape.
	 * @param position Coordinates.
	 * @param drawable Representation.
	 * @param shape Shape.
	 */
	public DataPoint2D(Point2D position, Drawable drawable, Shape shape) {
		this.position = position;
		this.drawable = drawable;
		this.shape = shape;
	}

	/**
	 * Returns the coordinates of this <code>DataPoint2D</code>.
	 * @return Position.
	 */
	public Point2D getPosition() {
		return position;
	}

	/**
	 * Returns the <code>Drawable</code> which represents this <code>DataPoint2D</code>.
	 * @return <code>Drawable</code> instance.
	 */
	public Drawable getDrawable() {
		return drawable;
	}

	/**
	 * Returns the shape of this <code>DataPoint2D</code>.
	 * @return <code>Shape</code>.
	 */
	public Shape getShape() {
		return shape;
	}

}
