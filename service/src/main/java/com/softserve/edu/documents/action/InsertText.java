package com.softserve.edu.documents.action;

import com.softserve.edu.documents.document.Document;
import com.softserve.edu.documents.document.writer.Writer;
import com.softserve.edu.documents.options.FileParameters;
import org.apache.commons.vfs2.FileObject;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertText implements Action {
    Map<String, String> columnsNamesValues;

    @Override
    public void process(FileObject fileObject, FileParameters fileParameters)
            throws IOException {
        Document document = fileParameters.getDocument();

        Writer writer = new Writer();
        columnsNamesValues = writer.getColumnsNamesValues(document);

        InputStream inputStream = fileObject.getContent().getInputStream(); // FileInputStream?
        XWPFDocument templateDocument = new XWPFDocument(inputStream);
        inputStream.close();

        XWPFDocument newDocument = new XWPFDocument(templateDocument.getPackage());

        List<XWPFParagraph> paragraphs = newDocument.getParagraphs();

        paragraphs.
                stream().
                filter(paragraph -> !paragraph.getParagraphText().isEmpty()).
                forEach(this::setCorrectText);

        newDocument.write(fileObject.getContent().getOutputStream());
    }

    /**
     * Set the correct data for each run in the supplied paragraph
     *
     * @param sourceParagraph paragraph to copy runs from
     */
    private void setCorrectText(XWPFParagraph sourceParagraph) {
        int position = 0;

        List<XWPFRun> runs = sourceParagraph.getRuns();

        for (int i = 0; i < runs.size(); i++) {
            XWPFRun sourceRun = runs.get(i);
            String textInRun = sourceRun.getText(position);

            if (textInRun == null || textInRun.isEmpty()) {
                continue;
            }

            StringBuffer textInRunBuilder = new StringBuffer(textInRun);

            int indexOf = textInRunBuilder.indexOf("$");
            if (indexOf > -1) {
                Matcher matcher = Pattern.compile("\\$(.+?)(\\z| )").matcher(textInRunBuilder);
                List<String> allMatches = new ArrayList<>();

                while (matcher.find()) {
                    allMatches.add(matcher.group());
                }

                for (String match : allMatches) {
                    int indexOfColumn = textInRunBuilder.indexOf(match);
                    String substring = match.substring(1).trim();
                    String columnValue = columnsNamesValues.get(substring);

                    if (columnValue == null) {
                        continue;
                    }

                    textInRunBuilder.replace(
                            indexOfColumn,
                            indexOfColumn + match.length(),
                            columnValue);
                }
            }

            sourceRun.setText(textInRunBuilder.toString(), position);
        }
    }
}
