/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.entities;

import dao.entity.BankingEntity;
import dao.entity.UserEntity;
import exceptions.BankingInvalidException;
import java.util.List;

/**
 *
 * @author Charles
 */
public interface BankingService {
    public BankingEntity find(String id);
    public List<BankingEntity> findAll();
    public void save(BankingEntity u) throws BankingInvalidException;
    public void update(BankingEntity entity) throws BankingInvalidException;
    public void delete(BankingEntity entity);
}
