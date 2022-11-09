/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package frames.listener;

import data.model.ServiceCredit;
import frames.components.ServiceCreditItem;

/**
 *
 * @author root
 */
public interface ServiceCreditItemListener {
    
    public void setDetails(ServiceCredit serviceCredit);
    public void onItemSelected(ServiceCreditItem serviceCreditItem);
    
}
