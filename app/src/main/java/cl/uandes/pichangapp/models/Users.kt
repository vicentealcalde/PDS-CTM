package cl.uandes.pichangapp.models
import cl.uandes.pichangapp.R

val user = ArrayList<User>()

class Users {
    companion object {
        fun createUserList() : ArrayList<User> {
            user.add(User("Guapos", "ciconchap@gmail.com", " ", "Masculino", R.drawable.extra_logo_cris,2,0,2,0 ))
            user.add(User("Camicamiones", "cami@gmail.com", "camimi", "Femenina", R.drawable.extra_logo_cami,2,1,1,0))
            user.add(User("AlcaldeFc", "alcalde@gmail.com", "alcalde", "Masculino",R.drawable.extra_logo_alcalde,2,2,0,0))
            user.add(User("a", "a", "a", "Masculino",R.drawable.extra_logo_alcalde,2,2,0,0))

            return user
        }

        fun createUser(name: String, mail: String, password: String, categorie: String,image: Int):ArrayList<User>{
            user.add(User(name, mail, password,categorie ,image))
            return user
        }
    }
}
