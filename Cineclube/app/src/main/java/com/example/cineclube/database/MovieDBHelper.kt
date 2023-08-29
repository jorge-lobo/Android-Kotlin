package com.example.cineclube.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.cineclube.model.MovieModel

class MovieDBHelper(context: Context) : SQLiteOpenHelper(context, "movieDatabase.db", null, 1) {

    val sql = arrayOf(
        "CREATE TABLE movies (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, date DATE, place TEXT, poster TEXT, year INTEGER, director TEXT, cast1 TEXT, cast2 TEXT, cast3 TEXT, genre TEXT, duration INTEGER, imdb DOUBLE, plot TEXT)",
        "INSERT INTO movies (title, date, place, poster, year, director, cast1, cast2, cast3, genre, duration, imdb, plot) " +
                "VALUES ('Full Metal Jacket','2023-09-23','Braga','p1',1987," +
                "'Stanley Kubrick','Matthew Modine','R. Lee Ermey','Vincent D''Onofrio','Drama',166,8.3," +
                "'Um olhar de dois segmentos sobre o efeito da mentalidade militar e da própria guerra nos fuzileiros navais da era da guerra do Vietnam. A primeira metade segue um grupo de recrutas no campo de treinos sob o comando do punitivo sargento Hartman. A segunda metade mostra um desses recrutas, Joker, cobrindo a guerra como correspondente do Stars and Stripes, com foco na ofensiva do Tet.')",
        "INSERT INTO movies (title, date, place, poster, year, director, cast1, cast2, cast3, genre, duration, imdb, plot) " +
                "VALUES ('Indiana Jones and the Last Crusade','2023-09-15','Famalicão','p2',1989," +
                "'Steven Spielberg','Harrison Ford','Sean Connery','Alison Doody','Acção',127,8.2," +
                "'Um colecionador de arte apela a Indiana Jones para embarcar em uma busca pelo Santo Graal. Ele descobre que outro arqueólogo desapareceu enquanto procurava o precioso cálice, e o homem desaparecido é seu próprio pai, Dr. Henry Jones. O artefacto é muito mais difícil de encontrar do que eles esperavam, e seus poderes são demais para aqueles que possuem um coração impuro.')",
        "INSERT INTO movies (title, date, place, poster, year, director, cast1, cast2, cast3, genre, duration, imdb, plot) " +
                "VALUES ('Léon','2023-09-08','Braga','p3',1994," +
                "'Luc Besson','Jean Reno','Gary Oldman','Natalie Portman','Acção',110,8.5," +
                "'Léon vive uma vida solitária em Nova York, trabalhando como assassino profissional para a máfia. Quase silencioso e totalmente implacável, Léon não parece possuir um pingo de humanidade. Mas quando a sua vizinha de 12 anos, Mathilda, chega a casa e encontra toda a família massacrada por um traficante de drogas, Léon acolhe-a e, a pedido dela, ensina-lhe as ferramentas de seu ofício para que ela possa se vingar do assassino de sua família.')",
        "INSERT INTO movies (title, date, place, poster, year, director, cast1, cast2, cast3, genre, duration, imdb, plot) " +
                "VALUES ('Pulp Fiction','2023-09-02','Guimarães','p4',1994," +
                "'Quentin Tarantino','John Travolta','Uma Thurman','Samuel L. Jackson','Crime',154,8.9," +
                "'Jules Winnfield e Vincent Vega são dois assassinos que tentam recuperar uma mala roubada do seu patrão, o chefe da máfia Marsellus Wallace. Este pede a Vincent para levar a sua esposa Mia para sair alguns dias depois, quando ele estiver fora da cidade. Butch Coolidge é um veterano lutador de boxe que é pago por Wallace para perder de propósito a sua luta. As vidas dessas pessoas aparentemente não relacionadas são tecidas numa série de incidentes engraçados, bizarros e desnecessários.')",
        "INSERT INTO movies (title, date, place, poster, year, director, cast1, cast2, cast3, genre, duration, imdb, plot) " +
                "VALUES ('The Big Lebowski','2023-09-24','Famalicão','p5',1998," +
                "'Joel & Ethan Coen','Jeff Bridges','John Goodman','Julianne Moore','Comédia',117,8.1," +
                "'Quando The Dude Lebowski é confundido com o milionário Lebowski, dois bandidos urinam no seu tapete para coagi-lo a pagar uma dívida da qual ele nada sabe. Enquanto tenta obter uma recompensa do seu homónimo rico pelo tapete arruinado, ele aceita um trabalho único com alto retorno. Ele pede ajuda ao seu amigo Walter, um convertido judeu armado com problemas de raiva. A deceção leva a mais problemas, e logo parece que todos, desde magnatas do império porno a niilistas, querem algo do The Dude.')",
        "INSERT INTO movies (title, date, place, poster, year, director, cast1, cast2, cast3, genre, duration, imdb, plot) " +
                "VALUES ('Fight Club','2023-09-16','Braga','p6',1999," +
                "'David Fincher','Brad Pitt','Edward Norton','Helena Bonham Carter','Drama',139,8.8," +
                "'Um narrador anónimo em primeira pessoa frequenta grupos de apoio na tentativa de subjugar o seu estado emocional e aliviar o seu estado de insónia. Quando ele conhece Marla, outra participante falsa de grupos de apoio, sua vida parece se tornar um pouco mais suportável. No entanto, quando ele se associa a Tyler, ele é arrastado para um clube de luta underground e para um esquema de fabrico de sabão. Juntos, os dois homens perdem o controlo e envolvem-se numa rivalidade competitiva por amor e poder.')",
        "INSERT INTO movies (title, date, place, poster, year, director, cast1, cast2, cast3, genre, duration, imdb, plot) " +
                "VALUES ('Snatch','2023-09-09','Guimarães','p7',2000," +
                "'Guy Ritchie','Jason Statham','Brad Pitt','Stephen Graham','Comédia',104,8.2," +
                "'Turkish, um promotor de boxe sem licença mete-se em problemas quando se envolve com o grande criminoso Brick Top, que quer que ele organize uma luta e resolva o problema. Enquanto isso, um roubo de diamante ocorre, mas a pedra de 84 quilates desaparece. Isso leva Avi, o chefe que deveria receber a pedra, a ir a Inglaterra para procurá-la, com a ajuda de seu primo. Após voltas e reviravoltas, as duas situações convergem, numa reação em cadeia de eventos ocorrendo para cada personagem.')",
        "INSERT INTO movies (title, date, place, poster, year, director, cast1, cast2, cast3, genre, duration, imdb, plot) " +
                "VALUES ('Kill Bill: Vol.1','2023-09-03','Famalicão','p8',2003," +
                "'Quentin Tarantino','Uma Thurman','David Carradine','Daryl Hannah','Acção',111,8.2," +
                "'\"The Bride\", era membro do Deadly Viper Assassination Squad liderado por seu amante Bill. Ao perceber que estava grávida do filho de Bill, ela decide abandonar a sua vida como assassina. Ela foge para o Texas, conhece um jovem homem que, no dia do ensaio do casamento, foi morto a tiro por um furioso e ciumento Bill e o grupo. Quatro anos depois, \"The Bride\" acorda do coma e descobre que o seu bebé morreu. Ela, então, decide vingar-se das cinco pessoas que destruíram a sua vida.')",
        "INSERT INTO movies (title, date, place, poster, year, director, cast1, cast2, cast3, genre, duration, imdb, plot) " +
                "VALUES ('Eternal Sunshine of the Spotless Mind','2023-09-17','Guimarães','p9',2004," +
                "'Michel Gondry','Jim Carrey','Kate Winslet','Tom Wilkinson','Drama',108,8.3," +
                "'Joel fica surpreendido ao descobrir que a sua namorada Clementine apagou as suas memórias da relação entre ambos. Desesperado, ele contrata o inventor do processo, Dr. Mierzwiak, para removê-la da sua própria memória. Mas à medida que as sua memórias desaparecem, ele começa a redescobrir a sua paixão anterior e tenta escapar ao procedimento. Enquanto o Dr. Mierzwiak e sua equipa o perseguem através do labirinto de suas memórias, fica claro que ele não consegue tirá-la da sua cabeça.')",
        "INSERT INTO movies (title, date, place, poster, year, director, cast1, cast2, cast3, genre, duration, imdb, plot) " +
                "VALUES ('V for Vendetta','2023-09-01','Braga','p10',2005," +
                "'James McTeigue','Hugo Weaving','Natalie Portman','Rupert Graves','Acção',132,8.2," +
                "'Conta a história de Evey Hammond e seu papel improvável, mas fundamental, no derrube do governo fascista que assumiu o controle de uma Grã-Bretanha futurista. Salva de uma situação de vida ou morte por um homem com uma máscara de Guy Fawkes que se autodenomina \"V\". Ela descobre o passado de V e, depois de um tempo, decide ajudá-lo a derrubar aqueles que cometeram as atrocidades que levaram a Grã-Bretanha a estar na forma em que está.')",
        "INSERT INTO movies (title, date, place, poster, year, director, cast1, cast2, cast3, genre, duration, imdb, plot) " +
                "VALUES ('The Prestige','2023-09-22','Guimarães','p11',2006," +
                "'Christopher Nolan','Christian Bale','Hugh Jackman','Scarlett Johansson','Drama',130,8.5," +
                "'No final do século XIX, em Londres, Robert Angier, a sua esposa Julia McCullough e Alfred Borden são amigos e assistentes de um mágico. Quando Julia morre durante uma apresentação, Robert culpa Alfred pela sua morte e eles ficam inimigos. Ambos tornam-se mágicos famosos e rivais, sabotando a atuação do outro em palco. Quando Alfred apresenta um truque bem-sucedido, Robert fica obcecado tentando revelar o segredo do seu concorrente com consequências trágicas.')",
        "INSERT INTO movies (title, date, place, poster, year, director, cast1, cast2, cast3, genre, duration, imdb, plot) " +
                "VALUES ('The Grand Budapest Hotel','2023-09-10','Famalicão','p12',2014," +
                "'Wes Anderson','Ralph Fiennes','F. Murray Abraham','Mathieu Amalric','Aventura',99,8.1," +
                "'Este filme narra as aventuras de M. Gustave, um lendário concierge de um famoso hotel europeu durante o período entre as guerras, e Zero Moustafa, o jovem mensageiro que se torna seu amigo de maior confiança. A história envolve o roubo e a recuperação de uma pintura renascentista de valor inestimável e a batalha por uma enorme fortuna familiar - tudo no cenário de um continente em mudança repentina e dramática.')",
    )

    override fun onCreate(dbM: SQLiteDatabase) {
        sql.forEach {
            dbM.execSQL(it)
        }
    }

    override fun onUpgrade(dbM: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertMovie(
        title: String,
        date: String,
        place: String,
        poster: String,
        year: Int,
        director: String,
        cast1: String,
        cast2: String,
        cast3: String,
        genre: String,
        duration: Int,
        imdb: Double,
        plot: String
    ): Long {
        val dbM = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("title", title)
        contentValues.put("date", date)
        contentValues.put("place", place)
        contentValues.put("poster", poster)
        contentValues.put("year", year)
        contentValues.put("director", director)
        contentValues.put("cast1", cast1)
        contentValues.put("cast2", cast2)
        contentValues.put("cast3", cast3)
        contentValues.put("genre", genre)
        contentValues.put("duration", duration)
        contentValues.put("imdb", imdb)
        contentValues.put("plot", plot)

        val res = dbM.insert("movies", null, contentValues)
        dbM.close()
        return res
    }

    fun updateMovie(
        id: Int,
        title: String,
        date: String,
        place: String,
        poster: String,
        year: Int,
        director: String,
        cast1: String,
        cast2: String,
        cast3: String,
        genre: String,
        duration: Int,
        imdb: Double,
        plot: String
    ): Int {
        val dbM = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("title", title)
        contentValues.put("date", date)
        contentValues.put("place", place)
        contentValues.put("poster", poster)
        contentValues.put("year", year)
        contentValues.put("director", director)
        contentValues.put("cast1", cast1)
        contentValues.put("cast2", cast2)
        contentValues.put("cast3", cast3)
        contentValues.put("genre", genre)
        contentValues.put("duration", duration)
        contentValues.put("imdb", imdb)
        contentValues.put("plot", plot)
        val res = dbM.update("movies", contentValues, "id=?", arrayOf((id.toString())))
        dbM.close()
        return res
    }

    fun deleteMovie(id: Int): Int {
        val dbM = this.writableDatabase
        val res = dbM.delete("movies", "id=?", arrayOf((id.toString())))
        dbM.close()
        return res
    }

    fun getMovie(id: Int): MovieModel {
        val dbM = this.readableDatabase
        val c = dbM.rawQuery(
            "SELECT * FROM movies WHERE id=?",
            arrayOf(id.toString())
        )
        var movieModel = MovieModel()

        if (c.count == 1) {
            c.moveToFirst()
            val idIndex = c.getColumnIndex("id")
            val titleIndex = c.getColumnIndex("title")
            val dateIndex = c.getColumnIndex("date")
            val placeIndex = c.getColumnIndex("place")
            val posterIndex = c.getColumnIndex("poster")
            val yearIndex = c.getColumnIndex("year")
            val directorIndex = c.getColumnIndex("director")
            val cast1Index = c.getColumnIndex("cast1")
            val cast2Index = c.getColumnIndex("cast2")
            val cast3Index = c.getColumnIndex("cast3")
            val genreIndex = c.getColumnIndex("genre")
            val durationIndex = c.getColumnIndex("duration")
            val imdbIndex = c.getColumnIndex("imdb")
            val plotIndex = c.getColumnIndex("plot")

            movieModel = MovieModel(
                id = c.getInt(idIndex),
                title = c.getString(titleIndex),
                date = c.getString(dateIndex),
                place = c.getString(placeIndex),
                poster = c.getString(posterIndex),
                year = c.getInt(yearIndex),
                director = c.getString(directorIndex),
                cast1 = c.getString(cast1Index),
                cast2 = c.getString(cast2Index),
                cast3 = c.getString(cast3Index),
                genre = c.getString(genreIndex),
                duration = c.getInt(durationIndex),
                imdb = c.getDouble(imdbIndex),
                plot = c.getString(plotIndex)
            )
        }
        dbM.close()
        return movieModel
    }

    fun getAllMovie(): ArrayList<MovieModel> {
        val dbM = this.readableDatabase
        val c = dbM.rawQuery("SELECT * FROM movies", null)
        var listMovieModel = ArrayList<MovieModel>()

        if (c.count > 0) {
            c.moveToFirst()
            val idIndex = c.getColumnIndex("id")
            val titleIndex = c.getColumnIndex("title")
            val dateIndex = c.getColumnIndex("date")
            val placeIndex = c.getColumnIndex("place")
            val posterIndex = c.getColumnIndex("poster")
            val yearIndex = c.getColumnIndex("year")
            val directorIndex = c.getColumnIndex("director")
            val cast1Index = c.getColumnIndex("cast1")
            val cast2Index = c.getColumnIndex("cast2")
            val cast3Index = c.getColumnIndex("cast3")
            val genreIndex = c.getColumnIndex("genre")
            val durationIndex = c.getColumnIndex("duration")
            val imdbIndex = c.getColumnIndex("imdb")
            val plotIndex = c.getColumnIndex("plot")

            do {
                val movieModel = MovieModel(
                    id = c.getInt(idIndex),
                    title = c.getString(titleIndex),
                    date = c.getString(dateIndex),
                    place = c.getString(placeIndex),
                    poster = c.getString(posterIndex),
                    year = c.getInt(yearIndex),
                    director = c.getString(directorIndex),
                    cast1 = c.getString(cast1Index),
                    cast2 = c.getString(cast2Index),
                    cast3 = c.getString(cast3Index),
                    genre = c.getString(genreIndex),
                    duration = c.getInt(durationIndex),
                    imdb = c.getDouble(imdbIndex),
                    plot = c.getString(plotIndex)
                )
                listMovieModel.add(movieModel)
            } while (c.moveToNext())
        }
        dbM.close()
        return listMovieModel
    }
}

