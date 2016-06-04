/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Otpusk;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface OtpuskRepository {
     List<Otpusk> findAll();
     Otpusk update( Otpusk pit);
     Otpusk create( Otpusk pit);
     List< Otpusk> findAllWithDetails();
     Otpusk save( Otpusk pit);
     void delete( Otpusk pit);
}
