
package first;

import java.util.List;

public class ResponseClass {
    private int columnCount;
    private List<String> tables;
    private List<String> columnNames;
    private List<List<String>> columnData;

    public ResponseClass() {
    }

    public ResponseClass(int columnCount,List<String> tables, List<String> columnNames, List<List<String>> columnData) {
        this.columnCount = columnCount;
        this.tables = tables;
        this.columnNames = columnNames;
        this.columnData = columnData;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    public List<List<String>> getColumnData() {
        return columnData;
    }

    public void setColumnData(List<List<String>> columnData) {
        this.columnData = columnData;
    }

    public List<String> getTables() {
        return tables;
    }

    public void setTables(List<String> tables) {
        this.tables = tables;
    }
    
    
    
}
