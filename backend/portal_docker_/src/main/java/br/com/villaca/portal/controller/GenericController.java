package br.com.villaca.portal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class GenericController<T, ID> {

    @Autowired
    CrudRepository<T, ID> repository;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public ResponseEntity<List<T>> listar(){
        return ResponseEntity.ok((List<T>) repository.findAll());
    }

    @RequestMapping(value = "listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<T> getById(@PathVariable(value = "id") ID id){
        Optional<T> object = repository.findById(id);
        if(object.isPresent()){
            return new ResponseEntity<>(object.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "novo", method = RequestMethod.POST)
    public ResponseEntity<T> novo(@RequestBody T object){
        return new ResponseEntity<>(repository.save(object), HttpStatus.OK);
    }

    @RequestMapping(value = "atualizar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<T> atualizar(@PathVariable(value="id") ID id, @RequestBody T newObject){
        Optional<T> object = repository.findById(id);
        if(object.isPresent()){
            return new ResponseEntity<>(repository.save(newObject), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "remover/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<T> remover(@PathVariable(value="id") ID id){
        Optional<T> object = repository.findById(id);
        if(object.isPresent()){
            repository.delete(object.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}