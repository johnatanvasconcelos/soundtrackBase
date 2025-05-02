package br.com.johnatan.soundtrackBase;

import br.com.johnatan.soundtrackBase.repository.ArtistRepository;
import br.com.johnatan.soundtrackBase.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoundtrackBaseApplication implements CommandLineRunner {

	@Autowired
	private ArtistRepository artistRepository;
	@Autowired
	private SongRepository songRepository;

	public static void main(String[] args) {
		SpringApplication.run(SoundtrackBaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
