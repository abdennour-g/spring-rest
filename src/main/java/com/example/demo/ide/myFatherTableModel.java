package com.example.demo.ide;


import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

public abstract class myFatherTableModel extends AbstractTableModel {
    protected String[]   tHead;
    protected Object[][] tBody;
    protected int        row;
    protected boolean    edit = false;
    public myFatherTableModel() {
        super();
    }

    public myFatherTableModel( String[] tHead, Object[][] tBody ) {
        super();
        this.tHead = tHead;
        this.tBody = tBody;
    }
    @Override
    public int getRowCount() {
        int i = -1;
        try {
            i = this.tBody.length;
        } catch ( Exception errrr ) {
        }
        return i;
    }

    @Override
    public int getColumnCount() {
        return this.tHead.length;
    }

    @Override
    public Object getValueAt( int row, int col ) {
        Object o = null;
        String m = "";
        try {
            m = ( row == -1 || col < 0 ) ? "" : (String) this.tBody[row][col];
            if ( row > -1 && !m.equals( "" ) )
                m = m.charAt( 0 ) != ' ' ? " " + m.toUpperCase() : m.toUpperCase();
            o = " " + m;
        } catch ( Exception e ) {
            o = "";
        }
        return o;
    }

    @Override
    public String getColumnName( int col ) {
        return tHead[col].toUpperCase();
    }

    @Override
    public Class getColumnClass( int c ) {
        Class cl = this.row == -1 ? ( new JLabel().getClass() ) : getValueAt( 0, c ).getClass();
        return cl;
    }

    @Override
    public boolean isCellEditable( int row, int col ) {
        this.row = row;
        return edit;
    }



    @Override
    public void setValueAt( Object value, int row, int col ) {
        this.row = row;
        this.tBody[row][col] = value;
        fireTableCellUpdated( row, col );

    }


}
