package cl.uandes.pichangapp.models
import cl.uandes.pichangapp.R

val match = ArrayList<Match>()


class Matches {
    companion object {
        fun createMatchList() : ArrayList<Match> {
            match.add(Match("ciconchap@gmail.com","cami@gmail.com",
                false,2,0,"2 - 0",
                "Arturo Pratt 2103","Partido a pata pelada",
                "12:40","12/05/2012"))

            match.add(Match("alcalde@gmail.com","ciconchap@gmail.com",
            true,3,2,"3 - 2","Las quebradas",
            "6 contra 6 a muerte","3:30","12/2/2050"))

            match.add(Match("cami@gmail.com","alcalde@gmail.com",
                true,2,3,"2 - 3","San carlos",
                "amistoso para entrenar","2:45","2/07/2012"))

            match.add(Match("ciconchap@gmail.com","alcalde@gmail.com",
                false,0,0,"0 - 0","Las onduras 20346",
                "6 contra 6 a muerte","7:30","1/2/2050"))

            match.add(Match("cami@gmail.com","ciconchap@gmail.com",
                true,20,3,"20 - 3","cerro san cristobal",
                "amistoso para entrenar con apuesta ","12:45","2/12/2015"))

            match.add(Match("alcalde@gmail.com","cami@gmail.com",
                false,0,0,"1 - 0","pie andino 203",
                "uno a uno","4:30","12/12/2030"))



            return match
        }
        fun createMatch(OrganaizerTeam: String,RivalTeam: String,finish: Boolean ,
                        resultEquip1: Int,resultEquip2: Int,resultTextView: String,
                        LocationOfMatch: String,DescriptionOfMatch: String,
                        HourOfMatch: String,DayOfMatch: String):ArrayList<Match>{

            match.add(Match(OrganaizerTeam,RivalTeam,finish,
                resultEquip1,resultEquip2,resultTextView,LocationOfMatch,
                DescriptionOfMatch,HourOfMatch,DayOfMatch))
            return match
        }
    }



}

