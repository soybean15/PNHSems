/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frames.components;

import data.model.LeaveType;

import javax.swing.JRadioButton;

/**
 *
 * @author root
 */
public class LeaveTypeRadioButton extends JRadioButton   {
    private LeaveType leaveType;


    public LeaveTypeRadioButton( LeaveType leaveType){
        this.leaveType = leaveType;
        
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }
    public int getId(){
        return leaveType.getId();
    }


    

}


