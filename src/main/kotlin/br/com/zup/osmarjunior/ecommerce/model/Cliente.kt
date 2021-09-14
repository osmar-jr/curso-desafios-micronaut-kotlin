package br.com.zup.osmarjunior.ecommerce.model

class Cliente(val nome: String, val email: String){
    override fun toString(): String {
        return "Cliente(nome='$nome', email='$email')"
    }
}