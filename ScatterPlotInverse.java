import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Paint;
import java.lang.Math.*;

import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ScatterPlotInverse extends ApplicationFrame{
	static ScatterPlot s=new ScatterPlot("Scatter Plot for A");
	public ScatterPlotInverse(String title) {

        super(title);
        String[] args = {};
        PowerDriver p=s.getP();
        
        XYDataset data = createDataset(p.getIDeterminants(), p.getITraces());
        JFreeChart chart = ChartFactory.createScatterPlot(
            "Scatter Plot",
            "Determinant", "Trace", 
            data, 
            PlotOrientation.VERTICAL,
            true, 
            true, 
            false
        );
        NumberAxis domainAxis = (NumberAxis) chart.getXYPlot().getDomainAxis();
        domainAxis.setAutoRangeIncludesZero(false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setVerticalAxisTrace(true);
        chartPanel.setHorizontalAxisTrace(true);
        //chartPanel.setVerticalZoom(true);
        //chartPanel.setHorizontalZoom(true);
        setContentPane(chartPanel);

    }
	
	public static void main(String[] args) {

        ScatterPlotInverse plot = new ScatterPlotInverse("Scatter Plot for Inverse of A");
        plot.pack();
        RefineryUtilities.centerFrameOnScreen(plot);
        plot.setVisible(true);
        s.pack();
        RefineryUtilities.centerFrameOnScreen(s);
        s.setVisible(true);


    }
	
	private static XYDataset createDataset(ArrayList<Double> datax, ArrayList<Double> datay){
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("Scatter");
                for(int i = 0; i < datax.size(); i++){
                        series.add(datax.get(i), datay.get(i));
                }
                dataset.addSeries(series);
                return dataset;
    }
	
}
