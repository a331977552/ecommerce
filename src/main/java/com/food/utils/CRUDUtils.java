package com.food.utils;

import com.food.utils.BaseEntityException;
import com.food.exception.CustomerAlreadyExist;
import com.food.exception.EntityDeleteException;
import com.food.exception.NoSuchEntityException;
import com.food.exception.UpdateEntityException;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class CRUDUtils {



    public static void updateSelectively(JpaRepository repository, EntitySupporter source) throws BaseEntityException {
        if(source.getId()==null)
            throw new UpdateEntityException(source.getClass().getSimpleName()+"'s id empty","common.id.null",source.getClass().getSimpleName()+" id");
        Optional byId = repository.findById(source.getId());
        if(byId.isPresent()){
            Object target = byId.get();
            EntityUtils.copyNotNullProperties(source,target);
            repository.save(target);
        }else
        {
            throw new NoSuchEntityException("no such entity","common.entity.not.exist",source.getClass().getSimpleName()+" id "+source.getId());
        }

    }
    public static void deleteById(JpaRepository repository,Integer id) throws BaseEntityException {
        if(id==null)
        {
            Class persistentClass = getEntityName(repository);
            throw new EntityDeleteException("common.id.null",new String[]{persistentClass.getSimpleName()+" id"});
        }
        repository.deleteById(id);
    }
    public static <T> List<T> getEntityByExample(JpaRepository repository, EntitySupporter supporter) throws BaseEntityException {

        return  repository.findAll(Example.of(supporter));
    }

    public static boolean exists(JpaRepository repository,EntitySupporter example ){
       return  repository.exists(Example.of(example));
  }
    public static <T> T getOneEntityByExampleOrElseThrowNoSuch(JpaRepository repository, EntitySupporter supporter,
                                                               String message) throws BaseEntityException {
        Optional one = repository.findOne(Example.of(supporter));
        if(one.isPresent()){
            return (T) one.get();
        }else{

            throw new NoSuchEntityException("no such entity","common.entity.not.exist",message);
        }
    }
    public static void getOneEntityByExampleAndThrowIfExist(JpaRepository repository, EntitySupporter supporter,
                                                            String message) throws BaseEntityException {
        Optional one = repository.findOne(Example.of(supporter));
        if(one.isPresent()){
            throw new CustomerAlreadyExist("already exist","common.already.exist",message);
        }
    }
    public static <T> Optional<T> getOneEntityByExampleOptional(JpaRepository repository, EntitySupporter supporter) throws BaseEntityException {
        return  repository.findOne(Example.of(supporter));

    }

    public static <T> T  getEntityById(JpaRepository repository,Integer id) throws BaseEntityException {
        Optional byId = repository.findById(id);
        if(byId.isPresent()){
            return (T) byId.get();
        }else{
            Class persistentClass = getEntityName(repository);
            throw new NoSuchEntityException("no such entity","common.entity.not.exist",persistentClass.getSimpleName()+" id "+id);
        }

    }
    public static <T>  Optional<T>  findEntityById(JpaRepository repository,Integer id) throws BaseEntityException {
        Optional<T> byId = repository.findById(id);
        return byId;
    }
    private static Class getEntityName(JpaRepository repository) {
        Type[] genericSuperclass2 = repository.getClass()
                .getGenericInterfaces();
        Type[] genericInterfaces = ((Class) genericSuperclass2[0]).getGenericInterfaces();
        return (Class) ((ParameterizedType)genericInterfaces[0]).getActualTypeArguments()[0];
    }


    public static  long count(JpaRepository repository, EntitySupporter example) {
        if(example==null)
            return repository.count();
        return repository.count(Example.of(example));
    }

    public static <T> List<T> findAll(JpaRepository repository) {
        return repository.findAll();
    }

    public static void update(JpaRepository repository, EntitySupporter source) {
        if(source.getId()==null)
            throw new UpdateEntityException(source.getClass().getSimpleName()+"'s id empty","common.id.null",source.getClass().getSimpleName()+" id");

        boolean byId = repository.existsById(source.getId());
        if(byId){
            repository.save(source);
        }else
        {
            throw new NoSuchEntityException("no such entity","common.entity.not.exist",source.getClass().getSimpleName()+" id "+source.getId());
        }
    }
}
