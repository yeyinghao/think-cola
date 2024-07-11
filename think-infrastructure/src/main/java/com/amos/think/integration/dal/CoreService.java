package com.amos.think.integration.dal;


import com.amos.think.integration.dal.model.BaseDP;
import com.amos.think.integration.dal.model.BasePO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 基础数据服务
 *
 * @author yeyinghao
 * @date 2024/04/02
 */
@SuppressWarnings("unused")
public interface CoreService<D extends BaseDP, P extends BasePO> {

	/**
	 * 保存
	 *
	 * @param entity 数据库领域对象
	 */
	void save(D entity);

	/**
	 * 保存
	 *
	 * @param entity 数据库领域对象
	 */
	void saveOrUpdate(D entity);

	/**
	 * 批量保存
	 *
	 * @param entities 数据库领域对象
	 */
	void saveBatch(List<D> entities);

	/**
	 * 根据id删除
	 *
	 * @param id 主键id
	 */
	void deleteById(Long id);

	/**
	 * 根据id列表删除
	 *
	 * @param ids 主键id列表
	 */
	void deleteByIds(List<Long> ids);

	/**
	 * 根据id修改
	 *
	 * @param entity 数据库领域对象
	 */
	void updateById(D entity);

	/**
	 * 根据id查询
	 *
	 * @param id 主键id
	 */
	D findById(Long id);

	/**
	 * 查询所有
	 */
	List<D> findAll();

	/**
	 * 根据id列表查询
	 *
	 * @param ids 主键id列表
	 * @return {@link List}<{@link D}>
	 */
	List<D> findByIds(List<Long> ids);

	/**
	 * 分页查询
	 *
	 * @param page 请求
	 * @return {@link IPage }<{@link D }>
	 */
	IPage<D> listByPage(IPage<P> page);
}
