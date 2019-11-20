package decanatoues.cursoues.boundary;

import decanatoues.cursoues.controller.EstudianteFacade;
import decanatoues.cursoues.entity.Estudiante;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author daredevil
 */
@ManagedBean
@Named
@RequestScoped
public class ManejadorEstadistica implements Serializable {

    @Inject
    private EstudianteFacade ef;

    private BarChartModel barModelGenero;
    private BarChartModel barModelDepartamento;
    private List<Estudiante> listaGenero, listaDepto;

    @PostConstruct
    public void init() {
        llenar();
    }

    public void llenar() {
        createBarModelGenero();
        createBarModelDepto();
    }

    public List<Estudiante> llenarPorGenero(boolean genero) {
        List<Estudiante> lista = ef.findByGenero(genero);
        if (lista != null && !lista.isEmpty()) {
            listaGenero = lista;
        } else {
            lista = new ArrayList<>();
        }
        return listaGenero;
    }

    public List<Estudiante> llenarPorDepto(int id) {
        List<Estudiante> lista = ef.findByDepartamento(id);
        if (lista != null && !lista.isEmpty()) {
            listaDepto = lista;
        } else {
            lista = new ArrayList<>();
        }
        return listaDepto;
    }

    private BarChartModel initBarModelGenero() {
        BarChartModel model = new BarChartModel();

        ChartSeries estudiantes = new ChartSeries();
        estudiantes.setLabel("Genero");
        estudiantes.set("Masculino", llenarPorGenero(true).size());
        estudiantes.set("Femenino", llenarPorGenero(false).size());

        model.addSeries(estudiantes);
        return model;
    }

    private BarChartModel initBarModelDepto() {
        BarChartModel model = new BarChartModel();

        ChartSeries estudiantes = new ChartSeries();
        estudiantes.setLabel("Departamento");
        estudiantes.set("Medicina", llenarPorDepto(0).size());
        estudiantes.set("CC Juridicas", llenarPorDepto(1).size());
        estudiantes.set("CC Sociales, Filosofia y Letras", llenarPorDepto(2).size());
        estudiantes.set("Idiomas", llenarPorDepto(3).size());
        estudiantes.set("Ingenieria", llenarPorDepto(4).size());
        estudiantes.set("CC Economicas", llenarPorDepto(5).size());
        estudiantes.set("Quimica", llenarPorDepto(6).size());
        estudiantes.set("Biologia", llenarPorDepto(7).size());
        estudiantes.set("Fisica", llenarPorDepto(8).size());
        estudiantes.set("Matematica", llenarPorDepto(9).size());
        model.addSeries(estudiantes);
        return model;
    }

    private void createBarModelGenero() {
        barModelGenero = initBarModelGenero();
        barModelGenero.setTitle("Estudiantes por Genero");
        barModelGenero.setLegendPosition("ne");

        Axis xAxis = barModelGenero.getAxis(AxisType.X);
        xAxis.setLabel("Genero");

        Axis yAxis = barModelGenero.getAxis(AxisType.Y);
        yAxis.setLabel("Numero Estudiantes");
        yAxis.setMin(0);
        yAxis.setMax(ef.count() + 10);
    }

    private void createBarModelDepto() {
        barModelDepartamento = initBarModelDepto();
        barModelDepartamento.setTitle("Estudiantes por Departamento");
        barModelDepartamento.setLegendPosition("ne");

        Axis xAxis = barModelDepartamento.getAxis(AxisType.X);
        xAxis.setLabel("Departamento");

        Axis yAxis = barModelDepartamento.getAxis(AxisType.Y);
        yAxis.setLabel("Numero Estudiantes");
        yAxis.setMin(0);
        yAxis.setMax(ef.count() + 10);
    }

    public BarChartModel getBarModelGenero() {
        return barModelGenero;
    }

    public BarChartModel getBarModelDepartamento() {
        return barModelDepartamento;
    }
}
