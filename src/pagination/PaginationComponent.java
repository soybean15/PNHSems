/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagination;

import java.awt.Color;
import java.awt.Cursor;
import pagination.listener.CustomComponentListener;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pagination.event.PaginationEvent;
import pagination.listener.PaginationMouseListener;

/**
 *
 * @author root
 */

class PaginationComponent{
   
    private final JLabel NEXT = new JLabel(">");
    private final JLabel PREVIOUS = new JLabel("<");
    JPanel container =new JPanel();
    JLabel next;
    JLabel previous;
    
    JLabel selectedPage;
    
    private int numberOfPageToShow;
    JLabel[] pageButtons;
    Consumer<JLabel> pageButton;
    
    private CustomComponentListener listener;
    private List<PaginationMouseListener> mouseListeners = new ArrayList<>();
 
    public PaginationComponent(int numberOfPageToShow) {
        this.numberOfPageToShow = numberOfPageToShow;
       
        next =getNext(">");
        previous = getPrev("<");
    }
    
    
    
    public void modify(JLabel label ,Consumer<JLabel> c){
      
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c.accept(label);
        
    }
    
    public void modifyButton(Consumer<JLabel> c){
        this.pageButton=c;
        
        for(JLabel label:pageButtons){
            modify( label ,c);
        }
    }
    
    
    
    
  
    
    
    public void addListener(CustomComponentListener listener){
        this.listener = listener;
    }
    public void addMouseListener(PaginationMouseListener mouseListener){
        mouseListeners.add(mouseListener);
    }
 
    private void createPageButton(int start, int end){
       
       
        pageButtons= new JLabel[numberOfPageToShow];
        System.out.println("start "+start +" end: "+end);
                
                
        int _start = start%numberOfPageToShow;
        int _end = end%numberOfPageToShow;
        if(_end==0){
            end = numberOfPageToShow;
        }else{
            end =_end;
        }
     
        for(int i=_start-1; i<numberOfPageToShow;i++){
            if (i < end) {
                pageButtons[i] = new JLabel(String.valueOf(i + start));

                onClick(pageButtons[i]);
                pageButtons[i].setHorizontalAlignment(JLabel.CENTER);
                pageButtons[i].setOpaque(true);
                pageButtons[i].setBackground(Color.white);
                pageButtons[i].setForeground(Color.black);
                if (pageButton != null) {
                    modify(pageButtons[i], pageButton);
                }

            } else {
                pageButtons[i] = new JLabel("");
            }
            
        }
        
       
    }
    

    private JLabel getNext(String label) {
        NEXT.setText(label);
        NEXT.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                            
                   
                    listener.onNext();
                
            
            }
        });
        return NEXT;
    }

    private JLabel getPrev(String label) {
          PREVIOUS.setText(label);
          PREVIOUS.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
                    
                    listener.onPrevious();
                
            
            }
        });
         return PREVIOUS;
    }
    


   
    
    
    
    
    public JPanel createPages( int start, int end, boolean onFirst, boolean onLast){
      container.removeAll();
      container.repaint();
      container.revalidate();
      container.setLayout(new GridLayout(0,2+numberOfPageToShow));
        
        createPageButton( start,  end);
       
        
        previous.setVisible(!onFirst);
        container.add(previous);
        for(JLabel page:pageButtons){
            
            container.add(page);
            
            
        }
        
    
        next.setVisible(!onLast);
        container.add(next);
        
        return container;
        
    }
    
    
    private void onClick(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                JLabel label = (JLabel) e.getComponent();
                PaginationEvent event = listener.onClick();
               event.setButton(label);
                for (PaginationMouseListener mouseListener : mouseListeners) {
                    if ( selectedPage!= null) {
                        event.setButton(selectedPage);
                        mouseListener.onUnselected(event);
                    }
                    selectedPage = label;
                    event.setButton(label);
                    mouseListener.onSelected(event);
                    mouseListener.onClick(event);
                  
                }

               // 

            }
        });
    }
    
//    private void onSelected(JLabel label){
//        label.setBackground(Color.BLUE);
//        label.setForeground(Color.white);
//    }
//    
//     private void onUnselected(JLabel label){
//        label.setBackground(Color.white);
//        label.setForeground(Color.black);
//    }
//    
//    
}
