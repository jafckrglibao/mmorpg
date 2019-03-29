package com.kingston.mmorpg.game.player.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.kingston.mmorpg.common.util.ConcurrentHashSet;
import com.kingston.mmorpg.framework.net.socket.IoSession;
import com.kingston.mmorpg.game.player.message.ResPlayerLogin;
import com.kingston.mmorpg.game.scene.actor.Player;

@Service
public class PlayerService {
	
	public static final short CMD_REQ_LOGIN = 1;
	
	public static final short CMD_RES_LOGIN = 201;
	
	/**
	 * 在线玩家列表
	 */
	private Set<Long> onlines = new ConcurrentHashSet<>();
	

	@Cacheable(cacheNames = "player")
	public Player getPlayer(long id) {
		return new Player();
	}
	
	public ResPlayerLogin login(IoSession session, long playerId) {
		Player player = new Player();
		session.bindDipatcher(player);
		return new ResPlayerLogin();
	}
	
	public Set<Long> getOnlienPlayers() {
		return new HashSet<>(this.onlines);
	}
	
	public void addExp(Player player, long exp) {
		
		
	}
	
}
