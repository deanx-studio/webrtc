package com.mdnet.travel.core.weixin.message.resp;

import com.mdnet.travel.core.weixin.pojo.Music;

/**
 * 音乐消息
 * 
 * @author ldy
 * 
 */
public class MusicMessage extends BaseMessage {
	// 音乐  
    private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
    
}
