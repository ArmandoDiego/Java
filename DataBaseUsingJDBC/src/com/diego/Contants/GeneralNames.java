package com.diego.Contants;

public interface GeneralNames {
		
	public static final String DB_NAME="music.db";
	public static final String CONNECTION_STRING="jdbc:sqlite:C:\\Users\\HP\\Documents\\java\\" + DB_NAME;
	
	public static final String TABLE_ALBUMS="albums";
	public static final String COLUMN_ALBUM_ID="_id";
	public static final String COLUMN_ALBUM_NAME="name";
	public static final String COLUMN_ALBUM_ARTIST="artist";
	public static final int INDEX_ALBUM_ID=1; 	
	public static final int INDEX_ALBUM_NAME=2; 	
	public static final int INDEX_ALBUM_ARTIST=3; 	
	
	public static final String TABLE_ARTISTS="artists";
	public static final String COLUMN_ARTIST_ID="_id";
	public static final String COLUMN_ARTIST_NAME="name";
	public static final int INDEX_ARTISTS_ID=1; 	
	public static final int INDEX_ARTISTS_NAME=2; 	

	public static final String TABLE_SONGS="songs";
	public static final String COLUMN_SONG_ID="track";
	public static final String COLUMN_SONG_TRACK="track";
	public static final String COLUMN_SONG_TITLE="title";
	public static final String COLUMN_SONG_ALBUM="album";
	public static final int INDEX_SONG_ID=1; 
	public static final int INDEX_SONG_TRACK=2; 	
	public static final int INDEX_SONG_TITLE=3; 
	public static final int INDEX_SONG_ALBUM=4; 
	
	public static final int ORDER_BY_NONE=1; 
	public static final int ORDER_BY_ASC=2; 
	public static final int ORDER_BY_DESC=3; 
	
}
