package org.pentaho.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.pentaho.chart.model.AreaPlot;
import org.pentaho.chart.model.BarPlot;
import org.pentaho.chart.model.ChartModel;
import org.pentaho.chart.model.LinePlot;
import org.pentaho.chart.model.Palette;
import org.pentaho.chart.model.PiePlot;
import org.pentaho.chart.model.BarPlot.BarPlotFlavor;
import org.pentaho.chart.model.CssStyle.FontStyle;
import org.pentaho.chart.model.CssStyle.FontWeight;
import org.pentaho.chart.model.LinePlot.LinePlotFlavor;
import org.pentaho.chart.model.Plot.Orientation;
import org.pentaho.chart.model.Theme.ChartTheme;
import org.pentaho.chart.model.util.ChartSerializer;
import org.pentaho.chart.model.util.ChartSerializer.ChartSerializationFormat;

public class SerializationTest {

  @Before
  public void init(){}
  
  @Test
  public void testBarPlot(){
    
    ChartModel chartModel = new ChartModel();
    chartModel.setTheme(ChartTheme.THEME4);
    chartModel.setBackground(0x343434);
    chartModel.setBorderColor(0x987654);
    chartModel.setBorderVisible(true);
    chartModel.getTitle().setText("Chart Title");
    chartModel.getTitle().setColor(0x123456);
    chartModel.getTitle().setFont("monospace", 20, FontStyle.OBLIQUE, FontWeight.BOLD);
    chartModel.getLegend().setVisible(true);
    chartModel.getLegend().setBorderColor(0x654321);
    chartModel.getLegend().setBorderVisible(true);
    chartModel.getLegend().setBorderWidth(2);
    chartModel.getLegend().setFont("verdana", 18, FontStyle.ITALIC, FontWeight.BOLD);
    
    BarPlot barPlot = new BarPlot();
    barPlot.setBackground(0x765890);
    barPlot.setFlavor(BarPlotFlavor.THREED);
    barPlot.setOpacity(0.75f);
    barPlot.setOrientation(Orientation.HORIZONTAL);
    barPlot.setPalette(new Palette(0x001111, 0x222222, 0x333333));
    barPlot.getXAxisLabel().setText("xAxis");
    barPlot.getXAxisLabel().setColor(0x192837);
    barPlot.getXAxisLabel().setFont("san-serif", 10, FontStyle.NORMAL, FontWeight.NORMAL);
    barPlot.getYAxisLabel().setText("yAxis");
    barPlot.getYAxisLabel().setColor(0x192837);
    barPlot.getYAxisLabel().setFont("san-serif", 12, FontStyle.OBLIQUE, FontWeight.BOLD);
    
    chartModel.setPlot(barPlot);
    
    
    String result = ChartSerializer.serialize(chartModel, ChartSerializationFormat.XML);
    
    System.out.println(result);
    
    ChartModel chartModel2 = ChartSerializer.deSerialize(result, ChartSerializationFormat.XML);
    assertEquals(chartModel2.getTheme(), ChartTheme.THEME4);
    assertEquals(chartModel2.getBackground(), new Integer(0x343434));
    assertTrue(chartModel2.getBorderVisible());
    assertEquals(chartModel2.getBorderColor(), new Integer(0x987654));
    assertEquals(chartModel2.getBorderWidth(), new Integer(1));
    assertEquals(chartModel2.getTitle().getText(), "Chart Title");
    assertEquals(chartModel2.getTitle().getColor(), 0x123456);
    assertEquals(chartModel2.getTitle().getFontFamily(), "monospace");
    assertEquals(chartModel2.getTitle().getFontSize(), new Integer(20));
    assertEquals(chartModel2.getTitle().getFontStyle(), FontStyle.OBLIQUE);
    assertEquals(chartModel2.getTitle().getFontWeight(), FontWeight.BOLD);
    assertTrue(chartModel2.getLegend().getVisible());
    assertTrue(chartModel2.getLegend().getBorderVisible());
    assertEquals(chartModel2.getLegend().getBorderWidth(), 2);
    assertEquals(chartModel2.getLegend().getFontFamily(), "verdana");
    assertEquals(chartModel2.getLegend().getFontSize(), new Integer(18));
    assertEquals(chartModel2.getLegend().getFontStyle(), FontStyle.ITALIC);
    assertEquals(chartModel2.getLegend().getFontWeight(), FontWeight.BOLD);
    
    assertTrue(chartModel2.getPlot() instanceof BarPlot);    
    barPlot = (BarPlot)chartModel2.getPlot();
    assertEquals(barPlot.getBackground(), new Integer(0x765890));
    assertEquals(barPlot.getFlavor(), BarPlotFlavor.THREED);
    assertEquals(barPlot.getOpacity(), new Float(0.75));
    assertEquals(barPlot.getOrientation(), Orientation.HORIZONTAL);
    Palette palette = chartModel2.getPlot().getPalette();
    assertEquals(palette.size(), 3);
    assertEquals(palette.get(0), 0x001111);
    assertEquals(palette.get(1), 0x222222);
    assertEquals(palette.get(2), 0x333333);
    assertEquals(barPlot.getXAxisLabel().getText(), "xAxis");
    assertEquals(barPlot.getXAxisLabel().getColor(), 0x192837);
    assertEquals(barPlot.getXAxisLabel().getFontFamily(), "san-serif");
    assertEquals(barPlot.getXAxisLabel().getFontSize(), 10);
    assertEquals(barPlot.getXAxisLabel().getFontStyle(), FontStyle.NORMAL);
    assertEquals(barPlot.getXAxisLabel().getFontWeight(), FontWeight.NORMAL);
    assertEquals(barPlot.getYAxisLabel().getText(), "yAxis");
    assertEquals(barPlot.getYAxisLabel().getColor(), 0x192837);
    assertEquals(barPlot.getYAxisLabel().getFontFamily(), "san-serif");
    assertEquals(barPlot.getYAxisLabel().getFontSize(), 12);
    assertEquals(barPlot.getYAxisLabel().getFontStyle(), FontStyle.OBLIQUE);
    assertEquals(barPlot.getYAxisLabel().getFontWeight(), FontWeight.BOLD);    
  }
  
  @Test
  public void testLinePlot(){
    
    ChartModel chartModel = new ChartModel();
    chartModel.setTheme(ChartTheme.THEME4);
    chartModel.setBackground(0x343434);
    chartModel.setBorderColor(0x987654);
    chartModel.setBorderVisible(true);
    chartModel.getTitle().setText("Chart Title");
    chartModel.getTitle().setColor(0x123456);
    chartModel.getTitle().setFont("monospace", 20, FontStyle.OBLIQUE, FontWeight.BOLD);
    chartModel.getLegend().setVisible(true);
    chartModel.getLegend().setBorderColor(0x654321);
    chartModel.getLegend().setBorderVisible(true);
    chartModel.getLegend().setBorderWidth(2);
    chartModel.getLegend().setFont("verdana", 18, FontStyle.ITALIC, FontWeight.BOLD);
    
    LinePlot linePlot = new LinePlot();
    linePlot.setBackground(0x765890);
    linePlot.setFlavor(LinePlotFlavor.THREED);
    linePlot.setOpacity(0.75f);
    linePlot.setPalette(new Palette(0x001111, 0x222222, 0x333333));
    linePlot.getXAxisLabel().setText("xAxis");
    linePlot.getXAxisLabel().setColor(0x192837);
    linePlot.getXAxisLabel().setFont("san-serif", 10, FontStyle.NORMAL, FontWeight.NORMAL);
    linePlot.getYAxisLabel().setText("yAxis");
    linePlot.getYAxisLabel().setColor(0x192837);
    linePlot.getYAxisLabel().setFont("san-serif", 12, FontStyle.OBLIQUE, FontWeight.BOLD);
    
    chartModel.setPlot(linePlot);
    
    
    String result = ChartSerializer.serialize(chartModel, ChartSerializationFormat.XML);
    
    System.out.println(result);
    
    ChartModel chartModel2 = ChartSerializer.deSerialize(result, ChartSerializationFormat.XML);
    assertEquals(chartModel2.getTheme(), ChartTheme.THEME4);
    assertEquals(chartModel2.getBackground(), new Integer(0x343434));
    assertTrue(chartModel2.getBorderVisible());
    assertEquals(chartModel2.getBorderColor(), new Integer(0x987654));
    assertEquals(chartModel2.getBorderWidth(), new Integer(1));
    assertEquals(chartModel2.getTitle().getText(), "Chart Title");
    assertEquals(chartModel2.getTitle().getColor(), 0x123456);
    assertEquals(chartModel2.getTitle().getFontFamily(), "monospace");
    assertEquals(chartModel2.getTitle().getFontSize(), new Integer(20));
    assertEquals(chartModel2.getTitle().getFontStyle(), FontStyle.OBLIQUE);
    assertEquals(chartModel2.getTitle().getFontWeight(), FontWeight.BOLD);
    assertTrue(chartModel2.getLegend().getVisible());
    assertTrue(chartModel2.getLegend().getBorderVisible());
    assertEquals(chartModel2.getLegend().getBorderWidth(), 2);
    assertEquals(chartModel2.getLegend().getFontFamily(), "verdana");
    assertEquals(chartModel2.getLegend().getFontSize(), new Integer(18));
    assertEquals(chartModel2.getLegend().getFontStyle(), FontStyle.ITALIC);
    assertEquals(chartModel2.getLegend().getFontWeight(), FontWeight.BOLD);
    
    assertTrue(chartModel2.getPlot() instanceof LinePlot);    
    linePlot = (LinePlot)chartModel2.getPlot();
    assertEquals(linePlot.getBackground(), new Integer(0x765890));
    assertEquals(linePlot.getFlavor(), LinePlotFlavor.THREED);
    assertEquals(linePlot.getOpacity(), new Float(0.75));
    Palette palette = chartModel2.getPlot().getPalette();
    assertEquals(palette.size(), 3);
    assertEquals(palette.get(0), 0x001111);
    assertEquals(palette.get(1), 0x222222);
    assertEquals(palette.get(2), 0x333333);
    assertEquals(linePlot.getXAxisLabel().getText(), "xAxis");
    assertEquals(linePlot.getXAxisLabel().getColor(), 0x192837);
    assertEquals(linePlot.getXAxisLabel().getFontFamily(), "san-serif");
    assertEquals(linePlot.getXAxisLabel().getFontSize(), 10);
    assertEquals(linePlot.getXAxisLabel().getFontStyle(), FontStyle.NORMAL);
    assertEquals(linePlot.getXAxisLabel().getFontWeight(), FontWeight.NORMAL);
    assertEquals(linePlot.getYAxisLabel().getText(), "yAxis");
    assertEquals(linePlot.getYAxisLabel().getColor(), 0x192837);
    assertEquals(linePlot.getYAxisLabel().getFontFamily(), "san-serif");
    assertEquals(linePlot.getYAxisLabel().getFontSize(), 12);
    assertEquals(linePlot.getYAxisLabel().getFontStyle(), FontStyle.OBLIQUE);
    assertEquals(linePlot.getYAxisLabel().getFontWeight(), FontWeight.BOLD);    
  }
  
  @Test
  public void testAreaPlot(){
    
    ChartModel chartModel = new ChartModel();
    chartModel.setTheme(ChartTheme.THEME4);
    chartModel.setBackground(0x343434);
    chartModel.setBorderColor(0x987654);
    chartModel.setBorderVisible(true);
    chartModel.getTitle().setText("Chart Title");
    chartModel.getTitle().setColor(0x123456);
    chartModel.getTitle().setFont("monospace", 20, FontStyle.OBLIQUE, FontWeight.BOLD);
    chartModel.getLegend().setVisible(true);
    chartModel.getLegend().setBorderColor(0x654321);
    chartModel.getLegend().setBorderVisible(true);
    chartModel.getLegend().setBorderWidth(2);
    chartModel.getLegend().setFont("verdana", 18, FontStyle.ITALIC, FontWeight.BOLD);
    
    AreaPlot areaPlot = new AreaPlot();
    areaPlot.setBackground(0x765890);
    areaPlot.setOpacity(0.75f);
    areaPlot.setPalette(new Palette(0x001111, 0x222222, 0x333333));
    areaPlot.getXAxisLabel().setText("xAxis");
    areaPlot.getXAxisLabel().setColor(0x192837);
    areaPlot.getXAxisLabel().setFont("san-serif", 10, FontStyle.NORMAL, FontWeight.NORMAL);
    areaPlot.getYAxisLabel().setText("yAxis");
    areaPlot.getYAxisLabel().setColor(0x192837);
    areaPlot.getYAxisLabel().setFont("san-serif", 12, FontStyle.OBLIQUE, FontWeight.BOLD);
    
    chartModel.setPlot(areaPlot);
    
    
    String result = ChartSerializer.serialize(chartModel, ChartSerializationFormat.XML);
    
    System.out.println(result);
    
    ChartModel chartModel2 = ChartSerializer.deSerialize(result, ChartSerializationFormat.XML);
    assertEquals(chartModel2.getTheme(), ChartTheme.THEME4);
    assertEquals(chartModel2.getBackground(), new Integer(0x343434));
    assertTrue(chartModel2.getBorderVisible());
    assertEquals(chartModel2.getBorderColor(), new Integer(0x987654));
    assertEquals(chartModel2.getBorderWidth(), new Integer(1));
    assertEquals(chartModel2.getTitle().getText(), "Chart Title");
    assertEquals(chartModel2.getTitle().getColor(), 0x123456);
    assertEquals(chartModel2.getTitle().getFontFamily(), "monospace");
    assertEquals(chartModel2.getTitle().getFontSize(), new Integer(20));
    assertEquals(chartModel2.getTitle().getFontStyle(), FontStyle.OBLIQUE);
    assertEquals(chartModel2.getTitle().getFontWeight(), FontWeight.BOLD);
    assertTrue(chartModel2.getLegend().getVisible());
    assertTrue(chartModel2.getLegend().getBorderVisible());
    assertEquals(chartModel2.getLegend().getBorderWidth(), 2);
    assertEquals(chartModel2.getLegend().getFontFamily(), "verdana");
    assertEquals(chartModel2.getLegend().getFontSize(), new Integer(18));
    assertEquals(chartModel2.getLegend().getFontStyle(), FontStyle.ITALIC);
    assertEquals(chartModel2.getLegend().getFontWeight(), FontWeight.BOLD);
    
    assertTrue(chartModel2.getPlot() instanceof AreaPlot);    
    areaPlot = (AreaPlot)chartModel2.getPlot();
    assertEquals(areaPlot.getBackground(), new Integer(0x765890));
    assertEquals(areaPlot.getOpacity(), new Float(0.75));
    Palette palette = chartModel2.getPlot().getPalette();
    assertEquals(palette.size(), 3);
    assertEquals(palette.get(0), 0x001111);
    assertEquals(palette.get(1), 0x222222);
    assertEquals(palette.get(2), 0x333333);
    assertEquals(areaPlot.getXAxisLabel().getText(), "xAxis");
    assertEquals(areaPlot.getXAxisLabel().getColor(), 0x192837);
    assertEquals(areaPlot.getXAxisLabel().getFontFamily(), "san-serif");
    assertEquals(areaPlot.getXAxisLabel().getFontSize(), 10);
    assertEquals(areaPlot.getXAxisLabel().getFontStyle(), FontStyle.NORMAL);
    assertEquals(areaPlot.getXAxisLabel().getFontWeight(), FontWeight.NORMAL);
    assertEquals(areaPlot.getYAxisLabel().getText(), "yAxis");
    assertEquals(areaPlot.getYAxisLabel().getColor(), 0x192837);
    assertEquals(areaPlot.getYAxisLabel().getFontFamily(), "san-serif");
    assertEquals(areaPlot.getYAxisLabel().getFontSize(), 12);
    assertEquals(areaPlot.getYAxisLabel().getFontStyle(), FontStyle.OBLIQUE);
    assertEquals(areaPlot.getYAxisLabel().getFontWeight(), FontWeight.BOLD);    
  }
  
  @Test
  public void testPiePlot(){
    
    ChartModel chartModel = new ChartModel();
    chartModel.setTheme(ChartTheme.THEME4);
    chartModel.setBackground(0x343434);
    chartModel.setBorderColor(0x987654);
    chartModel.setBorderVisible(true);
    chartModel.getTitle().setText("Chart Title");
    chartModel.getTitle().setColor(0x123456);
    chartModel.getTitle().setFont("monospace", 20, FontStyle.OBLIQUE, FontWeight.BOLD);
    chartModel.getLegend().setVisible(true);
    chartModel.getLegend().setBorderColor(0x654321);
    chartModel.getLegend().setBorderVisible(true);
    chartModel.getLegend().setBorderWidth(2);
    chartModel.getLegend().setFont("verdana", 18, FontStyle.ITALIC, FontWeight.BOLD);
    
    PiePlot piePlot = new PiePlot();
    piePlot.setBackground(0x765890);
    piePlot.setStartAngle(65);
    piePlot.setOpacity(0.75f);
    piePlot.setPalette(new Palette(0x001111, 0x222222, 0x333333));
    piePlot.setAnimate(true);
    
    chartModel.setPlot(piePlot);
    
    String result = ChartSerializer.serialize(chartModel, ChartSerializationFormat.XML);
    
    System.out.println(result);
    
    ChartModel chartModel2 = ChartSerializer.deSerialize(result, ChartSerializationFormat.XML);
    assertEquals(chartModel2.getTheme(), ChartTheme.THEME4);
    assertEquals(chartModel2.getBackground(), new Integer(0x343434));
    assertTrue(chartModel2.getBorderVisible());
    assertEquals(chartModel2.getBorderColor(), new Integer(0x987654));
    assertEquals(chartModel2.getBorderWidth(), new Integer(1));
    assertEquals(chartModel2.getTitle().getText(), "Chart Title");
    assertEquals(chartModel2.getTitle().getColor(), 0x123456);
    assertEquals(chartModel2.getTitle().getFontFamily(), "monospace");
    assertEquals(chartModel2.getTitle().getFontSize(), new Integer(20));
    assertEquals(chartModel2.getTitle().getFontStyle(), FontStyle.OBLIQUE);
    assertEquals(chartModel2.getTitle().getFontWeight(), FontWeight.BOLD);
    assertTrue(chartModel2.getLegend().getVisible());
    assertTrue(chartModel2.getLegend().getBorderVisible());
    assertEquals(chartModel2.getLegend().getBorderWidth(), 2);
    assertEquals(chartModel2.getLegend().getFontFamily(), "verdana");
    assertEquals(chartModel2.getLegend().getFontSize(), new Integer(18));
    assertEquals(chartModel2.getLegend().getFontStyle(), FontStyle.ITALIC);
    assertEquals(chartModel2.getLegend().getFontWeight(), FontWeight.BOLD);
    
    assertTrue(chartModel2.getPlot() instanceof PiePlot);    
    piePlot = (PiePlot)chartModel2.getPlot();
    assertEquals(piePlot.getBackground(), new Integer(0x765890));
    assertEquals(piePlot.getOpacity(), new Float(0.75));
    Palette palette = chartModel2.getPlot().getPalette();
    assertEquals(palette.size(), 3);
    assertEquals(palette.get(0), 0x001111);
    assertEquals(palette.get(1), 0x222222);
    assertEquals(palette.get(2), 0x333333);
    assertEquals(piePlot.getStartAngle(), 65);
    assertTrue(piePlot.getAnimate());
  }
}