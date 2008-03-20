/*
 * Copyright 2007 Pentaho Corporation.  All rights reserved. 
 * This software was developed by Pentaho Corporation and is provided under the terms 
 * of the Mozilla Public License, Version 1.1, or any later version. You may not use 
 * this file except in compliance with the license. If you need a copy of the license, 
 * please go to http://www.mozilla.org/MPL/MPL-1.1.txt. The Original Code is the Pentaho 
 * BI Platform.  The Initial Developer is Pentaho Corporation.
 *
 * Software distributed under the Mozilla Public License is distributed on an "AS IS" 
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or  implied. Please refer to 
 * the license for the specific language governing your rights and limitations.
 *
 * Created 3/13/2008 
 * @author David Kincade 
 */
package org.pentaho.experimental.chart.css.keys;

import org.pentaho.reporting.libraries.css.model.StyleKey;
import org.pentaho.reporting.libraries.css.model.StyleKeyRegistry;

/**
 * Defines all the charting specific style keys
 *
 * @author David Kincade, Ravi Hasija
 */
public class ChartStyleKeys {

  /**
   * The chart type: bar, line, pie etc.
   */
  public static final StyleKey CHART_TYPE = StyleKeyRegistry.getRegistry().
      createKey("-x-pentaho-chart-series-type", false, true, StyleKey.All_ELEMENTS); //$NON-NLS-1$

  /**
   * "true" if the chart is categorical, "false" if value based.
   */ 
  public static final StyleKey CATEGORICAL = StyleKeyRegistry.getRegistry().
      createKey("-x-pentaho-chart-categorical", false, true, StyleKey.All_ELEMENTS); //$NON-NLS-1$

  /**
   * The orientation of the charts: vertical or horizontal.
   */
  public static final StyleKey ORIENTATION = StyleKeyRegistry.getRegistry().
      createKey("-x-pentaho-chart-orientation", false, true, StyleKey.All_ELEMENTS); //$NON-NLS-1$

  /**
   * The line style for line charts (solid, dashed, etc.)
   */
  public static final StyleKey LINE_STYLE = StyleKeyRegistry.getRegistry().
      createKey("-x-pentaho-chart-line-style", false, true, StyleKey.All_ELEMENTS); //$NON-NLS-1$

  /**
   * The bar style for bar charts (bar, cylinder, stacked, etc.)
   */
  public static final StyleKey BAR_STYLE = StyleKeyRegistry.getRegistry().
      createKey("-x-pentaho-chart-bar-style", false, true, StyleKey.All_ELEMENTS); //$NON-NLS-1$

  /**
   * Bar width specified in terms of percentage
   */ 
  public static final StyleKey BAR_MAX_WIDTH = StyleKeyRegistry.getRegistry().
      createKey("-x-pentaho-chart-bar-max-width", false, true, StyleKey.All_ELEMENTS); //$NON-NLS-1$

  /**
   * The Drill-Through URL
   */
  public static final StyleKey DRILL_URL = StyleKeyRegistry.getRegistry().
    createKey("-x-pentaho-chart-drill-url", false, true, StyleKey.All_ELEMENTS); //$NON-NLS-1$
}
