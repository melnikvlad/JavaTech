
package first;

import java.util.List;

public class ResponseClass {
    private int columnCount;
    private List<String> tables;
    private List<String> columnNames;
    private List<List<String>> rows;

    public ResponseClass() {
    }

    public ResponseClass(int columnCount,List<String> tables, List<String> columnNames, List<List<String>> rows) {
        this.columnCount = columnCount;
        this.tables = tables;
        this.columnNames = columnNames;
        this.rows = rows;
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

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }

   

    public List<String> getTables() {
        return tables;
    }

    public void setTables(List<String> tables) {
        this.tables = tables;
    }
    
    
    
}
