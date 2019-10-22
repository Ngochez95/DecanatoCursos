package decanatoues.cursoues.boundary;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author daredevil
 */
public class ManejadorEstadistica {
 
    
    private BarChartModel barModelGenero;
    private BarChartModel barModelDepartamento;
    private PieChartModel pieModelGenero;
    private PieChartModel pieModelDepartamento;
    
    private BarChartModel initBarModel(BarChartModel modelo) {
        modelo = new BarChartModel();
        modelo.addSeries(initChartSeriesGenero());
        return modelo;
    }
    
    private ChartSeries initChartSeriesGenero() {
        ChartSeries serie = new ChartSeries();
        serie.set("Masculino", 10);
        serie.set("Femenino", 10);
        return serie;
    }
    
    private ChartSeries initChartSeriesDepartamento() {
        ChartSeries serie = new ChartSeries();
        serie.set("Ingenieria", 10);
        serie.set("Idiomas", 10);
        serie.set("Leyes", 10);
        serie.set("Fisica", 10);
        return serie;
    }
    
    private BarChartModel createBarModel(BarChartModel modelo, String titulo, String leyendaX, String leyendaY) {
        modelo = initBarModel(modelo);
        modelo.setTitle(titulo);
        modelo.setLegendPosition("ne");

        Axis xAxis = modelo.getAxis(AxisType.X);
        xAxis.setLabel(leyendaX);

        Axis yAxis = modelo.getAxis(AxisType.Y);
        yAxis.setLabel(leyendaY);
        yAxis.setMin(0);
        yAxis.setMax(50);
        return modelo;
    }

}
