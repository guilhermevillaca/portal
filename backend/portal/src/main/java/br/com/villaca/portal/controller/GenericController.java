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

public class GenericController<T, ID> {

    @Autowired
    CrudRepository<T, ID> repository;

    @RequestMapping(value = "listar")
    public ResponseEntity<List<T>> listar(){
        return ResponseEntity.ok((List<T>) repository.findAll());
    }

    @RequestMapping(value = "listar/{id}")
    public ResponseEntity<T> getById(@PathVariable(value = "id") ID id){
        Optional<T> object = repository.findById(id);
        if(object.isPresent()){
            return new ResponseEntity<>(object.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "novo")
    public ResponseEntity<T> novo(@RequestBody T object){
        return new ResponseEntity<T>(repository.save(object), HttpStatus.OK);
    }

    @RequestMapping(value = "atualizar/{id}")
    public ResponseEntity<T> atualizar(@PathVariable(value="id") ID id, @RequestBody T newObject){
        Optional<T> object = repository.findById(id);
        if(object.isPresent()){
            return new ResponseEntity<T>(repository.save(newObject), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "remover/{id}")
    public ResponseEntity<T> remover(@PathVariable(value="id") ID id, @RequestBody T removeObject){
        Optional<T> object = repository.findById(id);
        if(object.isPresent()){
            repository.delete(removeObject);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}