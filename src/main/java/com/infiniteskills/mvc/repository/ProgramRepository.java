/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Program;
import java.util.List;

/**
 *
 * @author Соколов
 */
public interface ProgramRepository {

    List<Program> findAll();

    List<Program> findAllWithDetails();

    Program save(Program post);

    void delete(Program post);

    Program update(Program prog);

    Program create(Program prog);

}
