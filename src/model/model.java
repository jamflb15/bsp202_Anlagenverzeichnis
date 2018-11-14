/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Anlage.Anlage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author floha
 */
public class model extends AbstractTableModel{

    private List<Anlage> list = new ArrayList<>();
    public static final String[] colNames = {"Bezeichnung","AK","Inbetriebnahme","ND","bish. ND","AfA bisher","Wert vor AfA","AfA d.J.","BW 31.12"};

    
    public void add(Anlage a ){
        list.add(a);
    }
    
    public void del(int index){
        list.remove(index);
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return colNames.length;
    }
    
    @Override
    public Object getValueAt(int row, int col){
        Anlage a = list.get(row);
        return a;
    }
    
    @Override
    public String getColumnName(int col){
        return colNames[col];
    }
    
    public static ArrayList<Anlage> readAnlageDaten(String file) {
        BufferedReader in = null;
        FileReader fr = null;
        ArrayList<Anlage> end = new ArrayList<Anlage>();
        try {
            fr = new FileReader(file);
            in = new BufferedReader(fr);
            in.readLine();
            String line;
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split(";");
                if (tokens.length > 0) {
                    end.add(new Anlage(
                            tokens[0].trim(),
                            Integer.parseInt(tokens[1].trim().replace(".", "")),
                            Float.parseFloat(tokens[2].trim().replace(",", ".")),
                            Float.parseFloat(tokens[3].trim()),
                            Float.parseFloat(tokens[4].trim()),
                            Float.parseFloat(tokens[5].trim()),
                            Float.parseFloat(tokens[6].trim()),
                            Float.parseFloat(tokens[7].trim()),
                            Float.parseFloat(tokens[8].trim())));
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Datei " + file + " wurde nicht gefunden. ", "Warnung", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Lesen von Datei " + file + ". ", "Fehler", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Fehler beim Schließen der Datei " + file + ". ", "Fehler ", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }   
        return end;
    }
    
    public static void main(String[] args) {
        model m = new model();
        ArrayList neu = new ArrayList();
        neu = model.readWetterDaten("anlagenverzeichnis.csv");
        System.out.println(neu.toString());
    }
}
