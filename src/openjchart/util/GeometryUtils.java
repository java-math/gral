package openjchart.util;
import java.awt.Shape;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public abstract class GeometryUtils {
	public static final double EPSILON = 1e-3;
	public static final double EPSILON_SQ = EPSILON*EPSILON;

	public static List<Line2D> shapeToLines(Shape path) {
		LinkedList<Line2D> lines = new LinkedList<Line2D>();
		PathIterator i = new FlatteningPathIterator(path.getPathIterator(null), 0.5);

		double[] coords = new double[6];
		double[] coordsPrev = new double[6];
		while (!i.isDone()) {
			int segment = i.currentSegment(coords);

			if (segment==PathIterator.SEG_LINETO || segment==PathIterator.SEG_CLOSE) {
				Line2D line = new Line2D.Double(coordsPrev[0], coordsPrev[1], coords[0], coords[1]);
				lines.add(line);
			}
			if (segment==PathIterator.SEG_CLOSE && !lines.isEmpty()) {
				Point2D firstPoint = lines.getFirst().getP1();
				Point2D lastPoint = lines.getLast().getP2();
				if (!firstPoint.equals(lastPoint)) {
					Line2D line = new Line2D.Double(coords[0], coords[1], firstPoint.getX(), firstPoint.getY());
					lines.add(line);
				}
			}

			System.arraycopy(coords, 0, coordsPrev, 0, 6);
			i.next();
		}
		return lines;
	}

	/**
     * Returns the intersection point(s) of a rectangle and a line.
     * @param r Rectangle
     * @param l Line
     * @return Intersection points, or empty array if
     * no intersections were found
     */
    public static List<Point2D> intersection(final Rectangle2D r, final Line2D l) {
    	List<Point2D> intersections = new ArrayList<Point2D>(2);
    	Point2D intersection = null;
    	Line2D edge = null;

    	// Top
    	edge = new Line2D.Double(
    		r.getMinX(), r.getMinY(),
    		r.getMaxX(), r.getMinY());
    	intersection = intersection(edge, l);
    	if (intersection != null) {
    		intersections.add(intersection);
    	}

    	// Bottom
    	edge = new Line2D.Double(
    		r.getMinX(), r.getMaxY(),
    		r.getMaxX(), r.getMaxY());
    	intersection = intersection(edge, l);
    	if (intersection != null) {
    		intersections.add(intersection);
    	}

    	if (intersections.size() < 2) {
			// Left
			edge = new Line2D.Double(
				r.getMinX(), r.getMinY(),
				r.getMinX(), r.getMaxY());
			intersection = intersection(edge, l);
			if (intersection != null) {
				intersections.add(intersection);
			}
    	}

    	if (intersections.size() < 2) {
			// Right
			edge = new Line2D.Double(
				r.getMaxX(), r.getMinY(),
				r.getMaxX(), r.getMaxY());
			intersection = intersection(edge, l);
			if (intersection != null) {
				intersections.add(intersection);
			}
    	}

    	return intersections;
	}

    /**
     * Returns the intersection point of two lines.
     * @param l1 First line
     * @param l2 Second line
     * @return Intersection point, or <code>null</code> if
     * no intersection was found
     */
    public static Point2D intersection(final Line2D l1, final Line2D l2) {
    	Point2D p0 = new Point2D.Double(l1.getX1(), l1.getY1());
		Point2D d0 = new Point2D.Double(l1.getX2()-p0.getX(), l1.getY2()-p0.getY());
		Point2D p1 = new Point2D.Double(l2.getX1(), l2.getY1());
		Point2D d1 = new Point2D.Double(l2.getX2()-p1.getX(), l2.getY2()-p1.getY());

		Point2D e = new Point2D.Double(p1.getX()-p0.getX(), p1.getY()-p0.getY());
		double kross = d0.getX()*d1.getY() - d0.getY()*d1.getX();
		double sqrKross = kross * kross;
		double sqrLen0 = d0.distanceSq(0.0, 0.0);
		double sqrLen1 = d1.distanceSq(0.0, 0.0);

		if (sqrKross > EPSILON_SQ * sqrLen0 * sqrLen1) {
			double s = (e.getX()*d1.getY() - e.getY()*d1.getX()) / kross;
			if (s < 0d || s > 1d) {
				return null;
			}
			double t = (e.getX()*d0.getY() - e.getY()*d0.getX()) / kross;
			if (t < 0d || t > 1d) {
				return null;
			}
			return new Point2D.Double(
				p0.getX() + s * d0.getX(), p0.getY() + s * d0.getY()
			);
		}

		/*
		double sqrLenE = e.lengthSq();
		kross = e.cross(d0);
		sqrKross = kross*kross;
		if (sqrKross > SQR_EPSILON*sqrLen0*sqrLenE) {
			return null;
		}
		*/

		return null;
	}
}
