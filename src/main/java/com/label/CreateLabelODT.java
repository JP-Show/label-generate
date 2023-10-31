package com.label;

import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.doc.OdfTextDocument;

public class CreateLabelODT {
  static String path = "";

  public static void createDocumentLabel() throws Exception {
    OdfTextDocument otd = (OdfTextDocument) OdfDocument.loadDocument(path + "\\model.odt");
  }
}