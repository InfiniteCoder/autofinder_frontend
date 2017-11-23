package cf.autofinder;

import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


class PieChart extends ChartFrame {


	private static final long serialVersionUID = 1L;

	static List<CountVehicle> list;

	public PieChart(String title) throws Exception{
		super(title, null);
		setContentPane(createDemoPanel());
	}

	private static PieDataset createDataset() {

		DefaultPieDataset dataset = new DefaultPieDataset();
		for(int i=0;i<list.size();i++)
		{
			dataset.setValue(String.valueOf( list.get(i).getLostPincode()),list.get(i).getCount());
		}


		return dataset;
	}

	private static JFreeChart createChart(PieDataset dataset) throws Exception{
		JFreeChart chart = ChartFactory.createPieChart3D( 
				"Auto Finder" ,  // chart title                   
				dataset ,         // data 
				true ,            // include legend                   
				true, 
				false);

		final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );             
		plot.setStartAngle( 270 );             
		plot.setForegroundAlpha( 0.60f );             
		plot.setInteriorGap( 0.02 );             

		return chart;

	}

	public static JPanel createDemoPanel() throws Exception{
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}

}

