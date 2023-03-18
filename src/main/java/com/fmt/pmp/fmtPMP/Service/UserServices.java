package com.fmt.pmp.fmtPMP.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fmt.pmp.fmtPMP.DAO.UserRepository;
import com.fmt.pmp.fmtPMP.Model.User;
 
@Service
@Transactional
public class UserServices {
     
    @Autowired
    private UserRepository repo;
     
    public List<User> listAll() {
        return repo.findAll(Sort.by("email").ascending());
    }
     
}