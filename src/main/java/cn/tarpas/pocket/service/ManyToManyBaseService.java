package cn.tarpas.pocket.service;

import java.util.List;


public interface ManyToManyBaseService<T, F, S> extends BaseService<T> {


    public int deleteByFirstId(int firstId);

    public int deleteBySecondId(int secondId);

    public List<F> selectFirstListBySecondId(int secondId);

    public F selectFirstOneBySecondId(int secondId);

    public List<S> selectSecondListByFirstId(int firstId);

    public S selectSecondOneByFirstId(int firstId);


}
