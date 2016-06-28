package com.tomtop.member.service;

import java.util.List;

import com.tomtop.member.models.bo.Page;
import com.tomtop.member.models.dto.Broadcast;

public interface IBroadcastService {

	public List<Broadcast> selectBroadcasts();

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            每页数据大小
	 * @return Page<Broadcast>
	 */
	public Page<Broadcast> selectBroadcastsForPage(String userId, int page, int pageSize);

	/**
	 * 删除我的广播消息
	 * 
	 * @param broadcastId
	 *            broadcastId
	 * @return 1-操作成功 0-失败
	 */
	public int deleteMyBroadcastMessage(String userId, int broadcastId);

	/**
	 * 已阅我的广播消息
	 * 
	 * @param broadcastId
	 *            broadcastId
	 * @return 操作是否成功
	 */
	public int readMyBroadcastMessage(String userId, String broadcastId);

	/**
	 * 获取详情
	 * 
	 * @param broadcastId
	 *            broadcastId
	 * @return <code>Broadcast</code>
	 */
	public Broadcast getDetail(String broadcastId);

	/**
	 * 新增消息
	 * 
	 * @return 操作是否成功
	 */
	public int add(Broadcast m);

	/**
	 * 更新操作
	 * 
	 * @param m
	 *            <code>Broadcast</code>
	 * @return 操作是否成功
	 */
	public int update(Broadcast m);

	/**
	 * 推送消息
	 * 
	 * @param m
	 *            <code>Broadcast</code>
	 * @return 操作是否成功
	 */
	public int publish(Broadcast m);

	/**
	 * 删除操作
	 * 
	 * @param id
	 *            id
	 * @return 操作是否成功
	 */
	public int delete(int id);
}

