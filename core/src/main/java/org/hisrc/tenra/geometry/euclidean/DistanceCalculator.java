package org.hisrc.tenra.geometry.euclidean;

import org.apache.commons.math3.geometry.euclidean.twod.Line;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class DistanceCalculator {

	public static double calculateDistance(double[] a, double[] b,
			double[] q) {
		final Vector2D ab = new Vector2D(b[0] - a[0], b[1] - a[1]);
		final Vector2D aq = new Vector2D(q[0] - a[0], q[1] - a[1]);
		final Vector2D bq = new Vector2D(q[0] - b[0], q[1] - b[1]);

		final double aqDotProduct = ab.dotProduct(aq);
		final double bqDotProduct = -ab.dotProduct(bq);
		
		if (aqDotProduct < 0)
		{
			return aq.getNorm();
		}
		else if (bqDotProduct < 0)
		{
			return bq.getNorm();
		}
		else
		{
			final Line line = new Line(new Vector2D(a), new Vector2D(b), 1.0e-10);
			return Math.abs(line.getOffset(new Vector2D(q)));
		}
	}

}
