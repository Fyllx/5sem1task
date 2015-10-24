import java.util.function.BiFunction;

public class RungeKutt implements Method {

	/**
	 * O(h^3)
	 */
	@Override
	public double[] solve(double a, double b, BiFunction<Double, Double, Double> f, double y0, int N) {
		double h = (b - a) / (N - 1);
		double[] y = new double[N];
		y[0] = y0;
		for (int i = 0; i < N - 1; i++) {
			double xi = a + i * h;
			double k1 = h * f.apply(xi, y[i]);
			double k2 = h * f.apply(xi + h / 2., y[i] + k1 / 2.);
			double k3 = h * f.apply(xi + h, y[i] - k1 + 2 * k2);
			y[i + 1] = y[i] + (k1 + 4 * k2 + k3) / 6.;
		}
		return y;
	}

	@Override
	public String getName() {
		return "Runge-Kutt's method";
	}

}