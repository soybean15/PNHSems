/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagination;

import java.util.function.Consumer;
import javax.swing.JLabel;
import pagination.listener.CustomComponentListener;
import javax.swing.JPanel;
import pagination.event.PaginationEvent;
import pagination.listener.PaginationMouseListener;

/**
 *
 * @author root
 */
public class PaginationHandler implements CustomComponentListener {

    private final Pagination PAGINATION;
    private final PaginationComponent COMPONENT;
    private JPanel CONTAINER;

    public PaginationHandler(int set, int totalItems, int numberOfPageToShow) {

        this.PAGINATION = new Pagination(set, totalItems, numberOfPageToShow);
        COMPONENT = new PaginationComponent(numberOfPageToShow < 5 ? 5 : numberOfPageToShow);

        addListener();
        createPagination();
        COMPONENT.addMouseListener(new PaginationMouseListener(){
            @Override
            public void onClick(PaginationEvent e) {
                
            }
            
        });

    }

    public void addListener() {
        COMPONENT.addListener(this);
    }
    public void addMouseListener(PaginationMouseListener listener){
         COMPONENT.addMouseListener(listener);
    }

    private void createPagination() {

        CONTAINER = COMPONENT.createPages(
                PAGINATION.start(),
                PAGINATION.end(),
                PAGINATION.onFirst(),
                PAGINATION.onLast()
        );

    }

    public JPanel getPagination() {

        return CONTAINER;

    }

    public void modifyButton(Consumer<JLabel> c) {
        COMPONENT.modifyButton(c);
    }

    @Override
    public PaginationEvent onClick() {
       return new PaginationEvent(PAGINATION);
    }

    @Override
    public void onNext() {
        PAGINATION.onNext();
        loadPages();
    }

    @Override
    public void onPrevious() {
        PAGINATION.onPrevious();
        loadPages();
    }

    private void loadPages() {
        COMPONENT.createPages(
                PAGINATION.start(),
                PAGINATION.end(),
                PAGINATION.onFirst(),
                PAGINATION.onLast()
        );
    }
    
   

}
