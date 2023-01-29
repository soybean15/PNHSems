/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagination;

import java.awt.Color;
import pagination.listener.CustomComponentListener;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public class PaginationHandler implements CustomComponentListener {

    private final Pagination PAGINATION;



    private final PaginationComponent COMPONENT;

    public PaginationHandler(int set, int totalItems, int numberOfPageToShow) {

        this.PAGINATION = new Pagination(set, totalItems,numberOfPageToShow);
        COMPONENT = new PaginationComponent(numberOfPageToShow < 5 ? 5 : numberOfPageToShow);

        addListener();

    }

    private void addListener() {
        COMPONENT.addListener(this);
    }

    public JPanel createPageButtons() {

      return COMPONENT.createPages(
                PAGINATION.start(),
                PAGINATION.end(),
                PAGINATION.onFirst(),
                PAGINATION.onLast(),
                jLabel -> {
                    jLabel.setBackground(Color.white);
                    jLabel.setOpaque(true);
                    jLabel.setForeground(Color.red);

                });
    }

    private void loadPages() {
        COMPONENT.createPages(
                PAGINATION.start(),
                PAGINATION.end(),
                PAGINATION.onFirst(),
                PAGINATION.onLast(),
                jLabel -> {
                    jLabel.setBackground(Color.white);
                    jLabel.setOpaque(true);
                    jLabel.setForeground(Color.red);

                });
    }

    @Override
    public void onClick(int index) {
        PAGINATION.onClick(index);
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

}
