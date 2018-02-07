package com.diego.dbConnection;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.diego.model.Artist;
import com.diego.model.SongArtist;
import com.diego.Contants.GeneralNames;
import com.diego.RepositorioImplementado.*;
import org.apache.commons.collections.CollectionUtils;
public class Main implements GeneralNames {
			
	public static void main(String[] args) {
		DataSource datasource=new DataSource();
		if(!datasource.open()){
			System.out.println("Can't open connection");
			return;
		}
//		List<Artist> artists= datasource.getArstistList(ORDER_BY_ASC);
//		if(artists == null){
//			System.out.println("No Artists!");
//			return;
//		}
//		artists.forEach(artist->{
//			System.out.println("ID= " + artist.getId() + " Name= " + artist.getName()   );
//		});
//
//		System.out.println("Finished Artists.............................................................");
//		List<String> albums= datasource.getAlbumsList("Grate", ORDER_BY_ASC);
		List<String> albums= datasource.getAlbumsList("Everly Brothers", ORDER_BY_ASC);
		if(albums == null){
			System.out.println("No albums!");
			return;
		}
		albums.forEach(album->{
			System.out.println(album);
		});
//		
//		System.out.println("Finish albums.............................................................");
//		List<SongArtist> artistSongs= datasource.queryArtistForSong("She's On Fire", ORDER_BY_ASC);
//		if(artistSongs == null){
//			System.out.println("No artistSongs!");
//			return;
//		}
//		artistSongs.forEach(artist->{
//			System.out.println("ArtistName: " + artist.getArtistName() +
//								" AlbumName: " + artist.getAlbumName() +
//								" Track: " + artist.getTrack());
//		});
//		System.out.println("Finish artistSongs .............................................................");
//		datasource.querySongsMetaData();
//		System.out.println("Finish MetaData .............................................................");
//		
//		int count =datasource.getCount(TABLE_SONGS);
//		System.out.println("Number of songs is: " + count);
//		if(datasource.createViewForSongArtists()){
//			System.out.println("The View Was Created Success");
//		}
//		
//		Scanner scanner=new Scanner(System.in);
//		System.out.println("Enter a song title: ");
//		String title= scanner.nextLine();
//		scanner.close();
//		//"Go Your Own Way"
//		// Go Your Own Way" or 1=1 or "
//		List<SongArtist> songInfoView= datasource.querySongInfoView(title);
//		if(CollectionUtils.isEmpty(songInfoView)){
//			System.out.println("No songInfoView!");
//			return;
//		}
//		songInfoView.forEach(songs->{
//			System.out.println("ArtistName: " + songs.getArtistName() +
//					" AlbumName: " + songs.getAlbumName() +
//					" Track: " + songs.getTrack());
//		});
//		
//		System.out.println("Finish songInfoView .............................................................");
//		
//		datasource.insertSong(title, artist, album, track);
//		datasource.insertSong("Bird Dog", "Everly Brothers", "All-Time Greatest Hits", 7);
//		datasource.insertSong("Touch of Grey", "Grateful Dead", "In the Dark", 1);
//		datasource.insertSong("Red of Diego", "Grate", "In the Blue", 3);
		
		datasource.close();
		
	}
	
	public static <T> boolean isNullOrEmpty(Collection<T> list){
		return list == null || list.isEmpty(); 
	}
}
