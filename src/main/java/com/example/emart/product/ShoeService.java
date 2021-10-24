package com.example.emart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoeService {
 @Autowired ShoeRepository repo;

    public List<Shoe> listAll(){
        return (List<Shoe>) repo.findAll();
    }

    public void save(Shoe shoe) {
        repo.save(shoe);

    }

    public Shoe get(Integer id) throws ShoeNotFoundException {
        Optional<Shoe> shoe = repo.findById(id);
        if (shoe.isPresent()){
            return shoe.get();
        }
        throw new ShoeNotFoundException("Could not find shoe with given id" +id);
    }

    public void delete(Integer id) throws ShoeNotFoundException {
        Long count = repo.countById(id);
        if(count== null || count ==0){
            throw new ShoeNotFoundException("Could not find shoe with given id" +id);
        }
        repo.deleteById(id);
    }

}
