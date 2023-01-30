/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagination.event;

import javax.swing.JLabel;
import pagination.Pagination;

/**
 *
 * @author root
 */
public class PaginationEvent {
        
    private int start;
    private int end;

    private int currentPage = 1;
    private int offSet;

    
    private final Pagination pagination;
    private JLabel button;

    public PaginationEvent(Pagination pagination) {
        this.pagination = pagination;
    }

    
    public int getSet(){
        return pagination.getSet();
    }

    public int getCurrentPage() {
        return pagination.getCurrent();
    }
    
    public int getTotalPage(){
        return pagination.getNumberOfPages();
    }

    public int getOffSet() {
        try{
             return (Integer.parseInt(button.getText())-1)*getSet();
        }catch(Exception e){
           return 0;
        }
       
        
             
        
       
    }

    public int getLimit() {
        return pagination.getLimit();
    }

    public Pagination getPagination() {
        return pagination;
    }
    
    public int startIndex(){
        return getOffSet();
    }
    public int endIndex(){
         return (pagination.getLimit()+  getOffSet())-1;
    }

    public JLabel getButton() {
        return button;
    }
    
    
    public void setButton(JLabel label) {
        this.button = label;
    }
    
    
    
    
}
