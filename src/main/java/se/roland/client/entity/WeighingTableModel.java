package se.roland.client.entity;

import ru.com.avs.scales.common.Weighing;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class WeighingTableModel extends AbstractTableModel{
    
    public final String ID_COLUMN = "Номер";
    
    String[] columnNames = {
        ID_COLUMN,
        "Распознан",
        "Дата",
        "Металл",
        "Брутто",
        "Тара",
        "Нетто",
        "Итог",    
        "Сорность",
        "Примеси",
        "Марка машины",
        "Накладная",
        "Переброска",
    };
    
    Object[][] data;
    
    public WeighingTableModel(List<Weighing> weighings){
        data = new Object[weighings.size()][];
        int i = 0;
        for (Weighing w : weighings) {
            Object[] item = {
                w,
                w.getRecPlate(),
                w.getDate(),
                w.getMetal(),
                w.getBrutto(),
                w.getTare(),
                w.getNetto(),
                w.getResult(),
                w.getSor(),
                w.getTrash(),
                w.getCar(),
                w.getWaybill(),
                w.isTransfer()
            };
            data[i] = item;
            i++;
        }
    }
    
    @Override
    public Class getColumnClass(int column) {
        if(data.length == 0){
            return null;
        }
        if(getValueAt(0, column) == null){
            return Object.class;
        }
        return (getValueAt(0, column).getClass());
    }
    
    @Override
    public String getColumnName(int column) {
        if(data.length == 0){
            return null;
        }
        return columnNames[column];
    }
    
    @Override
    public int getRowCount() {
        if(data.length == 0){
            return 0;
        }
        return data.length;
    }

    @Override
    public int getColumnCount() {
        if(data.length == 0){
            return 0;
        }
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(data.length == 0){
            return null;
        }
        return data[rowIndex][columnIndex];
    }
    
    public Weighing getValueAt(int rowIndex, String columnName) {
        if(data.length == 0){
            return null;
        }
        return (Weighing)data[rowIndex][findColumn(columnName)];
    }
    
}
