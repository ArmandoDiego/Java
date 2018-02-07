package com.diego.dbConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.diego.Contants.GeneralNames;
import com.diego.model.Artist;
import com.diego.model.SongArtist;
import com.diego.repository.GeneralQueries;

public class DataSource implements GeneralNames,GeneralQueries {
	
	private Connection dbConnection;
	
	private PreparedStatement querySongInfoView;
	
	private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;
	
	public boolean open(){
		try {
			dbConnection = DriverManager.getConnection(CONNECTION_STRING);
			querySongInfoView = dbConnection.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
			insertIntoArtists = dbConnection.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
	        insertIntoAlbums = dbConnection.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
	        insertIntoSongs = dbConnection.prepareStatement(INSERT_SONGS);
	        queryArtist = dbConnection.prepareStatement(QUERY_ARTIST);
	        queryAlbum = dbConnection.prepareStatement(QUERY_ALBUM);
			return true;
		} catch (SQLException e) {
			System.out.println("Couldn't connect to database: " + e.getMessage());
			return false;
		}
	}
	
	public void close(){
		try {
			if(querySongInfoView != null) {
	                querySongInfoView.close();
	        }
			if(insertIntoArtists != null) {
                insertIntoArtists.close();
            }
            if(insertIntoAlbums != null) {
                insertIntoAlbums.close();
            }
            if(insertIntoSongs !=  null) {
                insertIntoSongs.close();
            }
            if(queryArtist != null) {
                queryArtist.close();
            }
            if(queryAlbum != null) {
                queryAlbum.close();
            }
            if(dbConnection != null){
				dbConnection.close();
			}
			
		} catch (SQLException e) {
			System.out.println("Couldn't close the coonection: " + e.getMessage());
		}
	}
	
	public List<Artist> getArstistList(int sortOrder){
		StringBuilder sb=  new StringBuilder(QUERY_ARTISTS);
		if(sortOrder != ORDER_BY_NONE){
			sb.append(QUERY_ARTISTS_SORT);
			if(sortOrder==ORDER_BY_DESC){
				sb.append("DESC");
			}else{ 
				sb.append("ASC");
			}
		}
			try(Statement statement=dbConnection.createStatement();
					ResultSet results=statement.executeQuery(sb.toString())){	
				List<Artist> artists=new ArrayList<>();
				while(results.next()){
					Artist artist = new Artist();
					artist.setId(results.getInt(INDEX_ARTISTS_ID));
					artist.setName(results.getString(INDEX_ARTISTS_NAME));
					artists.add(artist);
				}
				return artists;
			} catch (SQLException e) {
					System.out.println("Query Failded" + e.getMessage());
					return null;
			}
	}
	/*select albums.name from albums INNER JOIN artists ON albums.artist = artists._id WHERE artists.name ="Carole King"
		ORDER BY albums.name COLLATE NOCASE ASC
	 */
	public List<String> getAlbumsList(String artistName,int sortOrder)
	{
		StringBuilder sb=  new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
		sb.append(artistName);
		sb.append("\"");
		if(sortOrder != ORDER_BY_NONE){
			sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
			if(sortOrder==ORDER_BY_DESC){
				sb.append("DESC");
			}else{ 
				sb.append("ASC");
			}
		}
			try(Statement statement=dbConnection.createStatement();
					ResultSet results=statement.executeQuery(sb.toString())){	
				List<String> albums=new ArrayList<>();
				while(results.next()){
					albums.add(results.getString(1));
				}
				return albums;
			} catch (SQLException e) {
					System.out.println("Query Failded" + e.getMessage());
					return null;
			}
	}
	
	public List<SongArtist> queryArtistForSong(String songName, int sortOrder){
		StringBuilder sb= new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
		sb.append(songName);
		sb.append("\"");
		if(sortOrder != ORDER_BY_NONE){
			sb.append(QUERY_ARTIST_FOR_SONG_SORT);
			if(sortOrder==ORDER_BY_DESC){
				sb.append("DESC");
			}else{ 
				sb.append("ASC");
			}
		}

		try(Statement statement=dbConnection.createStatement();
				ResultSet results=statement.executeQuery(sb.toString())){	
			List<SongArtist> songsArtistsList=new ArrayList<>();
			while(results.next()){
				SongArtist songsArtist=new SongArtist();
				songsArtist.setArtistName(results.getString(1));
				songsArtist.setAlbumName(results.getString(2));
				songsArtist.setTrack(results.getString(3));
				songsArtistsList.add(songsArtist);
			}
			return songsArtistsList;
		} catch (SQLException e) {
				System.out.println("Query Failded" + e.getMessage());
				return null;
		}
	}
	
	public void querySongsMetaData(){
		String sql= "SELECT * FROM " + TABLE_SONGS;
		try(Statement statement=dbConnection.createStatement();
				ResultSet results=statement.executeQuery(sql)){	
			
			ResultSetMetaData meta= results.getMetaData();
			int numColumns= meta.getColumnCount();
			for (int i = 1; i <= numColumns; i++) {
				System.out.format("Column %d in the songs table is name %s\n",
						i, meta.getColumnName(i));
			}
		} catch (SQLException e) {
				System.out.println("Query Failded " + e.getMessage());
		}
		
	}
	
	public int getCount(String table){
//		String sql= "SELECT COUNT(*) as count, MIN(_id) as min_id FROM " + table;
		String sql= "SELECT COUNT(*) as count FROM " + table;
		try(Statement statement = dbConnection.createStatement();
				ResultSet results = statement.executeQuery(sql)){
					int count= results.getInt("count");
//					int min= results.getInt("min_id");
//					System.out.format("Count = %d, Min = %d\n", count, min);
					System.out.format("Count = %d\n", count);
					return count;
		}catch (SQLException e) {
			System.out.println("Query failed"+ e.getMessage());
			return -1;
		}
	}
	
	public boolean createViewForSongArtists() {
        try(Statement statement = dbConnection.createStatement()) {
            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;
        } catch(SQLException e) {
            System.out.println("Create View failed: " + e.getMessage());
            return false;
        }
    }
	
//	public List<SongArtist> querySongInfoView(String title) {
//        StringBuilder sb = new StringBuilder(QUERY_VIEW_SONG_INFO);
//        sb.append(title);
//        sb.append("\"");
//       System.out.println(sb.toString());
//       try (Statement statement = dbConnection.createStatement();
//            ResultSet results = statement.executeQuery(sb.toString())) {
//           List<SongArtist> songArtists = new ArrayList<>();
//           while(results.next()) {
//               SongArtist songArtist = new SongArtist();
//               songArtist.setArtistName(results.getString(1));
//               songArtist.setAlbumName(results.getString(2));
//               songArtist.setTrack(results.getString(3));
//               songArtists.add(songArtist);
//           }
//           return songArtists;
//       } catch(SQLException e) {
//           System.out.println("Query failed: " + e.getMessage());
//           return null;
//       }
//   }
	
	public List<SongArtist> querySongInfoView(String title) {
        try {
            querySongInfoView.setString(1, title);
            ResultSet results = querySongInfoView.executeQuery();

            List<SongArtist> songArtists = new ArrayList<>();
            while (results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getString(3));
                songArtists.add(songArtist);
            }
            return songArtists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
	private int insertArtist(String name) throws SQLException {

        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();
        if(results.next()) {
            return results.getInt(1);
        } else {
            // Insert the artist
            insertIntoArtists.setString(1, name);
            int affectedRows = insertIntoArtists.executeUpdate();
            if(affectedRows != 1) {
                throw new SQLException("Couldn't insert artist!");
            }
            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for artist");
            }
        }
    }

    private int insertAlbum(String name, int artistId) throws SQLException {

        queryAlbum.setString(1, name);
        ResultSet results = queryAlbum.executeQuery();
        if(results.next()) {
            return results.getInt(1);
        } else {
            // Insert the album
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistId);
            int affectedRows = insertIntoAlbums.executeUpdate();

            if(affectedRows != 1) {
                throw new SQLException("Couldn't insert album!");
            }

            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for album");
            }
        }
    }

    public void insertSong(String title, String artist, String album, int track) {
        try {
        	dbConnection.setAutoCommit(false);
            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);
            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumId);
            int affectedRows = insertIntoSongs.executeUpdate();
            if(affectedRows == 1) {
            	dbConnection.commit();
            } else {
                throw new SQLException("The song insert failed");
            }
        } catch(Exception e) {
            System.out.println("Insert song exception: " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                dbConnection.rollback();
            } catch(SQLException e2) {
                System.out.println("Oh boy! Things are really bad! " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior");
                dbConnection.setAutoCommit(true);
            } catch(SQLException e) {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }

        }
    }
	
}

	
