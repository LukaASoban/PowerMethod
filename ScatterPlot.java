import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.lang.Math.*;

import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ScatterPlot extends ApplicationFrame{
	PowerDriver p=new PowerDriver();
	public ScatterPlot(String title) {

        super(title);
        String[] args = {};
        p.main(args);
        XYDataset data = createDataset(p.getDeterminants(), p.getTraces());
        JFreeChart chart = createChart(
            data
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
	
	private class MyRenderer extends XYLineAndShapeRenderer {

        public MyRenderer(boolean lines, boolean shapes) {
            super(lines, shapes);
        }

        @Override
        public void setSeriesPaint(int series, java.awt.Paint Paint) {
            super.setSeriesPaint(series, Paint);
        }
    }
	
	private JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createScatterPlot(
            "Scatter Plot Normal Matrix", "Determinant", "Trace", dataset,
            PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.white);
        XYPlot plot = (XYPlot) chart.getPlot();
        Shape[] cross = DefaultDrawingSupplier.createStandardSeriesShapes();
        plot.setBackgroundPaint(new Color(0xffffe0));
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.lightGray);
        MyRenderer renderer = new MyRenderer(false, true);
        plot.setRenderer(renderer);
        
        renderer.setSeriesPaint(0, Color.BLUE);
        plot.setRenderer(renderer);
        return chart;
    }
	
	public static void main(String[] args) {

        ScatterPlot plot = new ScatterPlot("Scatter Plot for A");
        plot.pack();
        RefineryUtilities.centerFrameOnScreen(plot);
        plot.setVisible(true);

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
	
	public PowerDriver getP(){
		return p;
	}
}
