package modele.metier;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class Fractale {

	private static final double XMIN = -2;
	private static final double XMAX = 2;
	private static final double YMIN = -2;
	private static final double YMAX = 2;
	private static final int MAX_ITERATIONS = 20;
	
	/**
	 * Génération du fractale
	 * @param pImage image
	 * @param col couleur
	 */
	public void generate(BufferedImage pImage, Color col) { 
		int width = pImage.getWidth();
		int height = pImage.getHeight();
		WritableRaster raster = pImage.getRaster();
		ColorModel model = pImage.getColorModel();
		Color fractalColor = col;
		int argb = fractalColor.getRGB();
		Object colorData = model.getDataElements(argb, null);
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{ 	double a = XMIN + i * (XMAX - XMIN) / width;
				double b = YMIN + j * (YMAX - YMIN) / height;
				if (!escapesToInfinity(a, b))
				{
					raster.setDataElements(i, j, colorData);
				}
			}
		}
	}
	
	private boolean escapesToInfinity(double a, double b) { 
		double x = 0.0;
		double y = 0.0;
		int iterations = 0;
		boolean ok = true;
		double xnew = .0;
		double ynew = .0;
		do
		{ 	xnew = x * x - y * y + a;
			ynew = 2 * x * y + b;
			x = xnew;
			y = ynew;
			iterations++;
			if (iterations == MAX_ITERATIONS)
			{
				ok = false;
			}
		}
		while (x <= 2 && y <= 2 && ok);
		return ok;
	}
}
