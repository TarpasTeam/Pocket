package cn.tarpas.pocket.service.im;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.tarpas.pocket.mapper.IManyToManyMapper;
import cn.tarpas.pocket.service.ManyToManyBaseService;


public class ManyToManyBaseServiceImpl<T, F, S> extends BaseServiceImpl<T>  implements ManyToManyBaseService<T, F, S> {

    @Autowired
    private IManyToManyMapper<T, F, S> manyToManyMapper;

    public int deleteByFirstId(int firstId) {
        return manyToManyMapper.deleteByFirstId(firstId);
    }

    public int deleteBySecondId(int secondId) {
        return manyToManyMapper.deleteBySecondId(secondId);
    }

    public List<F> selectFirstListBySecondId(int secondId) {
        return manyToManyMapper.selectFirstListBySecondId(secondId);
    }

    public F selectFirstOneBySecondId(int secondId) {
        List<F> list = manyToManyMapper.selectFirstListBySecondId(secondId);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public List<S> selectSecondListByFirstId(int firstId) {
        return manyToManyMapper.selectSecondListByFirstId(firstId);
    }

    public S selectSecondOneByFirstId(int firstId) {
        List<S> list = manyToManyMapper.selectSecondListByFirstId(firstId);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }


}
