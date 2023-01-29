/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagination;

import pagination.listener.CustomComponentListener;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

    public PaginationComponent(int numberOfPageToShow) {
        this.numberOfPageToShow = numberOfPageToShow;
       
        next =getNext(">");
        previous = getPrev("<");
    }
    
    
    public void modifyButton(JLabel label ,Consumer<JLabel> c){
        c.accept(label);
    }
    
    
    
    private List<CustomComponentListener> listeners = new ArrayList<>();
    
    
    public void addListener(CustomComponentListener listener){
        listeners.add(listener);
    }
 
    private void createPageButton(int start, int end,Consumer<JLabel> c){
      
       
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
           if( i < end){
                pageButtons[i]=new JLabel(String.valueOf(i+start));
                modifyButton(pageButtons[i], c);
                addPageListener( pageButtons[i]);
               
            }else{
                 pageButtons[i]= new JLabel("");
            }
            
        }
        
       
    }
    

    private JLabel getNext(String label) {
        NEXT.setText(label);
        NEXT.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
                for(CustomComponentListener listener:listeners){
                   
                    listener.onNext();
                }
            
            }
        });
        return NEXT;
    }

    private JLabel getPrev(String label) {
          PREVIOUS.setText(label);
          PREVIOUS.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                for(CustomComponentListener listener:listeners){
                    
                    
                    listener.onPrevious();
                }
            
            }
        });
         return PREVIOUS;
    }

   
    
    
    
    
    public JPanel createPages( int start, int end, boolean onFirst, boolean onLast,Consumer<JLabel> c){
      container.removeAll();
      container.repaint();
      container.revalidate();
        container.setLayout(new GridLayout(0,2+numberOfPageToShow));
        
        createPageButton( start,  end,c);
       
        
        previous.setVisible(!onFirst);
        container.add(previous);
        for(JLabel page:pageButtons){
            
            container.add(page);
            
            
        }
        
    
        next.setVisible(!onLast);
        container.add(next);
        
        return container;
        
    }
    
    
    private void addPageListener(JLabel label){
        label.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
            
                
                for(CustomComponentListener listener:listeners){
                    JLabel label = (JLabel)e.getComponent();
                    listener.onClick(Integer.parseInt(label.getText()));
                }
            
            }
        });
    }
    
    
}
