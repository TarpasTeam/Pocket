package cn.tarpas.pocket.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

public interface BaseService<T> {
	
	

	public int insert(T pojo);
	
	public int update(T pojo);
	
	public int delete(Integer id);
	
	public List<T> selectList();
	
	public List<T> selectList(T pojo);
	
	/**
	 * 
	 * @param pojo
	 * @param oderBy 排序规则，直接写如"age asc,name desc"
	 * @return
	 */
	public List<T> selectList(T pojo,String orderBy);
	
	public T selectOne(T pojo);
	
    public T selectOne(Integer id);
    
    //判断是否已经存在
    public boolean isExisted(T pojo);
    
    public PageInfo<T> page(int pageNum, int pageSize, T pojo);

    public PageInfo<T> page(int pageNum, int pageSize, T pojo, String orderBy);
	
}
