package org.hisrc.tenra.math;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.hisrc.tenra.geometry.euclidean.DistanceCalculator;
import org.junit.Assert;
import org.junit.Test;

public class DistanceTest {

	@Test
	public void calculatesDistance() {
		double[] a = { 3, 5 };
		double[] b = { 5, 3 };
		double[] p = { 1, 4 };
		double[] q = { 0, 0 };
		double[] r = { 6, 1 };
		double[] s = { 4, 4 };

		Vector2D ab = new Vector2D(b[0] - a[0], b[1] - a[1]);
		Vector2D ba = new Vector2D(a[0] - b[0], a[1] - b[1]);

		Vector2D pa = new Vector2D(a[0] - p[0], a[1] - p[1]);
		Vector2D pb = new Vector2D(b[0] - p[0], b[1] - p[1]);

		Vector2D qa = new Vector2D(a[0] - q[0], a[1] - q[1]);
		Vector2D qb = new Vector2D(b[0] - q[0], b[1] - q[1]);

		Vector2D ra = new Vector2D(a[0] - r[0], a[1] - r[1]);
		Vector2D rb = new Vector2D(b[0] - r[0], b[1] - r[1]);

		Vector2D sa = new Vector2D(a[0] - s[0], a[1] - s[1]);
		Vector2D sb = new Vector2D(b[0] - s[0], b[1] - s[1]);

		double pDistance2 = Math.pow(
				DistanceCalculator.calculateDistance(a, b, p), 2);
		double qDistance2 = Math.pow(
				DistanceCalculator.calculateDistance(a, b, q), 2);
		double rDistance2 = Math.pow(
				DistanceCalculator.calculateDistance(a, b, r), 2);
		double sDistance2 = Math.pow(
				DistanceCalculator.calculateDistance(a, b, s), 2);

		Assert.assertEquals(5, pDistance2, 10e-10);
		Assert.assertEquals(32, qDistance2, 10e-10);
		Assert.assertEquals(5, rDistance2, 10e-10);
		Assert.assertEquals(0, sDistance2, 10e-10);
	}
}
