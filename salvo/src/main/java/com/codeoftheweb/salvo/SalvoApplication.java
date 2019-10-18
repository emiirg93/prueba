package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository PR, GameRepository GR, GamePlayerRepository GPR) {
		return (args) -> {
			Player player1 = PR.save(new Player("j.bauer@ctu.gov"));
            Player player2 = PR.save(new Player("c.obrian@ctu.gov"));

            Player player3 = PR.save(new Player("t.almeida@ctu.gov"));
            Player player4 = PR.save(new Player("d.palmer@whitehouse.gov"));

            Game game = GR.save(new Game(LocalDateTime.parse("2019-08-03T18:20:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
            Game game2 = GR.save(new Game(LocalDateTime.parse("2019-08-05T10:12:20", DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
            Game game3 = GR.save(new Game(LocalDateTime.parse("2019-08-02T16:15:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
            Game game4 = GR.save(new Game(LocalDateTime.parse("2019-08-03T12:20:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
            Game game5 = GR.save(new Game(LocalDateTime.parse("2019-08-05T10:10:20", DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
            Game game6 = GR.save(new Game(LocalDateTime.parse("2019-08-02T11:18:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME)));

            GPR.save(new GamePlayer(game,player1,game.getCreationDate()));
            GPR.save(new GamePlayer(game,player2,game.getCreationDate()));

            GPR.save(new GamePlayer(game2,player2,game.getCreationDate()));
            GPR.save(new GamePlayer(game2,player1,game.getCreationDate()));

            GPR.save(new GamePlayer(game3,player3,game.getCreationDate()));
            GPR.save(new GamePlayer(game3,player2,game.getCreationDate()));

            GPR.save(new GamePlayer(game4,player1,game.getCreationDate()));
            GPR.save(new GamePlayer(game4,player2,game.getCreationDate()));

            GPR.save(new GamePlayer(game5,player3,game.getCreationDate()));
            GPR.save(new GamePlayer(game5,player1,game.getCreationDate()));

            GPR.save(new GamePlayer(game6,player4,game.getCreationDate()));
            GPR.save(new GamePlayer(game6,player3,game.getCreationDate()));
        };
	}
}
