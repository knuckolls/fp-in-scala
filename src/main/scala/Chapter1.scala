package com.banno.kevin.fpinscala

object Chapter1 {

  def main(args: Array[String]) = {
    println("test")
  }

}


// ==============================
// working along side the chapter
// ==============================

case class Coffee(price: Int = 5)

case class CreditCard(cardNumber: String)

case class Charge(cc: CreditCard, amount: Int) {
  def combine(other: Charge): Charge = 
    if (cc == other.cc)
      Charge(cc, amount + other.amount)
    else 
      throw new Exception("Can't combine charges to different cards")

}

object Charge {
  def coalesce(charges: List[Charge]): List[Charge] = 
    charges.groupBy(_.cc).values.map(_.reduce(_ combine _)).toList
}

class Cafe {
  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee()
    (cup, Charge(cc, cup.price))
  } 

  def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) = {
    val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
    val (coffees, charges) = purchases.unzip

    (coffees, charges.reduce((c1, c2) => c1.combine(c2)))
  }
}
