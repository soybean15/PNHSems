/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pagination.listener;

import java.awt.Color;
import javax.swing.JLabel;
import pagination.event.PaginationEvent;

/**
 *
 * @author root
 */
public interface PaginationMouseListener {

    default void onSelected(PaginationEvent e) {
        e.getButton().setBackground(Color.BLUE);
        e.getButton().setForeground(Color.white);

    }

    ;
    default void onUnselected(PaginationEvent e) {
        e.getButton().setBackground(Color.white);
        e.getButton().setForeground(Color.black);
    }

    public void onClick(PaginationEvent e);

}
