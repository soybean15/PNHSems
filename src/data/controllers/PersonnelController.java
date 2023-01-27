/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.controllers;

import data.model.Personnel;
import data.services.impl.PersonnelService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author root
 */
public class PersonnelController {

    PersonnelService service = new PersonnelService();

    public int addPersonnels() throws SQLException {
        return service.addPersonnels();
    }

    public List<Personnel> getPersonnels() throws SQLException {
        return service.getPersonnels();
    }

    public int updatePersonnel(Personnel personnel) throws SQLException {
        return service.updatePersonnel(personnel);
    }

}
